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
package ${package}.ide.wizard;

import static ${package}.shared.Constants.COMPILER_VERSION_ATRIBUTE;
import static ${package}.shared.Constants.DEFAULT_CCC_COMPILER_VERSION;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.wizard.AbstractWizardPage;

public class SamplePagePresenter extends AbstractWizardPage<MutableProjectConfig>
    implements SamplePageView.ActionDelegate {

  protected final SamplePageView view;
  protected final EventBus eventBus;

  @Inject
  public SamplePagePresenter(SamplePageView view, EventBus eventBus) {
    this.view = view;
    this.eventBus = eventBus;
    view.setDelegate(this);
  }

  @Override
  public void init(MutableProjectConfig dataObject) {
    super.init(dataObject);
  }

  @Override
  public void go(AcceptsOneWidget container) {
    container.setWidget(view);
    view.setCompilerVersion(DEFAULT_CCC_COMPILER_VERSION);
    setAttribute(COMPILER_VERSION_ATRIBUTE, DEFAULT_CCC_COMPILER_VERSION);
  }

  @Override
  public void onCompilerVersionChanged() {
    setAttribute(COMPILER_VERSION_ATRIBUTE, view.getCompilerVersion());
  }

  /** Sets single value of attribute of data-object. */
  private void setAttribute(String attrId, String value) {
    Map<String, List<String>> attributes = dataObject.getAttributes();
    attributes.put(attrId, Arrays.asList(value));
    dataObject.setAttributes(attributes);
  }
}
