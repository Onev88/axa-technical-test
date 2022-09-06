package co.axacolpatria.technicaltest.customers.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import co.axacolpatria.technicaltest.customers.constants.CustomersPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + CustomersPortletKeys.CUSTOMERS,
		"mvc.command.name=/", "mvc.command.name=" + CustomersPortletKeys.RENDER_DEFAULT_VIEW }, service = MVCRenderCommand.class)
public class CustomerDefautlViewMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest request, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		request.setAttribute("screenName", themeDisplay.getUser().getScreenName());
		return CustomersPortletKeys.INITIAL_JSP_PATH;
	}

}
