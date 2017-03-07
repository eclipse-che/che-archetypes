#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*******************************************************************************
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package}.inject;

import com.google.inject.AbstractModule;

import org.eclipse.che.inject.DynaModule;
import ${package}.MyService;

/**
 * Server service example Guice module for setting up a simple service.
 */
@DynaModule
public class ServerServiceGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyService.class);
    }
}
