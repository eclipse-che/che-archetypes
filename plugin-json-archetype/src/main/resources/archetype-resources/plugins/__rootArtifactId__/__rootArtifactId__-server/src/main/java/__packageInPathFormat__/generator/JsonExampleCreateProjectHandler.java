/*
 * Copyright (c) 2012-2017 All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.generator;

import static ${package}.shared.Constants.JSON_EXAMPLE_PROJECT_TYPE_ID;

import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.eclipse.che.api.core.ConflictException;
import org.eclipse.che.api.core.ForbiddenException;
import org.eclipse.che.api.core.NotFoundException;
import org.eclipse.che.api.core.ServerException;
import org.eclipse.che.api.fs.server.FsManager;
import org.eclipse.che.api.fs.server.WsPathUtils;
import org.eclipse.che.api.project.server.ProjectManager;
import org.eclipse.che.api.project.server.handlers.CreateProjectHandler;
import org.eclipse.che.api.project.server.type.AttributeValue;

/**
 * Generates a new project which contains a package.json with default content and a default
 * person.json file within an myJsonFiles folder.
 */
public class JsonExampleCreateProjectHandler implements CreateProjectHandler {

  @Inject private ProjectManager projectManager;

  @Inject private FsManager fsManager;

  private static final String FILE_NAME = "package.json";

  @Override
  public void onCreateProject(
      String wsPath, Map<String, AttributeValue> attributes, Map<String, String> options)
      throws ForbiddenException, ConflictException, ServerException {

    try (InputStream packageJson =
            getClass().getClassLoader().getResourceAsStream("files/default_package");
        InputStream personJson =
            getClass().getClassLoader().getResourceAsStream("files/default_person")) {
      String myJsonFilesDirectory = WsPathUtils.resolve(wsPath, "myJsonFiles");
      fsManager.createDir(myJsonFilesDirectory);

      String packageJsonFile = WsPathUtils.resolve(wsPath, FILE_NAME);
      fsManager.createFile(packageJsonFile, packageJson);

      String personJsonFile = WsPathUtils.resolve(myJsonFilesDirectory, "person.json");
      fsManager.createFile(personJsonFile, personJson);

    } catch (IOException | NotFoundException ioEx) {
      throw new ServerException(ioEx.getLocalizedMessage(), ioEx);
    }
  }

  @Override
  public String getProjectType() {
    return JSON_EXAMPLE_PROJECT_TYPE_ID;
  }
}
