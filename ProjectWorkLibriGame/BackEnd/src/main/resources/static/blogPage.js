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
				elem.setAttribute("onclick", "showPost(" + tmp.id + ")");

				blog.appendChild(elem);


			}

		});

}

function showPost(id) {
	fetch(`http://localhost:8080/getpostlist/` + id).then((r) => { return r.json() })
		.then((r) => {

			postList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.userPost.username + " <br> " + tmp.contenuto;
				let p = document.createElement("p");
				p.id = tmp.id;
				p.innerHTML = "Visualizza i commenti";
				p.setAttribute("onclick", "showCommenti(" + tmp.id + ")");
				let ul = document.createElement("ul");
				ul.id = "listaCommenti" + tmp.id;
				postList.append(elem, p, ul);
				//Talluccio ricordarti di appendere le cose
				//Ringraziamo 5 volte Betto e -5 volte Raffaele

			}

		});
}

function showLastPost() {
	
	fetch('http://localhost:8080/getAllOrderByDateAndTime').then((r) => { return r.json() })
		.then((r) => {

			postList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.contenuto + " " + tmp.date + " " + tmp.time;

				postList.appendChild(elem);

			}

		});
}

function showCommenti(id) {
	fetch(`http://localhost:8080/getcommlist/` + id).then((r) => { return r.json() })
		.then((r) => {

			let thisUl = document.getElementById("listaCommenti" + id);
			thisUl.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.contenuto + " " + tmp.date + " " + tmp.time;

				thisUl.appendChild(elem);

			}

		});
}