document.body.onload = () => {
	avarageRating();
}

function avarageRating() {
	let avarage = document.getElementById("avarage");
	fetch(`http://localhost:8083/getmostratedlibrogame`).then((r) => { return r.json() })
		.then((r) => {
			for (let tmp of r) {
				let li = document.createElement("li");
				li.innerHTML = tmp.avg + " " + tmp.libriId;
				avarage.appendChild(li);
			}
		});
}