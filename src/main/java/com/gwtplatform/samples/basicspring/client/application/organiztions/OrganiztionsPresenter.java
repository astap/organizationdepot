package com.gwtplatform.samples.basicspring.client.application.organiztions;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.samples.basicspring.client.application.response.OrganizationsUiHandlers;
import com.gwtplatform.samples.basicspring.client.place.NameTokens;
import com.gwtplatform.samples.basicspring.shared.object.Organization;

public class OrganiztionsPresenter extends
	Presenter<OrganiztionsPresenter.MyView, OrganiztionsPresenter.MyProxy>
	implements OrganizationsUiHandlers {

    interface MyView extends View {
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_Organiztions = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.organizations)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<OrganiztionsPresenter> {
    }

    @Inject
    OrganiztionsPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
	super(eventBus, view, proxy, RevealType.RootLayout);

    }

    protected void onReveal() {
	super.onReveal();
    }

    @Override
    public void onEdit(Organization organization) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onDelete(Organization organization) {
	// TODO Auto-generated method stub

    }

}