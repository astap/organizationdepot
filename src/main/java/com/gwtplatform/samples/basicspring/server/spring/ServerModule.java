/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.basicspring.server.spring;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.gwtplatform.dispatch.rpc.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.rpc.server.spring.HandlerModule;
import com.gwtplatform.dispatch.rpc.server.spring.LoggerFactoryBean;
import com.gwtplatform.dispatch.rpc.server.spring.actionvalidator.DefaultActionValidator;
import com.gwtplatform.dispatch.rpc.server.spring.configuration.DefaultModule;
import com.gwtplatform.samples.basicspring.server.dispatch.GetOrganizationListHandler;
import com.gwtplatform.samples.basicspring.shared.dispatch.GetOrganizationListAction;

/**
 * Module which binds the handlers and configurations.
 */
@Configuration
@Import(DefaultModule.class)
@ComponentScan(basePackages = "com.gwtplatform.dispatch.rpc.server.spring")
public class ServerModule extends HandlerModule {
    public ServerModule() {
    }

    @Bean
    public ActionValidator getDefaultActionValidator() {
	return new DefaultActionValidator();
    }

    @Bean
    public GetOrganizationListHandler getGetOrganizationListHandler() {
	return new GetOrganizationListHandler();
    }

    @Bean
    public SessionFactory getSessionFactory() {
	return null;
    }

    @Bean
    public LoggerFactoryBean getLogger() {
	Logger logger = Logger.getAnonymousLogger();
	logger.setLevel(Level.FINEST);
	return new LoggerFactoryBean(logger);
    }

    @Override
    protected void configureHandlers() {
	bindHandler(GetOrganizationListAction.class,
		GetOrganizationListHandler.class);
    }
}
