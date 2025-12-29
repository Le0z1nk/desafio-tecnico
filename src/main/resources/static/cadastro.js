document.querySelector(".formCadastro").addEventListener("submit", async (event) => {
  event.preventDefault()

  const customerData = {
    name: document.querySelector("#name").value,
    email: document.querySelector("#email").value,
  }

  try {
    const response = await fetch("/api/customer", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(customerData)
    })

    if (!response.ok) {
      throw new Error("Erro ao criar o cliente");
    }

    alert("Cadastro do cliente concluído!");
  } catch (error) {
    console.error(error);
    alert("Erro ao cadastrar cliente");
  }
})