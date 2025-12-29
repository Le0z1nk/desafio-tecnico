document.querySelector(".form").addEventListener("submit", async (event) => {
	event.preventDefault()
	const email = document.getElementById("email").value
	const name = document.getElementById("name").value
	try {
	    const response = await fetch("/api/customer/login", {
	      method: "POST",
	      headers: {
	        "Content-Type": "application/json"
	      },
	      body: JSON.stringify({email})
	    })

	    if (response.ok) {
		  window.location.href="produtos.html"
	    } else {
			alert("Email não cadastrado")
		}
	  } catch (error) {
	    console.error(error);
	    alert("Erro ao logar");
	  }
	
})