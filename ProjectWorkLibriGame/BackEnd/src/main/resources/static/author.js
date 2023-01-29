function send(){
	
	let data={
		name: nome.value,
		surname: surname.value,
		luogoDiNascita : luogoDiNascita.value
		 
	}
	
	fetch('/createauthor', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	});
	
}