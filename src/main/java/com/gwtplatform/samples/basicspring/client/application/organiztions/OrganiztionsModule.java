package com.gwtplatform.samples.basicspring.client.application.organiztions;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OrganiztionsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(OrganiztionsPresenter.class, OrganiztionsPresenter.MyView.class, OrganiztionsView.class, OrganiztionsPresenter.MyProxy.class);
    }
}