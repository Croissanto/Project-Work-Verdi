function innerHTMLtest(){
	setInterval(3000);
	console.log(document.getElementById("p").innerHTML);
	let elem = document.getElementById("loginToggle");
	console.log(elem);
	/*if (document.getElementById("loginToggle").innerHTML = "Accedi"){
	document.getElementById("loginToggle").innerHTML = "Logout";
	} else {
		document.getElementById("loginToggle").innerHTML = "else";
	}*/
}
