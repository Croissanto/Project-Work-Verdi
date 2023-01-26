function send(){
	
	
	let data={
		idCommento: '1',
		idUser: idUser.value,
		contenuto: contenuto.value,
		link: link.value,
		date: date.value,
		time: time.value,
		blogId: temaId.value
	}
	
	fetch('http://localhost:8080/createpost', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
}