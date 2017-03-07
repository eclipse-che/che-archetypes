/*******************************************************************************
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package}.ide.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import ${package}.ide.view.HelloWorldView;
import ${package}.ide.view.HelloWorldViewImpl;

/**
 * @author Mathias Schaefer <mathias.schaefer@eclipsesource.com>
 */
@ExtensionGinModule
public class HelloWorldViewExampleGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(HelloWorldView.class).to(HelloWorldViewImpl.class);
    }
    
}
