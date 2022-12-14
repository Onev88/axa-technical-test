package co.axacolpatria.technicaltest.customers.portlet.resources;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import co.axacolpatria.technicaltest.customers.api.CustomersClient;
import co.axacolpatria.technicaltest.customers.constants.CustomersPortletKeys;
import co.axacolpatria.technicaltest.customers.model.Customers;

@Component(immediate = true, property = {
		"javax.portlet.name=" + CustomersPortletKeys.CUSTOMERS, 
		"mvc.command.name=" + CustomersPortletKeys.RESOURCE_ADD_CUSTOMER}, service = MVCResourceCommand.class)
public class AddCustomerMVCResourceCommand implements MVCResourceCommand{
	
	@Reference
	private CustomersClient customerClientUtil;
	
	private static final Log LOG = LogFactoryUtil.getLog(AddCustomerMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException {
		// TODO Auto-generated method stub
		
		Customers customer = new Customers();
		
		customer.setName(ParamUtil.getString(request, "name"));
		customer.setAge(ParamUtil.getInteger(request, "age"));
		customer.setPhoneNumber(ParamUtil.getString(request, "phoneNumber",""));
		customer.setAddress(ParamUtil.getString(request, "address",""));
		customerClientUtil.saveCustomer(customer);
		
		return false;
	}
	
	private JSONObject validacionDatos(Customers customer) {
		
		JSONObject statusJSONObject = JSONFactoryUtil.createJSONObject();
		String message = "";
		int statusCode = CustomersPortletKeys.STATUS_SUCCESS;
		
		if(customer.getName().isEmpty()||customer.getAge()==0||customer.getPhoneNumber().isEmpty()||customer.getAddress().isEmpty()) {
			message = "Por favor, diligencie todos los campos";
			statusCode = CustomersPortletKeys.STATUS_ERROR;
		}
		
		if(customer.getName().isEmpty()||customer.getPhoneNumber().isEmpty()||customer.getAddress().isEmpty()) {
			message = "Por favor, diligencie todos los campos";
			statusCode = CustomersPortletKeys.STATUS_ERROR;
		}
		
		statusJSONObject.put("statusCode", statusCode);
		statusJSONObject.put("message", message);
		
		return statusJSONObject;
	}

}
