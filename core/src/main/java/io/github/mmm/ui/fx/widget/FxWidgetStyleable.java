/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.datatype.UiStyles;
import io.github.mmm.ui.api.widget.UiWidget;
import javafx.collections.ObservableList;
import javafx.css.Styleable;

/**
 * Implementation of {@link UiWidget} for JavaFx based on {@link Styleable}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetStyleable<W extends Styleable> extends FxWidget<W> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidgetStyleable(W widget) {

    super(widget);
  }

  @Override
  public Styleable getTopWidget() {

    return this.widget;
  }

  @Override
  protected UiStyles createStyles() {

    return new Styles(this.widget.getStyleClass());
  }

  private static class Styles implements UiStyles {

    private final ObservableList<String> styles;

    private Styles(ObservableList<String> styles) {

      super();
      this.styles = styles;
    }

    @Override
    public String get() {

      StringBuilder sb = new StringBuilder();
      String separator = "";
      for (String style : this.styles) {
        sb.append(separator);
        sb.append(style);
        separator = " ";
      }
      return sb.toString();
    }

    @Override
    public void set(String styles) {

      this.styles.clear();
      this.styles.addAll(styles.split(" "));
    }

    @Override
    public boolean add(String style) {

      if (this.styles.contains(style)) {
        return false;
      }
      return this.styles.add(style);
    }

    @Override
    public boolean remove(String style) {

      return this.styles.remove(style);
    }

    @Override
    public boolean contains(String style) {

      return this.styles.contains(style);
    }

    @Override
    public String getPrimary() {

      if (this.styles.isEmpty()) {
        return null;
      }
      return this.styles.get(0);
    }

    @Override
    public void setPrimary(String primaryStyle) {

      int index = this.styles.indexOf(primaryStyle);
      if (index == 0) {
        return;
      } else if (index > 0) {
        this.styles.remove(index);
      }
      this.styles.add(0, primaryStyle);
    }

  }

}