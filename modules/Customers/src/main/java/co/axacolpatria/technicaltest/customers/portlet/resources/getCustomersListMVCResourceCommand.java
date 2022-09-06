package co.axacolpatria.technicaltest.customers.portlet.resources;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import co.axacolpatria.technicaltest.customers.api.CustomersClient;
import co.axacolpatria.technicaltest.customers.constants.CustomersPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + CustomersPortletKeys.CUSTOMERS, 
		"mvc.command.name=" + CustomersPortletKeys.RESOURCE_GET_CUSTOMERS_LIST}, service = MVCResourceCommand.class)
public class getCustomersListMVCResourceCommand implements MVCResourceCommand{
	
	@Reference
	private CustomersClient customerClientUtil;
	
	private static final Log LOG = LogFactoryUtil.getLog(getCustomersListMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException {
		
		try {
			PrintWriter writer = response.getWriter();
			writer.print(customerClientUtil.getCustomers());
			writer.flush();
			writer.close();
			return false;
		} catch (IOException e) {
			LOG.error(e);
			return true;
		}
	}

}
