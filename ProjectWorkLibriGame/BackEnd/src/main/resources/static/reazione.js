var likeCount = 0;
var dislikeCount = 0;

document.body.onload = () => {
	
	
	stampa(1);
	
	
}


function addLike() {
	
	likeCount++;
	let data={
		upVote: likeCount ,
		downVote: dislikeCount,
		idUser: user.value,
		idPost: post.value 
       
	}
	
	fetch('/createreazione', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	}) .then((response) =>{
        return response.json();
    })
    .then((data) =>{
        console.log(data);
    })
    .then(() => {
		
		stampa(1);
	});

	
}

function addDislike() {
	
	
	dislikeCount++;
	let data={
		upvote: likeCount ,
		downvote: dislikeCount,
		user: user.value,
		post: post.value 
       
	}
	
	fetch('/createreazione', {
  		method: 'POST',
  		headers: {
    		'Content-Type': 'application/json',
  		},
  		body: JSON.stringify(data),
	})  .then((response)=> {
        return response.json();
    })
    .then((data)=> {
        console.log(data);
    })
    .then(() => {
		
		stampa(1);
	});
    
    
  }  
function stampa(id) {
	fetch(`http://localhost:8080/getreazionebypost/`+id).then((r) => { return r.json() })
		.then((r) => {
			
			span1.innerHTML = "";
			span2.innerHTML = '';
			for (let reazione of r) {
				
				span1.innerHTML = reazione.upvote;
				span2.innerHTML = reazione.downvote;
				//elem.setAttribute("onclick","showPost("+tmp.id+")");			
			}		
		});
} 
   	












