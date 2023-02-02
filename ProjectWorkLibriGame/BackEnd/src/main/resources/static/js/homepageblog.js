document.body.onload = () => {

	showTop2();

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