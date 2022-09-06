<%@ include file="init.jsp" %>

<div class="container px-3 py-3">
	<h2 id="greetings" class="resaltado-naranja">
		<liferay-ui:message key="co.axacolpatria.technicaltest.customers.greetings" /> ${screenName}
	</h2>
	<div id="customersTable">
		<div class="form-group col-md-5 float-right">
			<div class="d-flex w-75 float-right">
				<input id="<portlet:namespace/>filter" class="form-control" placeholder="Buscar...">
				<button id="<portlet:namespace/>search" type="button" class="btn btn-secondary btn-block w-auto"><i class="icon-search"></i></button>
			</div>
        </div>
		<table class="table">
			<thead class="thead-dark">
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