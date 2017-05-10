/*******************************************************************************
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package}.ide;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import static org.eclipse.che.ide.api.action.IdeActions.GROUP_MAIN_MENU;
import org.eclipse.che.ide.api.extension.Extension;
import ${package}.ide.action.NewStateAction;
import ${package}.ide.action.ShowUMLExampleAction;

/**
 * UML example with framed javascript.
 */
@Extension(title = "UML javascript example")
@Singleton
public class UMLExampleExtension {

    @Inject
    private void configureActions(final ActionManager actionManager,
                                  final ShowUMLExampleAction showUMLExampleAction,
                                  final NewStateAction newStateAction) {

        DefaultActionGroup menuGroup = (DefaultActionGroup)actionManager.getAction(GROUP_MAIN_MENU);

        DefaultActionGroup jsGroup = new DefaultActionGroup("UML", true, actionManager);
        menuGroup.add(jsGroup);

        actionManager.registerAction(showUMLExampleAction.ACTION_ID, showUMLExampleAction);
        jsGroup.addAction(showUMLExampleAction);

        actionManager.registerAction(newStateAction.ACTION_ID, newStateAction);
        jsGroup.addAction(newStateAction);
    }

}
