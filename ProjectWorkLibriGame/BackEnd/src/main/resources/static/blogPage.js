document.body.onload = () => {
	showAll();
	showLastPost();
}


function showAll() {
	fetch(`http://localhost:8080/allblog`).then((r) => { return r.json() })
		.then((r) => {
			
			blog.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.titolo;
				elem.setAttribute("onclick","showPost("+tmp.id+")");
				
					blog.appendChild(elem);
					
				
			}
			
		});

}

function showPost(id){
	fetch(`http://localhost:8080/getpostlist/`+id).then((r) => { return r.json() })
		.then((r) => {
			
			postList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.userPost.username;
				elem.setAttribute("onclick","showCommenti("+tmp.id+")");
				
					postList.appendChild(elem);
					
				
			}
			
		});
}

function showLastPost(){
	alert("sium");
}

function showCommenti(id){
	fetch(`http://localhost:8080/getcommlist/`+id).then((r) => { return r.json() })
		.then((r) => {
			
			listaCommenti.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.contenuto+" "+tmp.date+" "+tmp.time;
				
					listaCommenti.appendChild(elem);
					
				
			}
			
		});
}