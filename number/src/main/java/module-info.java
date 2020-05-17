
/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI number widgets based on JavaFx.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.number {

  requires transitive io.github.mmm.ui.api.number;

  requires transitive io.github.mmm.ui.fx.core;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.number.FxFactoryBigDecimalInput, //
      io.github.mmm.ui.fx.factory.number.FxFactoryBigIntegerInput, //
      io.github.mmm.ui.fx.factory.number.FxFactoryDoubleInput, //
      io.github.mmm.ui.fx.factory.number.FxFactoryIntegerInput, //
      io.github.mmm.ui.fx.factory.number.FxFactoryIntegerSlider, //
      io.github.mmm.ui.fx.factory.number.FxFactoryLongInput, //
      io.github.mmm.ui.fx.factory.number.FxFactoryLongSlider //
  ;

}
