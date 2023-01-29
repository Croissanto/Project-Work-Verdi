document.body.onload = () => {
	showAll();
}


function showAll() {
	fetch(`http://localhost:8080/getallgallery`).then((r) => { return r.json() })
		.then((r) => {

			gallery.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.titoloSaga;
				elem.setAttribute("onclick" ,"showLibriGame("+tmp.idGallery+")");
				console.log(tmp.idGallery)
				gallery.appendChild(elem);


			}

		});
}
function showLibriGame(id) {

	fetch(`http://localhost:8080/getlibrigamebygalleryid/` + id).then((r) => { return r.json() })
		.then((r) => {
			librigame.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = tmp.title;
				librigame.appendChild(elem);






			}
		});
}




