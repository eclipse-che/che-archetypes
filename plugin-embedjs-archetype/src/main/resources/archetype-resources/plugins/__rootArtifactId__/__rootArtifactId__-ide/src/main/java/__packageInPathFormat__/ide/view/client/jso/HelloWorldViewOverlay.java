/*
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.ide.view.client.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * JavaScript overlay to demonstrate a global js function call
 *
 * @author Mathias Schaefer <mathias.schaefer@eclipsesource.com>
 */
public class HelloWorldViewOverlay extends JavaScriptObject {

  protected HelloWorldViewOverlay() {}

  public static final native void sayHello(final Element element, String message) /*-{
        new $wnd.HelloWorld(element, message);
    }-*/;
}
