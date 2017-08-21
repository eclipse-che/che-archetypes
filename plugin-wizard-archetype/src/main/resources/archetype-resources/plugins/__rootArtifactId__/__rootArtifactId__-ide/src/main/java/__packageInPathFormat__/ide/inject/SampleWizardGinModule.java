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
package ${package}.ide.inject;

import static ${package}.shared.Constants.C_EXT;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import ${package}.ide.SampleWizardResources;
import ${package}.ide.file.NewXFileView;
import ${package}.ide.file.NewXFileViewImpl;
import ${package}.ide.wizard.SampleWizardRegistrar;
import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;

/** @author Vitalii Parfonov */
@ExtensionGinModule
public class SampleWizardGinModule extends AbstractGinModule {

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    GinMultibinder.newSetBinder(binder(), ProjectWizardRegistrar.class)
        .addBinding()
        .to(SampleWizardRegistrar.class);
    bind(NewXFileView.class).to(NewXFileViewImpl.class).in(Singleton.class);
  }

  @Provides
  @Singleton
  @Named("XFileType")
  protected FileType provideXFile() {
    return new FileType(SampleWizardResources.INSTANCE.xFile(), C_EXT);
  }
}
