/*******************************************************************************
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package}.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.ide.util.loging.Log;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import ${package}.ide.UMLExampleResources;
import ${package}.ide.common.Constants;
import ${package}.ide.view.client.jso.FrameOverlay;

/**
 * UML example presenter.
 *
 */
@Singleton
public class UMLExamplePresenter extends BasePresenter implements UMLExampleView.ActionDelegate {

	private final UMLExampleView umlExampleView;

	private FrameOverlay frame;

	private String[] scrips = {
			GWT.getModuleBaseURL() + Constants.JS_LODASH,
			GWT.getModuleBaseURL() + Constants.JS_BACKBONE,
			GWT.getModuleBaseURL() + Constants.JS_JQUERY,
			GWT.getModuleBaseURL() + Constants.JS_JOINT,
			GWT.getModuleBaseURL() + Constants.JS_UMLEXAMPLE
	};

	@Inject
	public UMLExamplePresenter(final UMLExampleView umlExampleView) {
		this.umlExampleView = umlExampleView;

		frame = new FrameOverlay(umlExampleView.getFrameElement());
	}

	@Override
	public String getTitle() {
		return "UML example";
	}

	@Override
	public SVGResource getTitleImage() {
		return (UMLExampleResources.INSTANCE.icon());
	}

	@Override
	public View getView() {
		return umlExampleView;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(umlExampleView);

		frame.setContent("<body style='padding: 0; margin: 0; overflow: hidden;'>" +
				"<div id='paper' style='position: absolute; background-color: transparent;' />" +
				"</body>");

		frame.injectStyle(GWT.getModuleBaseURL() + Constants.CSS_JOINT);

		frame.injectScripts(scrips, new Callback<Void, Exception>() {
			@Override
			public void onFailure(Exception reason) {
				Log.error(getClass(), reason.getMessage());
			}

			@Override
			public void onSuccess(Void result) {
			}
		});
	}

	public static native void log(String msg) /*-{ console.log(msg); }-*/;

	/**
	 * Adds new State.
	 *
	 * Just to test.
	 * Shows how to call javascript in iframe.
	 */
	public native void newState() /*-{
		var cw = this.@${package}.ide.view.UMLExamplePresenter::frame.@${package}.ide.view.client.jso.FrameOverlay::getFrameWindow()();

        var newState = new cw.uml.State({
                position: { x:340  , y: 90 },
                size: { width: 160, height: 60 },
                name: "new state",
                events: ["doSomething()"],
                attrs: {
                    '.uml-state-body': {
                        fill: 'rgba(48, 208, 198, 0.1)',
                        stroke: 'rgba(48, 208, 198, 0.5)',
                        'stroke-width': 1.5
                    },
                    '.uml-state-separator': {
                        stroke: 'rgba(48, 208, 198, 0.4)'
                    }
                }
			});

        cw.graph.addCells([newState]);
	}-*/;

}
