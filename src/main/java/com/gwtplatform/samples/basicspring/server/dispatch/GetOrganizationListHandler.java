package com.gwtplatform.samples.basicspring.server.dispatch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.AbstractActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.gwtplatform.samples.basicspring.server.dao.OrganizationDAO;
import com.gwtplatform.samples.basicspring.shared.dispatch.GetOrganizationListAction;
import com.gwtplatform.samples.basicspring.shared.dispatch.GetOrganizationListResult;
import com.gwtplatform.samples.basicspring.shared.object.Organization;

public class GetOrganizationListHandler
	extends
	AbstractActionHandler<GetOrganizationListAction, GetOrganizationListResult> {

    @Autowired
    OrganizationDAO organizationDAO;

    public GetOrganizationListHandler() {
	super(GetOrganizationListAction.class);
    }

    @Override
    public GetOrganizationListResult execute(GetOrganizationListAction action,
	    ExecutionContext context) throws ActionException {
	GetOrganizationListResult result = new GetOrganizationListResult();
	List<Organization> organizations = organizationDAO
		.getOrganizationsList();
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
