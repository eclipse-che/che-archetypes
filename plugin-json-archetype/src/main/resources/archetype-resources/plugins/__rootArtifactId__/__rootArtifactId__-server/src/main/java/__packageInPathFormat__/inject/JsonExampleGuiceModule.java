/*
 * Copyright (c) 2012-2017 All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.inject;

import static com.google.inject.multibindings.Multibinder.newSetBinder;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import ${package}.JsonExampleCompletionService;
import ${package}.JsonLocService;
import ${package}.generator.JsonExampleCreateProjectHandler;
import ${package}.projecttype.JsonExampleProjectType;
import org.eclipse.che.api.project.server.handlers.ProjectHandler;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.eclipse.che.inject.DynaModule;

/** JSON Example Guice module for setting up project type, project wizard and service bindings. */
@DynaModule
public class JsonExampleGuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    Multibinder<ProjectTypeDef> projectTypeDefMultibinder =
        newSetBinder(binder(), ProjectTypeDef.class);
    projectTypeDefMultibinder.addBinding().to(JsonExampleProjectType.class);

    Multibinder<ProjectHandler> projectHandlerMultibinder =
        newSetBinder(binder(), ProjectHandler.class);
    projectHandlerMultibinder.addBinding().to(JsonExampleCreateProjectHandler.class);

    bind(JsonLocService.class);
    bind(JsonExampleCompletionService.class);
  }
}
