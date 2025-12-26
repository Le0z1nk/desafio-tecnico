const API_URL = "http://localhost:8080";

async function createProduct(productData) {
  const response = await fetch(`${API_URL}/api/product`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(productData)
  });

  if (!response.ok) {
    throw new Error("Erro ao criar o produto");
  }

  const product = await response.json();
  alert("Cadastro do produto concluído");
  return product;
}