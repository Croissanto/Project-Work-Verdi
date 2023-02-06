window.onload = () => {

    fetch(`http://localhost:8080/getalllibrigame`).then((r) => { return r.json() })
    .then((r) => {
        console.log(r);
        let cont = 0;
        for(let libro of r) {
            cont ++
            let vecchio = document.getElementById('contentitore').innerHTML
			document.getElementById('contentitore').innerHTML = '<ul>' + libro.title + '</ul>'+vecchio;
            if(cont>10) {
                break;
            }
		}

    });
}


