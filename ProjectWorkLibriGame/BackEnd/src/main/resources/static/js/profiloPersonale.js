const lista = document.getElementById('ul');

document.body.onload = () => {
	
	showUserPosts(1);
	
}


function showUserPosts(id) {
	
	fetch('http://localhost:8083/getpostsbyuser/'+id).then((r)=> {return r.json()}).then((r) => {
		
		for(let post of r) {
			
			let elem = document.createElement("li");
			elem.innerHTML = post.titolo + ' '+post.contenuto;
			lista.appendChild(elem);	
			
		}
	});
	
}