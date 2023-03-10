let idU = "";
let idA = "";
let type = "";
let propic = "";
let username = "";
let name = "";
let surname = "";
let email = "";


document.body.onload = () => {
	showAll();
	libriDellaSettimana();
	user();
	account();
}

function user() {
	fetch('http://localhost:8083/userInSession').then((r) => { return r.json() }).then((r) => {
		//console.log(r);
		idU = r.id;
		idA = r.idAccount;
		type = r.type;
		propic = r.proPic;
		//console.log(type + " " + idU + " " + idA);
	});
}

function account() {
	fetch('http://localhost:8083/accountInSession').then((r) => { return r.json() }).then((r) => {
		//console.log(r);
		username = r.username;
		name = r.name;
		surname = r.surname;
		email = r.email;

		//console.log(username + " "+ name + " "+ surname + " "+ email);

	});
}

var salcio = document.getElementById("salcio");
var micheal = document.getElementById("carouselExampleIndicators");
var galleryCard = document.getElementById("genreList");
console.log(salcio);


function showAll() {
	fetch(`http://localhost:8083/getallgallery`).then((r) => { return r.json() })
		.then((r) => {
			gallery.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("a");
				elem.setAttribute("class", "list-group-item list-group-item-action");
				//role cambia il cursose quando passo sopra l'elemento
				elem.setAttribute("role", "button");
				elem.innerHTML = tmp.titoloSaga;
				elem.setAttribute("onclick", "showLibriGame(" + tmp.idGallery + ")");
				gallery.appendChild(elem);
			}

		});
}
function showLibriGame(id) {
	let href = document.getElementById("href");
	fetch(`http://localhost:8083/getlibrigamebygalleryid/` + id).then((r) => { return r.json() })
		.then((r) => {
			poli.innerHTML = "";
			showAll();
			cardList.innerHTML = "";
			salcio.innerHTML = "";
			href.setAttribute("href", "showGallery.html");
			for (let tmp of r) {

				let card =
					`
				
			      
			      <div class="row pt-2">
			      <div class="col-sm-4 offset-sm-2">
                     <img class="card-img-top" src="${tmp.link}"
							alt="Card image" style="width: 100%;">
                  </div>
			      <div class="col-sm-6 pe-5 d-flex justify-content-start align-items-center flex-column">
			      <div class="titolo">
				<p class = "h4 mb-0">${tmp.title}</p>
			    </div>
			    <div class="autore-libro">
			      <p class = "nome-cognome-autore text-muted fw-bold">${tmp.autore.name} ${tmp.autore.surname}
			      </div>
			       <div class="row justify-content-center">
                    

                    


                </div>
			      <div class="mb-0"></div>
                    <div class = "stars" id = "rating">
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
                  </div>
                </div>
               `;
				cardList.innerHTML += card;
				galleryCard.innerHTML = "";
				href.innerHTML = "Torna ai libi della settimana";
			}
		});

}

function send(s, id) {
	console.log(s);

	let data = {
		userId: idU,
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

function libriDellaSettimana() {

	fetch(`http://localhost:8083/getalllibrigame`).then((r) => { return r.json() })
		.then((r) => {
			let salcio = document.getElementById("salcio"),
				shuffled = r.sort(() => 0.5 - Math.random()),
				carousel = shuffled.slice(0, 5);
			salcio.innerHTML = "";

			for (i = 0; i < carousel.length; i++) {
				if (i < 1) {

					let caroActive = `
					
    <div class="carousel-item active">
      <img src="${carousel[i].link}" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <p></p>
      </div>
    </div>
    
  `;
					salcio.innerHTML += caroActive;

				}
				else {

					let caro = `
					
    <div class="carousel-item justify-content-center ">
      <img src="${carousel[i].link}" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <p></p>
      </div>
    </div>
    
  `;
					salcio.innerHTML += caro;

				}
			}

		});
}




function showGenre() {
	let select = document.getElementById("genre");
	let selectedValue = select.options[select.selectedIndex].value;


	fetch(`http://localhost:8083/getlibrigamebygenre/` + selectedValue).then((r) => { return r.json() })
		.then((r) => {
			micheal.innerHTML = "";
			poli.innerHTML = "";
			genreList.innerHTML = "";
			let href = document.getElementById("href");
			href.setAttribute("href", "showGallery.html");
			for (let tmp of r) {
				console.log(tmp);
				let card =
					`
			<div class="row pt-4">
			      <div class="col-sm-4 offset-sm-2">
                     <img class="card-img-top" src="${tmp.link}"
							alt="Card image" style="width: 100%;">
                  </div>
			      <div class="col-sm-6 pe-5 d-flex justify-content-start align-items-center flex-column">
			      <div class="titolo">
				<p class = "h4 mb-0">${tmp.title}</p>
			    </div>
			    <div class="autore-libro">
			      <p class = "nome-cognome-autore text-muted fw-bold">${tmp.autore.name} ${tmp.autore.surname}
			      </div>
			       <div class="row justify-content-center border-top border-bottom">
                 
                    


                </div>`;

				genreList.innerHTML += card;
				cardList.innerHTML = "";
				href.innerHTML = "Torna ai libi della settimana";
			}

		});
}









