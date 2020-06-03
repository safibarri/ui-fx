/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of the UI framework based on JavaFx.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.menu {

  requires transitive io.github.mmm.ui.api.menu;

  requires transitive io.github.mmm.ui.fx.window;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.menu.FxFactoryMenuBar, //
      io.github.mmm.ui.fx.factory.menu.FxFactoryNavigationBar //
  ;
}
