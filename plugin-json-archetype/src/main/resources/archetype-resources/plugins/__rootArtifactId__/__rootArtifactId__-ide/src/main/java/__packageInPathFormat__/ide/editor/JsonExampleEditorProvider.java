/*
 * Copyright (c) 2012-2017 All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package ${package}.ide.editor;

import javax.inject.Inject;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.ide.api.editor.defaulteditor.AbstractTextEditorProvider;
import org.eclipse.che.ide.api.editor.editorconfig.TextEditorConfiguration;

/** The JSON Example specific {@link EditorProvider}. */
public class JsonExampleEditorProvider extends AbstractTextEditorProvider {

  private JsonExampleEditorConfigurationProvider jsonExampleEditorConfigurationProvider;

  /**
   * @param jsonExampleEditorConfigurationProvider the JSON Example Editor configuration provider
   */
  @Inject
  public JsonExampleEditorProvider(
      final JsonExampleEditorConfigurationProvider jsonExampleEditorConfigurationProvider) {
    this.jsonExampleEditorConfigurationProvider = jsonExampleEditorConfigurationProvider;
  }

  @Override
  public String getId() {
    return "JsonExampleEditor";
  }

  @Override
  public String getDescription() {
    return "JSON Example Editor";
  }

  @Override
  protected TextEditorConfiguration getEditorConfiguration() {
    return jsonExampleEditorConfigurationProvider.get();
  }
}
