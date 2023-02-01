function login(){
	
	let data={
		username: us.value,
		password: ps.value
	}
	
	fetch('http://localhost:8083/login', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
	
}