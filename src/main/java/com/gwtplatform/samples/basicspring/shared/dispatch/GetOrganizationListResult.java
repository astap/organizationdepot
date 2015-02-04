package com.gwtplatform.samples.basicspring.shared.dispatch;

import java.util.List;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.gwtplatform.samples.basicspring.shared.object.Organization;

public class GetOrganizationListResult implements Result {

    private static final long serialVersionUID = 3172761847231840880L;
    private List<Organization> organizationList;

    public GetOrganizationListResult() {
    }

    public List<Organization> getOrganizationList() {
	return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
	this.organizationList = organizationList;
    }

}
