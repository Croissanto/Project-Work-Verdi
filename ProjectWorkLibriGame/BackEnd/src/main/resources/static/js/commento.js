function send(){
	
	let data={
		contenuto: contenuto.value,
		date: date.value,
		time: time.value+":00",
		idUser: idUser.value,
		idPost: idPost.value
	}
	
	fetch('http://localhost:8083/createcommento', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
}