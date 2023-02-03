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
	orderByStar();

}

function user() {
	fetch('http://localhost:8083/userInSession').then((r) => { return r.json() }).then((r) => {
		console.log(r);
		idU = r.id;
		idA = r.idAccount;
		type = r.type;
		propic = r.proPic;
	}).then(() => {
		showUserPosts(idU);
	});
}

function account() {
	fetch('http://localhost:8083/accountInSession').then((r) => { return r.json() }).then((r) => {
		console.log(r);
		username = r.username;
		name = r.name;
		surname = r.surname;
		email = r.email;
	});
}

function showUserPosts(idU) {

	fetch('http://localhost:8083/getpostsbyuser/' + idU).then((r) => { return r.json() }).then((r) => {
	console.log(r);
		for (let post of r) {

			let elem = document.createElement("li");
			elem.innerHTML = post.titolo + ' ' + post.contenuto;
			lista.appendChild(elem);

		}
	});

}

function orderByStar() {
//serve passare l'id dell'utente per capire quali libri ha votato questo user
	fetch('http://localhost:8083/getlibrigameorderbystar').then((r) => { return r.json() }).then((r) => {

		for (let libro of r) {

			let elem = document.createElement("li");
			elem.innerHTML = libro.id + ' ' + libro.title + ' ' + libro.genre;
			ratings.appendChild(elem);

		}

	});
}