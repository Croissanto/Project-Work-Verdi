function send(){
	
	
	let data={
		title : title.value,
		annoDiPubblicazione : annoDiPubblicazione.value,
	    publisher : publisher.value,
	    genre : genre.value,
	    idAutore : idAutore.value
	
	
	
	}
	
	fetch('http://localhost:8083/createlibrogame', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) ;
	
}



function orderByStar() {
	
	fetch('http://localhost:8083/getlibrigameorderbystar').then((r) =>{return r.json()}).then ((r) => {
		
		for(let libro of r) {
			
			
			
		}
		
		
		
	});
	
	
	
	
}