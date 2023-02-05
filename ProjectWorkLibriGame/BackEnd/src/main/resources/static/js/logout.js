function logout() {


	fetch('http://localhost:8083/logout').then((r) => {
		console.log(r);
	}).then(() => {
		
		document.location.reload()
		
	})
}
	