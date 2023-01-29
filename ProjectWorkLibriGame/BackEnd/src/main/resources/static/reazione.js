document.body.onload = () => {
	
	showReazioni();
	
}



function showReazioni() {
	fetch(`http://localhost:8080/getreactlist/`+id).then((r) => { return r.json() })
		.then((r) => {

			threadList.innerHTML = "";
			for (let tmp of r) {
				let elem = document.createElement("li");
				elem.innerHTML = "<a href=/"+tmp.tema+".html>"+tmp.titolo+"</a>";
				elem.setAttribute("onclick", "showPost(" + tmp.id + ")");
				threadList.appendChild(elem);


			}

		});

}