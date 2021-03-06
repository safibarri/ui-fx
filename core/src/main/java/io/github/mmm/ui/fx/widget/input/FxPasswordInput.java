/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.widget.input.UiPasswordInput;
import javafx.scene.control.PasswordField;

/**
 * Implementation of {@link UiPasswordInput} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxPasswordInput extends FxStringInput<PasswordField> implements UiPasswordInput {

  /**
   * The constructor.
   */
  public FxPasswordInput() {

    super(new PasswordField());
  }

}
