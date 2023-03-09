function validateForm() {
	let id = document.forms["myForm"]["id"].value;
  	if (isNaN(parseInt(id))) {
    		alert("El id debe ser un número.");
    		return false;
  	} else {
    		return true;
 	}
}