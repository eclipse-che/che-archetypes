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
 * Action for opening a part with framed javascript code.
 */
@Singleton
public class ShowUMLExampleAction extends Action {

    public final static String ACTION_ID = "showUMLExampleAction";

    private WorkspaceAgent workspaceAgent;
    private UMLExamplePresenter umlExamplePresenter;

    @Inject
    public ShowUMLExampleAction(WorkspaceAgent workspaceAgent,
                                UMLExamplePresenter umlExamplePresenter) {
        super("Show example");
        this.workspaceAgent = workspaceAgent;
        this.umlExamplePresenter = umlExamplePresenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        workspaceAgent.openPart(umlExamplePresenter, PartStackType.INFORMATION);
        workspaceAgent.setActivePart(umlExamplePresenter);
    }

}
