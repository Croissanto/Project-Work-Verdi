function send(){
	
	let data={
		titolo: titolo.value 
	}
	
	fetch('/createBlog', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}).then(
	titolo.innerHTML = "");
	
}