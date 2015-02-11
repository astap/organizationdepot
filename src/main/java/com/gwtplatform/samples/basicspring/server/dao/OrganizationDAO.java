package com.gwtplatform.samples.basicspring.server.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gwtplatform.samples.basicspring.shared.object.Organization;

@Component
public interface OrganizationDAO {

    List<Organization> getOrganizationsList();
}
