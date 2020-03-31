/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.base.range.WritableRange;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.spi.range.NumericRange;
import io.github.mmm.ui.widget.input.UiSlider;
import io.github.mmm.validation.Validator;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiSlider} using JavaFx {@link Slider}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxSlider<V extends Number> extends FxInput<Slider, V> implements UiSlider<V> {

  private final HBox topWidget;

  private final NumericRange<V> range;

  private final TextField textWidget;

  private String text;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxSlider(UiContext context) {

    super(context, new Slider());
    this.topWidget = new HBox();
    this.textWidget = new TextField();
    this.textWidget.setEditable(false);
    this.topWidget.getChildren().add(this.widget);
    this.topWidget.getChildren().add(this.textWidget);
    this.range = new NumericRange<>(getNumberType());
    this.widget.valueProperty().addListener(this::onValueChange);
    this.textWidget.textProperty().addListener(this::onValueChange);
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

  @Override
  protected <W> void onValueChange(ObservableValue<? extends W> observable, W oldValue, W newValue) {

    if (observable == this.textWidget.textProperty()) {
      try {
        String newText = this.textWidget.getText();
        if (newText.equals(this.text)) {
          return;
        }
        this.text = newText;
        V value = getNumberType().valueOf(this.text);
        this.widget.setValue(value.doubleValue());
      } catch (NumberFormatException e) {
        // TODO
        setValidationFailure("Invalid number");
      }
    } else {
      super.onValueChange(observable, oldValue, newValue);
    }
  }

  @Override
  protected void onValueChanged(boolean programmatic) {

    super.onValueChanged(programmatic);
    if (!programmatic) {
      V value = getValueOrThrow();
      setValueAsText(value);
    }
  }

  private void setValueAsText(V value) {

    String newText = "";
    if (value != null) {
      newText = value.toString();
    }
    this.textWidget.setText(newText);
  }

  /**
   * @return the {@link NumberType} for the underlying {@link Number}.
   */
  protected abstract NumberType<V> getNumberType();

  @Override
  public WritableRange<V> getRange() {

    return this.range;
  }

  @Override
  public V getValueOrThrow() {

    return getNumberType().valueOf(Double.valueOf(this.widget.getValue()));
  }

  @Override
  protected void setValueNative(V value) {

    double v = 0;
    if (value != null) {
      v = this.range.clip(value).doubleValue();
    }
    this.widget.setValue(v);
    setValueAsText(value);
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    super.setValidator(validator);
    this.range.setValidator(validator);
  }

  @Override
  public boolean isTextVisible() {

    return this.textWidget.isVisible();
  }

  @Override
  public void setTextVisible(boolean textVisible) {

    this.textWidget.setVisible(textVisible);
  }

  @Override
  public boolean isTextEditable() {

    return this.textWidget.isEditable();
  }

  @Override
  public void setTextEditable(boolean textEditable) {

    this.textWidget.setEditable(textEditable);
  }

}