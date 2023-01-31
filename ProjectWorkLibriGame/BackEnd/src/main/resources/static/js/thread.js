let id = document.getElementById("blogId");
console.log(id.innerHTML);


document.body.onload = () => {
	showPost(blogId.innerHTML);
	showAll();
}

function showPost(id) {
	fetch(`http://localhost:8080/getpostlist/` + id).then((r) => { return r.json() })
		.then((r) => {

			postList.innerHTML = "";
			for (let tmp of r) {
				let map = [];

				map["LIKE"] = 0;
				map["CUORE"] = 0;
				map["VOMITINO"] = 0;
				map["TRISTE"] = 0;
				map["WOW"] = 0;
				map["RISATA"] = 0;
				map["GRRR"] = 0;

				let card = `<div class="card mb-4">
        <a href="#!"><img class="card-img-top" src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg" alt="..." /></a>
        <div class="card-body">
            <div class="small text-muted">${tmp.date} ${tmp.time}</div>
            <h2 class="card-title">${tmp.titolo}</h2>
            <p id="myText-${tmp.id}"class="card-text">${tmp.contenuto}</p>
            <br>
            <p id="reactList-${tmp.id}"></p>
            <br>
            <a class="btn btn-primary" href="#!" id="showCommenti-${tmp.id}">Mostra i commenti</a>
        </div>
    </div>`;
				postList.innerHTML += card;
				let elem = document.getElementById("showCommenti-" + tmp.id);
				elem.onclick = (e) => {
					showCommenti(e.target.id.split("-")[1]);
				}
				for (let reazione of tmp.reazione) {

					map[reazione.reactions]++;

				}
				let elem1 = document.getElementById("reactList-"+tmp.id);
				elem1.innerHTML = map["LIKE"] + `<span onclick="send(${tmp.id},'LIKE')" id="like-${tmp.id}" value="LIKE">
				Like </span> - ` + map["CUORE"] + `<span onclick="send(${tmp.id}, 'CUORE')" id="cuore-${tmp.id}" value="CUORE">
				Cuore </span> - ` + map["VOMITINO"] + `<span onclick="send(${tmp.id}, 'VOMITINO')" id="vomitino-${tmp.id}" value="VOMITINO">
				Vomitino </span> - ` + map["TRISTE"] + `<span onclick="send(${tmp.id}, 'TRISTE')" id="triste-${tmp.id}" value="TRISTE">
				Triste </span> - ` + map["WOW"] + `<span onclick="send(${tmp.id}, 'WOW')" id="wow-${tmp.id}" value="WOW">
				Wow </span> - ` + map["RISATA"] + `<span onclick="send(${tmp.id},'RISATA')" id="risata-${tmp.id}" value="RISATA">
				Risata </span> - ` + map["GRRR"] + `<span onclick="send(${tmp.id},'GRRR')" id="grrr-${tmp.id}" value="GRRR">
				GRRR </span>`;
				
				
				
				/*console.log(elem1);
				elem1.innerHTML += map["LIKE"] + ' like ' + ' ' +
					map["CUORE"] + ' cuori ' + ' ' +
					map["VOMITINO"] + ' vomitini ' + ' ' +
					map["TRISTE"] + ' tristi ' + ' ' +
					map["WOW"] + ' woow ' + ' ' +
					map["RISATA"] + ' risate ' + ' ' +
					map["GRRR"] + ' grrrr '*/
			}
		});

		}


function showCommenti(id) {
	fetch(`http://localhost:8080/getcommlist/` + id).then((r) => { return r.json() })
		.then((r) => {

			//let thisUl = document.getElementById("listaCommenti" + id);
			thisUl.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.contenuto + " " + tmp.date + " " + tmp.time + " <br>";

				thisUl.appendChild(elem);

			}

		});
}


function showAll() {
	fetch(`http://localhost:8080/allblog`).then((r) => { return r.json() })
		.then((r) => {

			threadList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				//Da sistemare a href
				elem.innerHTML = "<a href=/thread/" + tmp.id + ">" + tmp.titolo + "</a>";
				elem.setAttribute("onclick", "showPost(" + tmp.id + ")");
				// /post/2
				threadList.appendChild(elem);


			}

		});

}

function send(id,reaction) {
console.log(id,reaction);

	let data = {
		idPost: id,
		idUser: 2,
		reactions: reaction,
	}
	console.log(data);
	fetch('http://localhost:8080/createreazione', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	}).then((data) => { console.log(data) })

}
