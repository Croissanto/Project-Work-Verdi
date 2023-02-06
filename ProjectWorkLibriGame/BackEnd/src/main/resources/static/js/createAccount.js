
function registrati() {

	let data = {
		username: registeruser.value,
		password: registerpassword.value,
		name: registernome.value,
		surname: registercognome.value,
		email: registeremail.value
	}

	fetch('http://localhost:8083/create', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	});

}