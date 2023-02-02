function send(){
	
	let data = {
		username: username.value,
		password: password.value,
		name: nome.value,
		surname: surname.value,
		email: email.value
	}
	
	fetch('http://localhost:8083/create', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
}