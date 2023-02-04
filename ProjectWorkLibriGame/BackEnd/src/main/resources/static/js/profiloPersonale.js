let idU = "";
let idA = "";
let type = "";
let propic = "";
let username = "";
let name = "";
let surname = "";
let email = "";

const lista = document.getElementById('ul');

document.body.onload = () => {
	account();
	user();

}

function user() {
	fetch('http://localhost:8083/userInSession').then((r) => { return r.json() }).then((r) => {
		console.log(r);
		idU = r.id;
		idA = r.idAccount;
		type = r.type;
		propic = r.proPic;
	}).then(() => {
		showUserPost();
		orderByStar(idU);


	});
}

function account() {
	fetch('http://localhost:8083/accountInSession').then((r) => { return r.json() }).then((r) => {
		console.log(r);
		username = r.username;
		name = r.name;
		surname = r.surname;
		email = r.email;
		showCard();
	});
}

function findAccount(id, postList) {
	fetch('http://localhost:8083/findAccount/' + id).then((r) => { return r.json() }).then((r) => {
		console.log(r);
		console.log(postList);
		showUserPost(r.username, postList);
	});
}

function showUserPost() {

	fetch('http://localhost:8083/getpostsbyuser/' + idU).then((r) => { return r.json() }).then((r) => {


		for (let posts of r) {


			let posta = `<div class="card" id="card-${posts.id}">
				<div class="card-body">
            <div class="small text-muted">${posts.date} ${posts.time}</div>
            <br>
            <h6 class="card-title">Pubblicato da ${username}</h6>
            <h2 class="card-title">${posts.titolo}</h2>
            <p id="myText-${posts.id}"class="card-text">${posts.contenuto}</p>`
			listadimerda.innerHTML += posta;

		}
	}
	);

}


function orderByStar(idU) {

	fetch('http://localhost:8083/getlibrigameorderbystar/' + idU).then((r) => { return r.json() }).then((r) => {
		console.log(r);
		for (let libro of r) {

			let elem = document.createElement("li");
			elem.innerHTML = libro.title;
			//ratings.appendChild(elem);

		}

	});
}

function showCard() {

	fetch('http://localhost:8083/userInSession').then((user) => { return user.json() }).then((user) => {

		let profileCard = `
        <div class="card-container">
            <img class="round" src="${user.proPic}" alt="user" />
            <h3>${name}  ${surname}</h3>
            <h6>${email}</h6>
            <p>${username}</p>
            <div class="buttons">
                <button class="primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Crea Post
                  </button>
            </div>
            
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel" style="color: yellow;">Nuovo post</h1>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      <form>
                        <div class="mb-3">
                          <label for="recipient-name" class="col-form-label" style="color: yellow;">Tema</label>
                          <input type="text" class="form-control" id="recipient-name">
                        </div>
                        <div class="mb-3">
                            <label for="recipient-name" class="col-form-label" style="color: yellow;">Titolo</label>
                            <input type="text" class="form-control" id="recipient-name">
                          </div>
                        <div class="mb-3">
                          <label for="message-text" class="col-form-label" style="color: yellow;">Testo</label>
                          <textarea class="form-control" id="message-text"></textarea>
                        </div>
                      </form>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                        Chiudi</button>
                      <button type="button" class="btn btn-primary">Pubblica</button>
                    </div>
                  </div>
                </div>
              </div>
            <div class="skills">
                <h6>Skills</h6>
                <ul>
                    <li>UI / UX</li>
                    <li>Front End Development</li>
                    <li>HTML</li>
                    <li>CSS</li>
                    <li>JavaScript</li>
                    <li>React</li>
                    <li>Node</li>
                </ul>
            </div>
        </div>
    </div>`
		card.innerHTML += profileCard;
	})

}








