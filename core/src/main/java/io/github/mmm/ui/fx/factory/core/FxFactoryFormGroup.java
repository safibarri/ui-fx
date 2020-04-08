/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.panel.UiFormGroup;
import io.github.mmm.ui.fx.widget.panel.FxFormGroup;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiFormGroup}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class FxFactoryFormGroup implements UiSingleWidgetFactoryNative<UiFormGroup> {

  @Override
  public Class<UiFormGroup> getType() {

    return UiFormGroup.class;
  }

  @Override
  public UiFormGroup create(UiContext context) {

    return new FxFormGroup(context);
  }

}
