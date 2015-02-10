package com.gwtplatform.samples.basicspring.client.organiztions;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OrganizationsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
	bindPresenter(OrganizationsPresenter.class,
		OrganizationsPresenter.MyView.class, OrganizationsView.class,
		OrganizationsPresenter.MyProxy.class);
    }
}