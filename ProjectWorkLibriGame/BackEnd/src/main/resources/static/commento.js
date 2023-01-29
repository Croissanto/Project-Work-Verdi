function send(){
	
	let data={
		contenuto: contenuto.value,
		date: date.value,
		time: time.value,
		idUser: idUser.value,
		idPost: idPost.value
	}
	
	fetch('http://localhost:8080/createcommento', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
}