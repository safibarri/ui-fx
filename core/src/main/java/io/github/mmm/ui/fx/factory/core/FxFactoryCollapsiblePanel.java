/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.panel.FxCollapsiblePanel;
import io.github.mmm.ui.widget.panel.UiCollapsiblePanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiCollapsiblePanel}.
 *
 * @since 1.0.0
 */
public class FxFactoryCollapsiblePanel implements UiSingleWidgetFactoryNative<UiCollapsiblePanel> {

  @Override
  public Class<UiCollapsiblePanel> getType() {

    return UiCollapsiblePanel.class;
  }

  @Override
  public UiCollapsiblePanel create(UiContext context) {

    return new FxCollapsiblePanel(context);
  }

}