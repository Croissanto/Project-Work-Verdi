document.body.onload = () => {
	showAll();
}


function showAll() {
	fetch(`http://localhost:8083/getallgallery`).then((r) => { return r.json() })
		.then((r) => {

			gallery.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.titoloSaga;
				let button = document.createElement("button");
				button.innerHTML = "Mostra Libri";
				button.setAttribute("onclick", "showLibriGame(" + tmp.idGallery + ")");
				elem.appendChild(button);
				gallery.appendChild(elem);


			}

		});
}
function showLibriGame(id) {

	fetch(`http://localhost:8083/getlibrigamebygalleryid/` + id).then((r) => { return r.json() })
		.then((r) => {

			cardList.innerHTML = "";
			for (let tmp of r) {

				let card =
					`
				<div class="titolo">
				     <h2 class = "h2">${tmp.title}</h2>
			    </div>
			      <div class="autore-libro">
			      <p class = "nome-cognome-autore">${tmp.autore.name} ${tmp.autore.surname}
			      </div>
			      <div class="container mt-3">
			      <div class = "card">
			      <br><br><br><br>
			      <div class = "stars">
			         <input class="star star-5" id="5-${tmp.id}" type="radio" name="star" onclick="send(5,${tmp.id})" />
							<label class="star star-5" for="5-${tmp.id}"></label>
							<input class="star star-4" id="4-${tmp.id}" type="radio" name="star" onclick="send(4,${tmp.id})" />
							<label class="star star-4" for="4-${tmp.id}"></label>
							<input class="star star-3" id="3-${tmp.id}" type="radio" name="star" onclick="send(3,${tmp.id})" />
							<label class="star star-3" for="3-${tmp.id}"></label>
							<input class="star star-2" id="2-${tmp.id}" type="radio" name="star" onclick="send(2,${tmp.id})" />
							<label class="star star-2" for="2-${tmp.id}"></label>
							<input class="star star-1" id="1-${tmp.id}" type="radio" name="star" onclick="send(1,${tmp.id})" />
							<label class="star star-1" for="1-${tmp.id}"></label>
			      </div>
			      <img class="card-img-top" src="${tmp.link}"
							alt="Card image" style="width:100px">
							<div class="card-body">
							<h4 class="card-title">Descrizione</h4>
							<div class="card-text">Qui ci va la descrizione del libro da capire come sistemarla non ho piu voglia.
							</div>
						</div>
			   	    </div>
					</div>
				</div>`;
				cardList.innerHTML += card;






			}
		});

}

function send(s, id) {
	console.log(s);

	let data = {
		userId: 3,
		libroId: id,
		star: s
	}
	fetch('http://localhost:8083/createrating', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	});

}






