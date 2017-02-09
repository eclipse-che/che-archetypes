#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package ${package}.ide;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.constraints.Constraints;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import ${package}.ide.action.NewXFileAction;

import static org.eclipse.che.ide.api.action.IdeActions.GROUP_FILE_NEW;

/**
 *
 *
 * */
@Extension(title = "Sample Wizard")
public class SampleWizardExtension {

    public static String X_CATEGORY = "Sample Category";

    @Inject
    public SampleWizardExtension(FileTypeRegistry fileTypeRegistry,
                                 @Named("XFileType") FileType xFile) {
        fileTypeRegistry.registerFileType(xFile);
    }

    @Inject
    private void prepareActions(NewXFileAction newXFileAction,
                                ActionManager actionManager) {

        DefaultActionGroup newFileGroup = (DefaultActionGroup)actionManager.getAction(GROUP_FILE_NEW);

        actionManager.registerAction("newFileActon", newXFileAction);
        newFileGroup.add(newXFileAction, Constraints.FIRST);
    }

}
