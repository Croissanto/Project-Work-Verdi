var user = null;


fetch("http://localhost:8083/userInSession")
  .then((response) => {
    if (!response.ok) {
      throw new Error("Errore durante la richiesta API");
    }
    return response.json();
  })
  .then((data) => {
    user = data;

   
    updateNavbar();
  })
  .catch(function (error) {
    console.error(error);

   
    user = null;

   
    updateNavbar();
  });
  
  
function updateNavbar() {
  
  var profileSection = document.getElementById("profilo");

  if (!user) {
  
    profileSection.style.display = "none";
  } else {
    
    profileSection.style.display = "block";
  }
}  

