document.addEventListener("DOMContentLoaded", function() {
	console.log("listCustomersURL: "+listCustomersURL);
	listCustomers();
});


const listCustomers = function(){
	
	var data="";
	ajaxExecute(listCustomersURL, data, function(response){
		
		response = JSON.parse(response);
		let customersArray = response.customers;
		
		let tbody = document.querySelector("#customersTable tbody");
		tbody.innerHTML = "";
		
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
	});
}




const ajaxExecute = function(url, data, callback){
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function (){
		if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
			console.log(xhr.responseText)
			callback(xhr.responseText);
	    }
	}
	xhr.send(data);
}