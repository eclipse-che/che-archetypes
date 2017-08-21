/*
 * Copyright (c) 2012-2017 All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.projecttype;

import static ${package}.shared.Constants.JSON_EXAMPLE_LANG;
import static ${package}.shared.Constants.JSON_EXAMPLE_PROJECT_TYPE_ID;
import static ${package}.shared.Constants.LANGUAGE;

import com.google.inject.Inject;
import ${package}.shared.Constants;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;

/** The JSON Example project type. */
public class JsonExampleProjectType extends ProjectTypeDef {

  /** Constructor for the JSON example project type. */
  @Inject
  public JsonExampleProjectType() {
    super(JSON_EXAMPLE_PROJECT_TYPE_ID, JSON_EXAMPLE_PROJECT_TYPE_ID, true, false);
    addConstantDefinition(LANGUAGE, LANGUAGE, JSON_EXAMPLE_LANG);
    addVariableDefinition(
        Constants.JSON_EXAMPLE_SCHEMA_REF_ATTRIBUTE, "Referenced base schema", /*required*/ true);
  }
}
