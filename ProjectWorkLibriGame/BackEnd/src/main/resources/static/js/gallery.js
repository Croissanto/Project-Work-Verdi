function send(){
	
	
	let data={
		titoloSaga : titolosaga.value
		
	}
	
	fetch('http://localhost:8080/creategallery', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
}