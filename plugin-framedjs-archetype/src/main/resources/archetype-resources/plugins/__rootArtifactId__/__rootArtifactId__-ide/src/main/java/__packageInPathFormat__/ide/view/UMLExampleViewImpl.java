/*******************************************************************************
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package}.ide.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Frame;
import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * View containing frame with javascript.
 */
public class UMLExampleViewImpl extends BaseView<UMLExampleView.ActionDelegate> implements UMLExampleView {

	interface UMLExampleViewImplUiBinder extends UiBinder<Widget, UMLExampleViewImpl> {
	}

	private final static UMLExampleViewImplUiBinder UI_BINDER = GWT.create(UMLExampleViewImplUiBinder.class);

	@UiField
	Frame frame;

	@Inject
	public UMLExampleViewImpl(PartStackUIResources resources) {
		super(resources);
		setContentWidget(UI_BINDER.createAndBindUi(this));
		setTitle("UML example");
	}

	@Override
	public JavaScriptObject getFrameElement() {
		return frame.getElement();
	}

}
