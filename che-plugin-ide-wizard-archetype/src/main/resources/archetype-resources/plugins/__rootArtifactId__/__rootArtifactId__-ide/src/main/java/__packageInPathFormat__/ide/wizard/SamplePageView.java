#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*******************************************************************************
 * Copyright (c) 2012-2017
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package}.ide.wizard;

import com.google.inject.ImplementedBy;

import org.eclipse.che.ide.api.mvp.View;

@ImplementedBy(SamplePageViewImpl.class)
public interface SamplePageView extends View<SamplePageView.ActionDelegate> {

    String getCompilerVersion();

    void setCompilerVersion(String version);


    interface ActionDelegate {
        void onCompilerVersionChanged();

    }
}
