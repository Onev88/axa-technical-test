package co.axacolpatria.technicaltest.customers.portlet;

import co.axacolpatria.technicaltest.customers.constants.CustomersPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Juan Víctor Martínez
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.css-class-wrapper="+CustomersPortletKeys.CSS_CLASS_WRAPPER,
			"com.liferay.portlet.display-category="+CustomersPortletKeys.DISPLAY_CATEGORY,
			"com.liferay.portlet.header-portlet-css="+CustomersPortletKeys.HEADER_PORTLET_CSS,
			"com.liferay.portlet.header-portlet-javascript="+CustomersPortletKeys.HEADER_PORTLET_JS,
			"com.liferay.portlet.instanceable="+CustomersPortletKeys.INSTANCIABLE,
			"javax.portlet.display-name="+CustomersPortletKeys.DISPLAY_NAME,
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.name=" + CustomersPortletKeys.CUSTOMERS,
			"javax.portlet.resource-bundle=" + CustomersPortletKeys.RESOURCE_BUNDLE,
			"javax.portlet.security-role-ref=" + CustomersPortletKeys.SECURITY_ROLE_REF
	},
	service = Portlet.class
)
public class CustomersPortlet extends MVCPortlet {
}