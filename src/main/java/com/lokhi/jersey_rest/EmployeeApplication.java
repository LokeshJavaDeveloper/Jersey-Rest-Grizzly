package com.lokhi.jersey_rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.lokhi.jersey_rest.dao.EmployeeDao;

public class EmployeeApplication extends ResourceConfig {

	public EmployeeApplication(final EmployeeDao dao) {
		packages("com.mindtree.jersey_rest");
		register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(dao).to(EmployeeDao.class);

			}
		});
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}
}