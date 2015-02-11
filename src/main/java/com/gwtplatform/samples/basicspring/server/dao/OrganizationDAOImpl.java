package com.gwtplatform.samples.basicspring.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gwtplatform.samples.basicspring.shared.object.Organization;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Organization> getOrganizationsList() {
	List<Organization> organizations = new ArrayList<Organization>();
	organizations.add(new Organization("org1"));
	organizations.add(new Organization("org2"));
	organizations.add(new Organization("org3"));
	return organizations;
    }

}
