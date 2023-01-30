let id = document.getElementById("blogId");
console.log(id.innerHTML);


document.body.onload = () => {
	showPost(blogId.innerHTML);
}

function showPost(id) {
	fetch(`http://localhost:8080/getpostlist/` + id).then((r) => { return r.json() })
		.then((r) => {

			postList.innerHTML = "";
			for (let tmp of r) {


				let card = `<div class="card mb-4">
        <a href="#!"><img class="card-img-top" src="" alt="..." /></a>
        <div class="card-body">
            <div class="small text-muted">${tmp.date} ${tmp.time}</div>
            <h2 class="card-title">${tmp.titolo}</h2>
            <p id="myText-${tmp.id}"class="card-text">${tmp.contenuto}</p>
            <a class="btn btn-primary" href="#!" id="showCommenti-${tmp.id}">Read more →</a>
        </div>
    </div>`;
    postList.innerHTML += card;
    let elem = document.getElementById("showCommenti-"+tmp.id);
    elem.onclick = (e) => {
		showCommenti(e.target.id.split("-")[1]);
		//console.log((e.target.id.split("-")[1]));
	}
	





				/*	let elem = document.createElement("li");
					elem.innerHTML = "<br>" + tmp.user.username + " <br> " + tmp.contenuto;
					let p = document.createElement("p");
					p.id = tmp.id;
					p.innerHTML = "Visualizza i commenti";
					p.setAttribute("onclick", "showCommenti(" + tmp.id + ")");
					let ul = document.createElement("ul");
					ul.id = "listaCommenti" + tmp.id;*/
				//postList.append(elem, p, ul);
				//Talluccio ricordarti di appendere le cose
				//Ringraziamo 5 volte Betto e -5 volte Raffaele

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
				elem.innerHTML = tmp.contenuto + " " + tmp.date + " " + tmp.time + " <br>";

				thisUl.appendChild(elem);

			}

		});
}
