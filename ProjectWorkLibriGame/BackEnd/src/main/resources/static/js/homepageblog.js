document.body.onload = () => {
	
	showTop2();
	
}

function showTop2() {
	
	fetch('http://localhost:8083/gettop2recentposts').then((r) => {return r.json()}).then((r) => {
		
		
		for(let post of r) {
		
		let elem = document.createElement("li")
		 elem.innerHTML = post.titolo + ' '+ post.contenuto + ' Postato da '+post.user.username;
		
		ul.appendChild(elem);
		}
	});

}