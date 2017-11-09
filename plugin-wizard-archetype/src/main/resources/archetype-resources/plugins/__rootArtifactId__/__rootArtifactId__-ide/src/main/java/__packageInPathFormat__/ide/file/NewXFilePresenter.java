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
package ${package}.ide.file;

import static com.google.common.base.Preconditions.checkState;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ${package}.shared.Constants;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.resources.Container;
import org.eclipse.che.ide.api.resources.Resource;
import org.eclipse.che.ide.project.ProjectServiceClient;
import org.eclipse.che.ide.resource.Path;

/**
 * Presenter for creating
 *
 * @author Vitalii Parfonov
 */
@Singleton
public class NewXFilePresenter implements NewXFileView.ActionDelegate {
  private static final String DEFAULT_CONTENT = " ${symbol_pound}include <${symbol_dollar}{header}>";

  private final NewXFileView view;
  private final ProjectServiceClient projectServiceClient;
  private final AppContext appContext;

  @Inject
  public NewXFilePresenter(
      NewXFileView view, AppContext appContext, ProjectServiceClient projectServiceClient) {
    this.appContext = appContext;
    this.view = view;
    this.projectServiceClient = projectServiceClient;
    this.view.setDelegate(this);
  }

  public void showDialog() {
    view.showDialog();
  }

  @Override
  public void onCancelClicked() {
    view.close();
  }

  @Override
  public void onOkClicked() {
    final String fileName = view.getName();
    view.close();
    createClass(fileName);
  }

  private void createClass(String name) {
    String content = DEFAULT_CONTENT.replace("${header}", view.getHeader());
    createSourceFile(name, content);
  }

  private void createSourceFile(final String nameWithoutExtension, final String content) {
    Resource resource = appContext.getResource();
    if (!(resource instanceof Container)) {
      final Container parent = resource.getParent();
      checkState(parent != null, "Parent should be a container");
      resource = parent;
    }
    createFile(resource.getLocation().toString(), nameWithoutExtension, content);
  }

  private void createFile(
      final String path, final String nameWithoutExtension, final String content) {
    projectServiceClient.createFile(
        Path.valueOf(path).append(nameWithoutExtension + '.' + Constants.C_EXT), content);
  }
}
