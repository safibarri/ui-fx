/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.core {

  requires transitive io.github.mmm.ui.spi.core;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.value;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.validation.main;

  requires transitive javafx.controls;

  provides io.github.mmm.ui.api.UiContext with //
      io.github.mmm.ui.fx.FxContext;

  provides io.github.mmm.ui.api.UiScreen with //
      io.github.mmm.ui.fx.FxScreen;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.core.FxFactoryButton, //
      io.github.mmm.ui.fx.factory.core.FxFactoryButtonPanel, //
      io.github.mmm.ui.fx.factory.core.FxFactoryCheckbox, //
      io.github.mmm.ui.fx.factory.core.FxFactoryCollapsiblePanel, //
      io.github.mmm.ui.fx.factory.core.FxFactoryFormGroup, //
      io.github.mmm.ui.fx.factory.core.FxFactoryFormPanel, //
      io.github.mmm.ui.fx.factory.core.FxFactoryHorizontalPanel, //
      io.github.mmm.ui.fx.factory.core.FxFactoryImage, //
      io.github.mmm.ui.fx.factory.core.FxFactoryIntegerInput, //
      io.github.mmm.ui.fx.factory.core.FxFactoryIntegerSlider, //
      io.github.mmm.ui.fx.factory.core.FxFactoryLabel, //
      io.github.mmm.ui.fx.factory.core.FxFactoryPasswordInput, //
      io.github.mmm.ui.fx.factory.core.FxFactoryRadioButton, //
      io.github.mmm.ui.fx.factory.core.FxFactoryRadioChoice, //
      io.github.mmm.ui.fx.factory.core.FxFactorySlot, //
      io.github.mmm.ui.fx.factory.core.FxFactoryScrollPanel, //
      io.github.mmm.ui.fx.factory.core.FxFactoryText, //
      io.github.mmm.ui.fx.factory.core.FxFactoryTextInput, //
      io.github.mmm.ui.fx.factory.core.FxFactoryTextArea, //
      io.github.mmm.ui.fx.factory.core.FxFactoryVerticalPanel //
  ;

  exports io.github.mmm.ui.fx;

  exports io.github.mmm.ui.fx.widget;

  exports io.github.mmm.ui.fx.widget.img;

  exports io.github.mmm.ui.fx.widget.composite;

  exports io.github.mmm.ui.fx.widget.input;

}
