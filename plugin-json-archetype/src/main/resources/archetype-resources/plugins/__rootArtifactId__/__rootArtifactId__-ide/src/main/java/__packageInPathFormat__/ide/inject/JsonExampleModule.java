/*
 * Copyright (c) 2012-2017 All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.ide.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import ${package}.ide.project.JsonExampleProjectWizardRegistrar;
import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;

/** JSON Example Gin Module for binding the project wizard and helper factories. */
@ExtensionGinModule
public class JsonExampleModule extends AbstractGinModule {

  @Override
  protected void configure() {
    GinMultibinder.newSetBinder(binder(), ProjectWizardRegistrar.class)
        .addBinding()
        .to(JsonExampleProjectWizardRegistrar.class);
  }
}
