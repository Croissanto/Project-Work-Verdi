document.body.onload = () => {
	showAll();
	showLastPost();
}


function showAll() {
	fetch(`http://localhost:8080/allblog`).then((r) => { return r.json() })
		.then((r) => {

			threadList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				//Da sistemare a href
				elem.innerHTML = "<a href=/thread/"+tmp.id+">" + tmp.titolo + "</a>";
				elem.setAttribute("onclick", "showPost(" + tmp.id + ")");
				// /post/2
				threadList.appendChild(elem);


			}

		});

}

function showPost(id) {
	fetch(`http://localhost:8080/getpostlist/` + id).then((r) => { return r.json() })
		.then((r) => {

			postList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = "<br>" + tmp.userPost.username + " <br> " + tmp.contenuto;
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
			let i = 1;
			for (let tmp of r) {
				let date = document.getElementById("date" + i);
				date.innerHTML = "Scritto il " + tmp.date + " alle " + tmp.time;
				let titolo = document.getElementById("titolo" + i);
				titolo.innerHTML = tmp.titolo;
				let contenuto = document.getElementById("contenuto" + i);
				contenuto.innerHTML = tmp.contenuto;
				let user = document.getElementById("user" + i);
				user.innerHTML = "Scritto da " + tmp.user.username;
				let pComm = document.getElementById("commento" + i);
				pComm.setAttribute("onclick", "commenta(" + tmp.id + ")");
				i++;
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

function commenta(id) {
	let div = document.getElementById("aggiungiCommento");
	div.innerHTML = "";
	div.setAttribute("style", "margin-left:30%;");
	var br = document.createElement("br");

	var form = document.createElement("form");
	form.setAttribute("id","formId");



	var textarea = document.createElement("textarea");
	textarea.setAttribute("id", "textarea");
	textarea.setAttribute("placeholder", "Scrivi quello che cazzo voi");

	var dateComm = document.createElement("input");
	dateComm.setAttribute("type", "date");
	dateComm.setAttribute("id", "dateComm");

	var timeComm = document.createElement("input");
	timeComm.setAttribute("type", "time");
	timeComm.setAttribute("id", "timeComm");

	var idComm = document.createElement("input");
	idComm.setAttribute("type", "number");
	idComm.setAttribute("id", "idUser");
	idComm.setAttribute("placeholder", "Your user id");

	var butt = document.createElement("input");
	butt.setAttribute("type", "button");
	butt.setAttribute("value", "Submit");
	butt.setAttribute("onclick", "mandaCommento(" + id + ")");

	form.appendChild(textarea);

	form.appendChild(br.cloneNode());

	form.appendChild(dateComm);
	form.appendChild(br.cloneNode());

	form.appendChild(timeComm);
	form.appendChild(br.cloneNode());

	form.appendChild(idComm);
	form.appendChild(br.cloneNode());

	form.appendChild(butt);

	div.appendChild(form);
}

function mandaCommento(id) {
	
	let data={
		contenuto: textarea.value,
		date: dateComm.value,
		time: timeComm.value+":00",
		idUser: idUser.value,
		idPost: id
	}
	
	fetch('http://localhost:8080/createcommento', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}).then(
		formId.style.visibility='hidden'
	);
	
}
