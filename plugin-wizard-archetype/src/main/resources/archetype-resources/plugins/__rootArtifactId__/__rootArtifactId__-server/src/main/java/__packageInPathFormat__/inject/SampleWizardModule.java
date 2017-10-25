#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.inject;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import ${package}.projecttype.SampleProjectType;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.eclipse.che.inject.DynaModule;

/** @author Vitaly Parfonov */
@DynaModule
public class SampleWizardModule extends AbstractModule {
  @Override
  protected void configure() {
    Multibinder<ProjectTypeDef> projectTypeMultibinder =
        Multibinder.newSetBinder(binder(), ProjectTypeDef.class);
    projectTypeMultibinder.addBinding().to(SampleProjectType.class);
  }
}
