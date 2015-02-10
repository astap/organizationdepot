package com.gwtplatform.samples.basicspring.client.organiztions;

import java.util.List;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.samples.basicspring.client.place.NameTokens;
import com.gwtplatform.samples.basicspring.client.utils.AsyncCallbackImpl;
import com.gwtplatform.samples.basicspring.shared.dispatch.GetOrganizationListAction;
import com.gwtplatform.samples.basicspring.shared.dispatch.GetOrganizationListResult;
import com.gwtplatform.samples.basicspring.shared.object.Organization;

public class OrganizationsPresenter
	extends
	Presenter<OrganizationsPresenter.MyView, OrganizationsPresenter.MyProxy>
	implements OrganizationsUiHandlers {

    private PlaceManager placeManager;
    private DispatchAsync dispatcher;

    @ProxyStandard
    @NameToken(NameTokens.organizations)
    public interface MyProxy extends ProxyPlace<OrganizationsPresenter> {
    }

    public interface MyView extends View,
	    HasUiHandlers<OrganizationsUiHandlers> {
	void displayOrganizations(List<Organization> organizationList);
    }

    @Inject
    OrganizationsPresenter(EventBus eventBus, MyView view, MyProxy proxy,
	    PlaceManager placeManager, DispatchAsync dispatcher) {
	super(eventBus, view, proxy, RevealType.Root);

	this.placeManager = placeManager;
	this.dispatcher = dispatcher;

	getView().setUiHandlers(this);

    }

    protected void onReveal() {
	dispatcher.execute(new GetOrganizationListAction(),
		new AsyncCallbackImpl<GetOrganizationListResult>() {
		    @Override
		    public void onSuccess(GetOrganizationListResult result) {
			getView().displayOrganizations(
				result.getOrganizationList());
		    }
		});
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