/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.form.grid;

import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.form.UiFormGroup;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.fx.widget.composite.FxValuedComposite;
import io.github.mmm.ui.fx.widget.panel.AdvancedGridPane;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;

/**
 * Implementation of {@link UiFormGroup} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class FxFormGroup<V> extends FxValuedComposite<AdvancedGridPane, UiInput<?>, V> implements UiFormGroup<V> {

  private final TitledPane topWidget;

  /**
   * The constructor.
   */
  public FxFormGroup() {

    super(new AdvancedGridPane());
    this.topWidget = new TitledPane();
    this.topWidget.setContent(this.widget);
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

  @Override
  public String getName() {

    return this.topWidget.getText();
  }

  @Override
  public void setName(String name) {

    this.topWidget.setText(name);
  }

  @Override
  public boolean isCollapsed() {

    return !this.topWidget.isExpanded();
  }

  @Override
  public void setCollapsed(boolean collapsed) {

    this.topWidget.setExpanded(!collapsed);
  }

  @Override
  public boolean isCollapsible() {

    return this.topWidget.isCollapsible();
  }

  @Override
  public void setCollapsible(boolean collapsible) {

    this.topWidget.setCollapsible(collapsible);
  }

  @Override
  protected void addChildWidget(UiInput<?> child, int index) {

    int rows = this.children.size();
    UiLabel label = child.getNameWidget();
    if ((index == -1) || (index == rows)) {
      this.widget.addRow(rows, getTopNode(label), getTopNode(child));
    } else if (index < rows) {
      this.widget.insertRow(index, getTopNode(label), getTopNode(child));
    }
  }

  @Override
  protected void removeChildWidget(UiInput<?> child, int index) {

    this.widget.removeRow(index);
  }

}
