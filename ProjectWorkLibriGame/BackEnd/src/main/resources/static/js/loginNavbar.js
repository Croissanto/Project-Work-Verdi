var userLogged = null;




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
    profileSection.style.display = "block";
  }
}  

