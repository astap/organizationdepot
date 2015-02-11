package com.gwtplatform.samples.basicspring.server.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gwtplatform.samples.basicspring.shared.object.Organization;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Organization> getOrganizationsList() {
	return (List<Organization>) sessionFactory.getCurrentSession()
		.createQuery("from Organization").list();
    }
}
