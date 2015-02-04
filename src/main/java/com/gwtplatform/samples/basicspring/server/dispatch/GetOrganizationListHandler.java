package com.gwtplatform.samples.basicspring.server.dispatch;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.AbstractActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.gwtplatform.samples.basicspring.shared.dispatch.GetOrganizationListAction;
import com.gwtplatform.samples.basicspring.shared.dispatch.GetOrganizationListResult;
import com.gwtplatform.samples.basicspring.shared.object.Organization;

public class GetOrganizationListHandler
	extends
	AbstractActionHandler<GetOrganizationListAction, GetOrganizationListResult> {

    public GetOrganizationListHandler() {
	super(GetOrganizationListAction.class);
    }

    @Override
    public GetOrganizationListResult execute(GetOrganizationListAction action,
	    ExecutionContext context) throws ActionException {
	GetOrganizationListResult result = new GetOrganizationListResult();
	List<Organization> organizations = new ArrayList<Organization>();
	organizations.add(new Organization("org1"));
	organizations.add(new Organization("org2"));
	organizations.add(new Organization("org3"));
	result.setOrganizationList(organizations);
	return result;
    }

    @Override
    public Class<GetOrganizationListAction> getActionType() {
	return GetOrganizationListAction.class;
    }

    @Override
    public void undo(GetOrganizationListAction action,
	    GetOrganizationListResult result, ExecutionContext context)
	    throws ActionException {
	// TODO Auto-generated method stub

    }

}
