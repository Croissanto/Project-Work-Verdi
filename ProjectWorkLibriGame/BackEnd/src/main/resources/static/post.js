function send(){
	
	
	let data={
		idUser: idUser.value,
		titolo: titolo.value,
		contenuto: contenuto.value,
		date: date.value,
		time: time.value+":00",
		blogId: blogId.value
	}
	
	fetch('http://localhost:8080/createpost', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
}