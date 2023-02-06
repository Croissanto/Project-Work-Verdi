let idU = "";
let idA = "";
let type = "";
let propic = "";
let username = "";
let name = "";
let surname = "";
let email = "";

document.body.onload = () => {
	avarageRating();
	showTop2();
	user();
	account();

}

function logout() {


	fetch('http://localhost:8083/logout').then((r) => {
		console.log(r);
	}).then(() => {

		document.location.reload()

	})


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

function avarageRating() {
	fetch(`http://localhost:8083/getmostratedlibrogame`).then((r) => { return r.json() })
		.then((r) => {
			let max = Math.max(...r.map(r => r.avg));
			let min = Math.min(...r.map(r => r.avg));
			let middle;
			let p = document.getElementById("titoav");
			let pmin = document.getElementById("titomin");
			for (i = 0; i < r.length; i++) {
				if (r[i].avg != max && r[i].avg != min) {
					middle = r[i].avg;

				}
			}
			for (tmp of r) {
				for (let i = 1; i <= 5; i++) {
					const star = document.querySelector(`#max${i}`);

					if (i <= max) {
						star.classList.add('checked');
					} else {
						star.classList.remove('checked');
					}

				}

				for (let i = 1; i <= 5; i++) {
					const star = document.querySelector(`#av${i}`);
					if (i <= middle) {
						star.classList.add('checked');
					} else {
						star.classList.remove('checked');
					}

				}

				for (let i = 1; i <= 5; i++) {
					const star = document.querySelector(`#checked${i}`);

					if (i <= min) {
						star.classList.add('checked');
					} else {
						star.classList.remove('checked');
					}
				}

				if (tmp.avg == max) {
					let card = ` 
						         <img class="card-img-top" src="${tmp.link}"
									alt="Card image" style="width: 60%;">
									<p class ="h4">Media voti (${tmp.avg})</p>
									<p>${tmp.title}</p>
									<p>${tmp.name} ${tmp.surname}</p>
		                         `;
					maxAvarage.innerHTML += card;
					pan.innerHTML = "(" + tmp.avg + ")";


				} else if (tmp.avg == min) {

					let card = `
					         <img class="card-img-top" src="${tmp.link}"
									alt="Card image">
					               `;
					minAvarage.innerHTML += card;
					spapan.innerHTML = "(" + tmp.avg + ")";

				}
				else {
					let card = `
					         <img class="card-img-top" src="${tmp.link}"
									alt="Card image">
						
																 `;
					avarage.innerHTML += card;
					span.innerHTML = "(" + tmp.avg + ")";
				}

				p.innerHTML = tmp.title;
				pmin.innerHTML = tmp.title;
				autormin.innerHTML = tmp.name + " " + tmp.surname;
				autoreav.innerHTML = tmp.name + " " + tmp.surname;
				
				

			}

		});
}

document.getElementById("accedi").addEventListener("click", function() {
	document.getElementById("myModal").style.display = "block";
});

// Chiude il modale
document.getElementsByClassName("close")[0].addEventListener("click", function() {
	document.getElementById("myModal").style.display = "none";
});

// Apre la scheda desiderata (registrazione o accesso)
function openTab(evt, tabName) {
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.className += " active";
}

// Imposta la scheda di registrazione come predefinita
document.getElementById("defaultOpen").click();


