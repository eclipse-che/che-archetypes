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
package ${package}.agent;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.api.agent.shared.model.impl.BasicAgent;

import java.io.IOException;

/**
 * Sample agent.
 */
@Singleton
public class SampleAgent extends BasicAgent {
    private static final String AGENT_DESCRIPTOR = "${package}.sample.json";
    private static final String AGENT_SCRIPT     = "${package}.sample.script.sh";

    @Inject
    public SampleAgent() throws IOException {
        super(AGENT_DESCRIPTOR, AGENT_SCRIPT);
    }
}
