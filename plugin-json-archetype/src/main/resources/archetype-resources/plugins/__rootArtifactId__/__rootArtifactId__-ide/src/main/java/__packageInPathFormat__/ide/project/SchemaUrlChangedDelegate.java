/*
 * Copyright (c) 2012-2017 All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.ide.project;

import ${package}.shared.Constants;
import java.util.Collections;
import org.eclipse.che.api.workspace.shared.dto.ProjectConfigDto;
import org.eclipse.che.ide.api.project.MutableProjectConfig;

/** Simple delegate for updating the value of the schema URL. */
public class SchemaUrlChangedDelegate {

  private MutableProjectConfig dataObject;

  /**
   * Constructor that expects the {@link ProjectConfigDto} data object of the project being created.
   *
   * @param dataObject the {@link ProjectConfigDto} data object that holds the current value of the
   *     schema URL
   */
  public SchemaUrlChangedDelegate(MutableProjectConfig dataObject) {
    this.dataObject = dataObject;
  }

  /**
   * Updates the current value of the schema URL.
   *
   * @param url the new URL value
   */
  public void schemaUrlChanged(String url) {
    dataObject
        .getAttributes()
        .put(Constants.JSON_EXAMPLE_SCHEMA_REF_ATTRIBUTE, Collections.singletonList(url));
  }
}
