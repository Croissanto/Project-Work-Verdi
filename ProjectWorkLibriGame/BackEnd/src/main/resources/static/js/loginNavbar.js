var userLogged = null;
var accountLogged = null;



fetch("http://localhost:8083/userInSession")
	.then((response) => {
		if (!response.ok) {
			throw new Error("Errore durante la richiesta API");
		}
		return response.json();
	})
	.then((data) => {
		userLogged = data;


		updateNavbar();
	})
	.catch((error) => {
		console.error(error);


		user = null;


		updateNavbar();
	});


   

  
fetch("http://localhost:8083/accountInSession")
  .then((response) => {
    if (!response.ok) {
      throw new Error("Errore durante la richiesta API");
    }
    return response.json();
  })
  .then((data) => {
    accountLogged = data;

   
    updateNavbar();
  })
  .catch((error) => {
    console.error(error);

   
    accountLogged = null;

   
    updateNavbar();
  });  


function updateNavbar() {
  
  var accedi = document.getElementById("accedi");
  var profileSection = document.getElementById("profilo");
  var logout = document.getElementById("logout");
  if (!userLogged) {
  	
  	logout.style.display="none";
  	accedi.style.display = "block";
    profileSection.style.display = "none";
  } else {
    
    accedi.style.display = "none";
    logout.style.display="block";
    
    if(accountLogged) {
		
    profileSection.style.display = "block";
    
    profileSection.innerHTML ='| '+ accountLogged.username;
    
	    
    }
    if(userLogged.type === "ADMIN") {
		
	threadButton.style.display = "block";
		
	}else{
		threadButton.style.display = "none";
	}
  }
}  


