async function carregarProdutos() {
    try {
        const response = await fetch("/api/product")
        if (!response.ok) {
            throw new Error("Erro ao buscar produtos")
        }

        const produtos = await response.json()
        const container = document.getElementById("sectionProdutos")
        container.innerHTML = ""
        produtos.forEach(produto => {
            const card = document.createElement("div")
            card.classList.add("card")
            card.innerHTML = `
            <p><strong>${produto.name}</strong></p>
            <p><strong>Categoria:</strong> ${produto.category}</p>
            <p><strong>Preço:</strong> ${produto.priceCents}</p>
            <button>Comprar</button>
            `
            container.appendChild(card)
        })
       
    } catch(error) {
        console.error(error)
        alert("Erro ao carregar produtos")
    }
}

document.addEventListener("DOMContentLoaded", carregarProdutos)

inputFiltro = document.getElementById("inputFiltro")
inputFiltro.addEventListener("input", () => {
	const valor = inputFiltro.value.toLowerCase()
	const produtosFiltrados = produtos.filter(produto => produto.category.toLowerCase().includes(valor))
	carregarProdutos(produtosFiltrados)
})
