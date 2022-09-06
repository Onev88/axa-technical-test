document.addEventListener("DOMContentLoaded", function() {
	console.log("listCustomersURL: "+listCustomersURL);
	listCustomers();
});


const listCustomers = function(){
	
	var data="";
	ajaxExecute(listCustomersURL, data, function(response){
		
		response = JSON.parse(response);
		let receiptsArray = response.receipts;
		
		let tbody = document.querySelector("#customersTable tbody");
		tbody.innerHTML = "";
		
		document.getElementById("totalAmountTD").innerHTML="0";
		
		receiptsArray.forEach(receipt => {
			let row = document.createElement("tr");
			
			
			let checkCol = document.createElement("td");
			let policyCol = document.createElement("td");
			let invoiceCol = document.createElement("td");
			let amountCol = document.createElement("td");
			
			invoiceCol.colSpan = 4;
			
			checkCol.append(createCheckbox(receipt));
			policyCol.innerHTML=receipt.policy;
			invoiceCol.innerHTML=receipt.invoice;
			amountCol.innerHTML=receipt.amount;
			
			row.append(checkCol);
			row.append(policyCol);
			row.append(invoiceCol);
			row.append(amountCol);
			
			tbody.appendChild(row);
			
		});
		
		if(receiptsArray.lenght==0){
			let row = document.createElement("tr");
			let col = document.createElement("td");
			col.colSpan=7;
			col.className="text-center";
			row.append(col);
			tbody.appendChild(row);
		}
		
	});
}




const ajaxExecute = function(url, data, callback){
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function (){
		if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
			callback(xhr.responseText);
	    }
	}
	xhr.send(data);
}