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
package ${package}.ide.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.notification.NotificationManager;
import org.eclipse.che.ide.api.notification.StatusNotification;


/**
 * Sample action.
 *
 */
@Singleton
public class SampleAction extends Action {

    private final NotificationManager notificationManager;

    @Inject
    public SampleAction(NotificationManager notificationManager) {
        super("Say Hello", "Sample action");
        this.notificationManager = notificationManager;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        notificationManager.notify("Hello form Che!!!", StatusNotification.Status.SUCCESS,  StatusNotification.DisplayMode.FLOAT_MODE);

    }
}
