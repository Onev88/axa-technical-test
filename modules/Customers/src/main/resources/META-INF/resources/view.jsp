<%@ include file="init.jsp" %>

<div id="customersList" class="container px-3 py-3 showHide">
	<h2 id="greetings" class="resaltado-naranja">
		<liferay-ui:message key="co.axacolpatria.technicaltest.customers.customerList"/>
	</h2>
	<p><liferay-ui:message key="co.axacolpatria.technicaltest.customers.greetings" /> ${screenName}</p>
	<div id="customersTable">
		<div class="form-group col-md-5 float-right">
			<button id="<portlet:namespace/>add" type="button" class="btn btn-secondary btn-block w-auto float-right mb-3"><i class="icon-plus text-success"></i> Adicionar</button>
			<div class="d-flex w-100 float-right">
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

<div id="addCustomer" class="container px-3 py-3 d-none showHide">
	<h2 id="greetings" class="resaltado-naranja">
		<liferay-ui:message key="co.axacolpatria.technicaltest.customers.addCustomer" />
	</h2>
	<p><liferay-ui:message key="co.axacolpatria.technicaltest.customers.greetings" /> ${screenName}</p>
	<form id="customerForm">
		<div class="form-group">
			<label for="<portlet:namespace/>name"><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.name" /></label>
			<input type="text" class="form-control" id="<portlet:namespace/>name" placeholder="Ingrese nombre">
		</div>
		<div class="form-group">
			<label for="age"><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.age" /></label>
			<input type="number" class="form-control" id="<portlet:namespace/>age" placeholder="Ingrese edad">
		</div>
		<div class="form-group">
			<label for="phoneNumber"><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.phoneNumber" /></label>
			<input type=tel class="form-control" id="<portlet:namespace/>phoneNumber" placeholder="Ingrese número telefonico">
		</div>
		
		<div class="form-group">
			<label for="address"><liferay-ui:message key="co.axacolpatria.technicaltest.customers.list.th.address" /></label>
			<input type=tel class="form-control" id="<portlet:namespace/>address" placeholder="Ingrese dirección">
		</div>
		<button id="<portlet:namespace/>save" type="button" class="btn btn-primary">Guardar</button>
		<button id="<portlet:namespace/>return" type="button" class="btn btn-secundary">Regresar</button>
	</form>
</div>


