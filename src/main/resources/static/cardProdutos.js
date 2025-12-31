let produtos = []
let produtoSelecionado = null

async function produtosApi() {
    try {
        const response = await fetch("/api/product")
        if (!response.ok) {
            throw new Error("Erro ao buscar produtos")
        }

        produtos = await response.json()
        carregarProdutos(produtos)
    } catch (error) {
        console.error(error)
        alert("Erro ao carregar produtos da API")
    }
}

function carregarProdutos(lista) {
    const container = document.getElementById("sectionProdutos")
	const modalPedidos = document.getElementById("modalPedido")
    container.innerHTML = ""
    lista.forEach(produto => {
        const card = document.createElement("div")
        card.classList.add("card")
        card.innerHTML = `
            <p><strong>${produto.name}</strong></p>
            <p><strong>Categoria:</strong> ${produto.category}</p>
            <p><strong>Preço:</strong> R$${produto.priceCents},00</p>
			<p><strong>Ativo:</strong> ${produto.active ? "Sim" : "Não"}</p>
        `
		const buttonComprar = document.createElement("button")
		buttonComprar.textContent = "Comprar"
		buttonComprar.addEventListener("click", () => {
			if (!produto.active) {
				alert("Não é possível comprar produtos inativos!")
				return
			}
			produtoSelecionado = produto
			modalPedidos.style.display = "block"
			document.getElementById("quantity").value = ""
			document.getElementById("precoTotal").textContent = "Preço total: R$ 0,00"
			
		})
		card.appendChild(buttonComprar)
        container.appendChild(card)
    })
}

document.addEventListener("DOMContentLoaded", () => {
    produtosApi()
    const inputFiltro = document.getElementById("inputFiltro")
	const inputBusca = document.getElementById("inputBusca")
	
    inputFiltro.addEventListener("input", () => {
        const valor = inputFiltro.value.toLowerCase()
        const produtosFiltrados = produtos.filter(produto => produto.category.toLowerCase().includes(valor))
        carregarProdutos(produtosFiltrados)
    })
	
	inputBusca.addEventListener("keydown", (event) => {
		if (event.key === "Enter") {
			event.preventDefault()
			const palavra = inputBusca.value.toLowerCase()
			const resultadoBusca = produtos.filter(produto => produto.name.toLowerCase().includes(palavra))
			carregarProdutos(resultadoBusca)
		}
	})
})

const inputQuantity = document.getElementById("quantity")
const precoFinal = document.getElementById("precoTotal")
inputQuantity.addEventListener("input", () => {
	
	if(!produtoSelecionado) {
		return
	}
	
	const quantity = Number(inputQuantity.value)
	if (quantity <= 0 || isNaN(quantity)) {
		precoFinal.textContent = "Preço total: R$ 00,0"
		return
	}
	const total = quantity * produtoSelecionado.priceCents
	precoFinal.textContent = `Preço total: ${total},00`
})
