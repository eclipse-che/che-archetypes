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
import ${package}.ide.view.UMLExampleView;
import ${package}.ide.view.UMLExampleViewImpl;

/**
 * Example GIN module.
 */
@ExtensionGinModule
public class UMLExampleGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(UMLExampleView.class).to(UMLExampleViewImpl.class);
    }
    
}
