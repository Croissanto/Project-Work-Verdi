let id = document.getElementById("blogId");
console.log(id.innerHTML);


document.body.onload = () => {
	showPost(blogId.innerHTML);
	showAll();

}

function showPost(id) {
	fetch(`http://localhost:8083/getpostlist/` + id).then((r) => { return r.json() })
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
        <div class="card-body">
            <div class="small text-muted">${tmp.date} ${tmp.time}</div>
            <br>
            <h6 class="card-title">Pubblicato da ${tmp.user.username}</h6>
            <h2 class="card-title">${tmp.titolo}</h2>
            <p id="myText-${tmp.id}"class="card-text">${tmp.contenuto}</p>
            <br>
            <p id="reactList-${tmp.id}"></p>
            <br>
            <a class="btn btn-primary" href="#!" id="showCommenti-${tmp.id}">Mostra i commenti</a>
            <button type="button" class="btn btn-primary" style="margin-left:26%;" data-bs-toggle="modal" data-bs-target="#commenta-${tmp.id}">
  Commenta il post di ${tmp.user.username}
</button>

<!-- Modal -->
<div class="modal fade" id="commenta-${tmp.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Aggiungi un commento</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <textarea maxlength="2000" class="form-control" id="contenuto-${tmp.id}" rows="4" placeholder="Scrivi qualcosa siummica"></textarea>
                  <label class="form-label" for="contenuto-${tmp.id}"></label>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="addComment(${tmp.id})">Commenta</button>
      </div>
    </div>
  </div>
</div>
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
				let elem1 = document.getElementById("reactList-" + tmp.id);
				elem1.innerHTML = map["LIKE"] + `<span onclick="send(${tmp.id},'LIKE')" id="like-${tmp.id}" value="LIKE">
				&#128077 </span>  ` + map["CUORE"] + `<span onclick="send(${tmp.id}, 'CUORE')" id="cuore-${tmp.id}" value="CUORE">
				&#129505 </span>  ` + map["VOMITINO"] + `<span onclick="send(${tmp.id}, 'VOMITINO')" id="vomitino-${tmp.id}" value="VOMITINO">
				&#129314 </span>  ` + map["TRISTE"] + `<span onclick="send(${tmp.id}, 'TRISTE')" id="triste-${tmp.id}" value="TRISTE">
				&#128546 </span>  ` + map["WOW"] + `<span onclick="send(${tmp.id}, 'WOW')" id="wow-${tmp.id}" value="WOW">
				&#128558 </span>  ` + map["RISATA"] + `<span onclick="send(${tmp.id},'RISATA')" id="risata-${tmp.id}" value="RISATA">
				&#128514 </span>  ` + map["GRRR"] + `<span onclick="send(${tmp.id},'GRRR')" id="grrr-${tmp.id}" value="GRRR">
				&#128545 </span>`;



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
	fetch(`http://localhost:8083/getcommlist/` + id).then((r) => { return r.json() })
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
	fetch(`http://localhost:8083/allblog`).then((r) => { return r.json() })
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

function send(id, reaction) {
	console.log(id, reaction);


	let data = {
		idPost: id,
		idUser: 1,
		reactions: reaction,
	}
	console.log(data);
	fetch('http://localhost:8083/createreazione', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	}).then(() => { updateList(id) })



}

function updateList(id) {

	fetch('http://localhost:8083/getreactlist/' + id).then((r) => { return r.json() })

		.then((tmp) => {

			let map = [];
			for (let reazione of tmp) {


				map["LIKE"] = 0;
				map["CUORE"] = 0;
				map["VOMITINO"] = 0;
				map["TRISTE"] = 0;
				map["WOW"] = 0;
				map["RISATA"] = 0;
				map["GRRR"] = 0;

				map[reazione.reactions]++;
			}

			let elem1 = document.getElementById("reactList-" + id);
			elem1.innerHTML = map["LIKE"] + `<span onclick="send(${id},'LIKE')" id="like-${id}" value="LIKE">
				&#128077 </span>  ` + map["CUORE"] + `<span onclick="send(${id}, 'CUORE')" id="cuore-${id}" value="CUORE">
				&#129505 </span>  ` + map["VOMITINO"] + `<span onclick="send(${id}, 'VOMITINO')" id="vomitino-${id}" value="VOMITINO">
				&#129314 </span>  ` + map["TRISTE"] + `<span onclick="send(${id}, 'TRISTE')" id="triste-${id}" value="TRISTE">
				&#128546 </span>  ` + map["WOW"] + `<span onclick="send(${id}, 'WOW')" id="wow-${id}" value="WOW">
				&#128558 </span>  ` + map["RISATA"] + `<span onclick="send(${id},'RISATA')" id="risata-${id}" value="RISATA">
				&#128514 </span>  ` + map["GRRR"] + `<span onclick="send(${id},'GRRR')" id="grrr-${id}" value="GRRR">
				&#128545 </span>`;
		});



}

function addComment(id) {
	console.log(id);
	let elem = document.getElementById("contenuto-" + id).value;
	console.log(elem);

	let current = new Date();
	let cDate = current.getFullYear() + '-' + (current.getMonth() + 1) + '-' + current.getDate();
	let cTime = current.getHours() + ":" + current.getMinutes() + ":" + current.getSeconds();
	//let dateTime = cDate + ' ' + cTime;
	let data = {
		contenuto : elem,
		date: cDate,
		time: cTime,
		idUser: 1,
		idPost: id
	}
	
	fetch('http://localhost:8083/createcommento', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
}

function addPost(id){
	let elem = document.getElementById("postTitolo").value;
	let elem2 = document.getElementById("aggiungiPost").value;
	let current = new Date();
	let cDate = current.getFullYear() + '-' + (current.getMonth() + 1) + '-' + current.getDate();
	let cTime = current.getHours() + ":" + current.getMinutes() + ":" + current.getSeconds();
	
	
	let data = {
		idUser: 1,
		titolo: elem,
		contenuto: elem2,
		date: cDate,
		time: cTime,
		blogId: id
	}
	
	fetch('http://localhost:8083/createpost', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),

	}).then(() => {
		showPost(id)

	});

}