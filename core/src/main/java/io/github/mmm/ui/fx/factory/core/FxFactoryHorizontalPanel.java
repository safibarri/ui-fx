/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.panel.FxHorizontalPanel;
import io.github.mmm.ui.widget.panel.UiHorizontalPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiHorizontalPanel}.
 *
 * @since 1.0.0
 */
public class FxFactoryHorizontalPanel implements UiSingleWidgetFactoryNative<UiHorizontalPanel> {

  @Override
  public Class<UiHorizontalPanel> getType() {

    return UiHorizontalPanel.class;
  }

  @Override
  public UiHorizontalPanel create(UiContext context) {

    return new FxHorizontalPanel(context);
  }

}
