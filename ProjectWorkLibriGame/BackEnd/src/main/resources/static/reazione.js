document.body.onload = () => {

	showAllReactions();

}

function send() {


	let data = {
		idPost: idPost.value,
		idUser: idUser.value,
		reactions: reactions.value,
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


function showAllReactions() {
	fetch('http://localhost:8080/getallposts').then((r) => { return r.json() })
		.then((r) => {



			for (let post of r) {

				let map = [];

				map["LIKE"] = 0;
				map["CUORE"] = 0;
				map["VOMITINO"] = 0;
				map["TRISTE"] = 0;
				map["WOW"] = 0;
				map["RISATA"] = 0;
				map["GRRR"] = 0;

				for (let reazione of post.reazione) {

					map[reazione.reactions]++;

				}
				p.innerHTML += map["LIKE"] + ' like ' + ' ' +
				map["CUORE"] + ' cuori ' +  ' ' +
				map["VOMITINO"] +' vomitini ' +  ' ' + 
				map["TRISTE"] + ' tristi ' +  ' ' +
				map["WOW"] +' woow ' +  ' ' +
				map["RISATA"] +' risate ' +  ' ' +
				map["GRRR"] +' grrrr '
			}

		})

}