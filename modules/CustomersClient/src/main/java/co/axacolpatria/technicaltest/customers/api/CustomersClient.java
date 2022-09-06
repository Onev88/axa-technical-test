package co.axacolpatria.technicaltest.customers.api;

import com.liferay.portal.kernel.json.JSONObject;

import co.axacolpatria.technicaltest.customers.model.Customers;

public interface CustomersClient {
	
	JSONObject getCustomers();
	JSONObject saveCustomer(Customers customer);
	
}