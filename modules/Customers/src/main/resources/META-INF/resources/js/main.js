var listCustomersArray;

document.addEventListener("DOMContentLoaded", function() {
	listCustomers();
	document.getElementById(pns+"search").addEventListener('click', function handleClick(event) {
		search();
	});
	document.getElementById(pns+"add").addEventListener('click', function handleClick(event) {
		document.getElementById("customersList").classList.toggle("d-none");
		document.getElementById("addCustomer").classList.toggle("d-none");
	});
	document.getElementById(pns+"return").addEventListener('click', function handleClick(event) {
		document.getElementById("customersList").classList.toggle("d-none");
		document.getElementById("addCustomer").classList.toggle("d-none");
	});
	document.getElementById(pns+"save").addEventListener('click', function handleClick(event) {
		var obj = {};
		let form = document.forms.customerForm;
		var formData = new FormData(form);
		for (var key of formData.keys()) {
			obj[key] = formData.get(key);
		}
		
		console.log(obj);
		console.log(JSON.stringify(obj));
	});
});


const listCustomers = function(){
	ajaxExecute(listCustomersURL, "", function(response){
		response = JSON.parse(response);
		let customersArray = response.customers;
		listCustomersArray = response.customers;
		populateTable(customersArray);
	});
}

const search = function(){
	var filterValue=document.getElementById(pns+"filter").value;
	let customersArray = filterValue!=""?listCustomersArray.filter(customer => JSON.stringify(customer).includes(filterValue)):listCustomersArray;
	populateTable(customersArray);
}

const orderCustomer = function(){
	let customersArray = listCustomersArray;
	populateTable(customersArray);
}


const populateTable = function(customersArray){
	let tbody = document.querySelector("#customersTable tbody");
	tbody.innerHTML = "";
	if(customersArray.length>0){
		customersArray.forEach(customer => {
			let row = document.createElement("tr");
			
			
			let nameTD = document.createElement("td");
			let ageTD = document.createElement("td");
			let phoneNumberTD = document.createElement("td");
			let addressTD = document.createElement("td");
			
			nameTD.innerHTML=customer.name;
			ageTD.innerHTML=customer.age;
			phoneNumberTD.innerHTML=customer.phoneNumber;
			addressTD.innerHTML=customer.address;
			
			row.append(nameTD);
			row.append(ageTD);
			row.append(phoneNumberTD);
			row.append(addressTD);
			
			tbody.appendChild(row);
			
		});
	}else{
		let row = document.createElement("tr");
		let emptyTD = document.createElement("td");
		emptyTD.setAttribute("colspan","4");
		emptyTD.classList.add("text-center");
		emptyTD.innerHTML = "No se encontraron registros";
		row.append(emptyTD);
		tbody.appendChild(row);
	}
}

const ajaxExecute = function(url, data, callback){
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function (){
		if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
			console.log(xhr.responseText);
			callback(xhr.responseText);
	    }
	}
	xhr.send(data);
}