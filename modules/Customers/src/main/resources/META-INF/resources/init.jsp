<%@page import="co.axacolpatria.technicaltest.customers.constants.CustomersPortletKeys"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-portlet:resourceURL var="listCustomersURL" id="<%=CustomersPortletKeys.RESOURCE_GET_CUSTOMERS_LIST%>"/>
<liferay-portlet:resourceURL var="addCustomerURL" id="<%=CustomersPortletKeys.RESOURCE_ADD_CUSTOMER %>" />

<script>
	const pns = "<portlet:namespace/>";
	const listCustomersURL = "${listCustomersURL}";
	const addCustomerURL = "${addCustomerURL}";
</script>