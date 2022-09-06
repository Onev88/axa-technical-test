<%@ include file="init.jsp" %>

<div class="container px-3 py-3">
	<h2 id="greetings" class="resaltado-naranja">
		<liferay-ui:message key="co.axacolpatria.technicaltest.customers.greetings" /> ${screenName}
	</h2>
	<div id="customersTable">
		<table>
			<thead>
				<tr>
					<th><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.name" /></th>
					<th><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.age" /></th>
					<th><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.phoneNumber" /></th>
					<th><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.address" /></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</div>