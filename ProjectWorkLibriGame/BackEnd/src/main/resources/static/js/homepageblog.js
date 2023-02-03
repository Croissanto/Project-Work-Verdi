let idU = "";
let idA = "";
let type = "";
let propic = "";
let username = "";
let name = "";
let surname = "";
let email = "";

document.body.onload = () => {

	showTop2();
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

function showTop2() {

	fetch('http://localhost:8083/gettop2recentposts').then((r) => { return r.json() }).then((r) => {

		let i = 1;
		for (let post of r) {
			let data = document.getElementById("dateMostU" + i);
			data.innerHTML = post.date + " alle " + post.time;
			let titolo = document.getElementById("titoloMostU" + i);
			titolo.innerHTML = post.titolo;
			let contenuto = document.getElementById("contenutoMostU" + i);
			contenuto.innerHTML = post.contenuto;
			let user = document.getElementById("userMostU" + i);
			user.innerHTML = post.user.username;

			i++;
		}
	});

}