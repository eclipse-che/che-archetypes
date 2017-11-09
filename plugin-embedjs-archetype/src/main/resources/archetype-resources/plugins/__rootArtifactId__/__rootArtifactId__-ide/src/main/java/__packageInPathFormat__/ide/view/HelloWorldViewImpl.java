/*
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.ide.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import ${package}.ide.view.client.jso.HelloWorldViewOverlay;
import org.eclipse.che.ide.api.parts.base.BaseView;

/** @author Mathias Schaefer <mathias.schaefer@eclipsesource.com> */
public class HelloWorldViewImpl extends BaseView<HelloWorldView.ActionDelegate>
    implements HelloWorldView {

  interface HelloWorldViewImplUiBinder extends UiBinder<Widget, HelloWorldViewImpl> {}

  private static final HelloWorldViewImplUiBinder UI_BINDER =
      GWT.create(HelloWorldViewImplUiBinder.class);

  @UiField FlowPanel helloWorldPanel;

  @Inject
  public HelloWorldViewImpl() {
    setContentWidget(UI_BINDER.createAndBindUi(this));
  }

  @Override
  public void sayHello(String content) {
    HelloWorldViewOverlay.sayHello(helloWorldPanel.getElement(), content);
    helloWorldPanel.setVisible(true);
  }
}
