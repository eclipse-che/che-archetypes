/*******************************************************************************
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package}.ide.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import ${package}.ide.view.UMLExamplePresenter;

/**
 * Action for adding new state inside frame.
 */
@Singleton
public class NewStateAction extends Action {

    public final static String ACTION_ID = "newStateAction";

    private UMLExamplePresenter helloWorldViewPresenter;

    @Inject
    public NewStateAction(UMLExamplePresenter umlExamplePresenter) {
        super("New State");
        this.helloWorldViewPresenter = umlExamplePresenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        helloWorldViewPresenter.newState();
    }

}
