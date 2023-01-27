function insert() {
	fetch(`http://localhost:8080/allPlayerByTeamId/1`).then((r) => { return r.json() })
		.then((r) => {
			
			playerList.innerHTML = "";
			for (let player of r) {
				let elem = document.createElement("li");
				elem.innerHTML = player.name + " " +player.surname;
				
					playerList.appendChild(elem);
					
				
			}
			
		});

}