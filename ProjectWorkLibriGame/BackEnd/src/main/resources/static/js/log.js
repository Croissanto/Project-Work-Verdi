function login() {

	let data = {
		username: us.value,
		password: ps.value
	}

	fetch('http://localhost:8083/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	});


}

function logout() {


	fetch('http://localhost:8083/logout').then((r) => {
		console.log(r);
	});
}
	
	
function user(){
	fetch('http://localhost:8083/userInSession').then((r) => { return r.json() }).then((r) => {
	console.log(r);
		
	});
}

function account(){
	fetch('http://localhost:8083/accountInSession').then((r) => { return r.json() }).then((r) => {
	console.log(r);
		
	});
}


