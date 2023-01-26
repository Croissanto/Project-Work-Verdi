function send(){
	
	var lista = [];
	let data={
		titolo: titolo.value ,
		tema: tema.value ,
        idListaPost: lista
	}
	
	fetch('/createBlog', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	titolo.innerHTML = "";
	tema.innerHTML = "";
	
}