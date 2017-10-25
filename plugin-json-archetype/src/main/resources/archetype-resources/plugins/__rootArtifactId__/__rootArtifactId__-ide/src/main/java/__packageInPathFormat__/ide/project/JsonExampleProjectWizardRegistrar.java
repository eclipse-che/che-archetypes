/*
 * Copyright (c) 2012-2017 All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.ide.project;

import com.google.inject.Inject;
import com.google.inject.Provider;
import ${package}.shared.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.ide.api.wizard.WizardPage;

/** The project wizard for creating a new JSON Example project. */
public class JsonExampleProjectWizardRegistrar implements ProjectWizardRegistrar {

  private final List<Provider<? extends WizardPage<MutableProjectConfig>>> wizardPagesProviders;

  /**
   * Constructor for JSON Example project wizard.
   *
   * @param schemaUrlWizardPageProvider the schema URL wizard page provider
   */
  @Inject
  public JsonExampleProjectWizardRegistrar(
      Provider<SchemaUrlWizardPage> schemaUrlWizardPageProvider) {
    wizardPagesProviders = new ArrayList<>();
    wizardPagesProviders.add(schemaUrlWizardPageProvider);
  }

  @NotNull
  public String getProjectTypeId() {
    return Constants.JSON_EXAMPLE_PROJECT_TYPE_ID;
  }

  @NotNull
  public String getCategory() {
    return Constants.JSON_EXAMPLE_CATEGORY;
  }

  @NotNull
  public List<Provider<? extends WizardPage<MutableProjectConfig>>> getWizardPages() {
    return wizardPagesProviders;
  }
}
