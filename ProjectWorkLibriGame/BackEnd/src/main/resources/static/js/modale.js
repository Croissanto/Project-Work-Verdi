document.getElementById("accedi").addEventListener("click", function() {
	document.getElementById("myModal").style.display = "block";
	});
	
	// Chiude il modale
	document.getElementsByClassName("close")[0].addEventListener("click", function() {
	document.getElementById("myModal").style.display = "none";
	});
	
	// Apre la scheda desiderata (registrazione o accesso)
	function openTab(evt, tabName) {
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
	tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
	tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.className += " active";
	}
	
	// Imposta la scheda di registrazione come predefinita
	document.getElementById("defaultOpen").click();
