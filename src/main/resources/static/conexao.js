document.querySelector(".formProduto").addEventListener("submit", async (event) => {
  event.preventDefault()

  const productData = {
    name: document.querySelector("#nome").value,
    category: document.querySelector("#categoria").value,
    price_cents: Number(document.querySelector("#preco").value),
    active: document.querySelector('input[name="active"]:checked')?.value === "true"
  }

  try {
    const response = await fetch("/api/product", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(productData)
    })

    if (!response.ok) {
      throw new Error("Erro ao criar o produto")
    }

    alert("Cadastro do produto concluído!")
  } catch (error) {
    console.error(error);
    alert("Erro ao cadastrar produto")
  }
})