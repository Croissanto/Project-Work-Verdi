var likeCount = 0;
var dislikeCount = 0;



document.body.onload = () => {



}


function addLike() {
	var id = document.getElementById("post").value;
	likeCount++;
	let data = {
		upVote: likeCount,
		downVote: dislikeCount,
		idPost: post.value


	}

	fetch('/createreazione', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	}).then((response) => {
		return response.json();
	})
		.then((data) => {
			console.log(data);
		})
		.then(() => {
			console.log(id)
			stampa();
		});


}

function addDislike() {

	dislikeCount++;
	let data = {
		upvote: likeCount,
		downvote: dislikeCount,
		idPost: post.value


	}

	fetch('/createreazione', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	}).then((response) => {
		return response.json();
	})
		.then((data) => {
			console.log(data);
		})
		.then(() => {

			stampa();
		});


}


function stampa() {


	fetch('http://localhost:8080/getAllOrderByDateAndTime').then((r) => { return r.json() })
		.then((r) => {

			postList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.contenuto + " " + tmp.date + " " + tmp.time;

				postList.appendChild(elem);
			}
		})
		.then((r) => {
var input = r.id;
			return fetch('http://localhost:8080/getreazionebypost/' + input)
		})

		.then((r) => { return r.json() })

		.then((r) => {

			span1.innerHTML = "";
			span2.innerHTML = '';
			for (let reazione of r)

				span1.innerHTML = reazione.upvote;
			span2.innerHTML = reazione.downvote;
		});
}













