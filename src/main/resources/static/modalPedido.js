const modalPedido = document.getElementById("modalPedido");
const btnPedido = document.getElementById("openModalPedido");
const spanPedido = document.getElementsByClassName("closePedido")[0];

btnPedido.onclick = function() {
    modalPedido.style.display = "block";
}

spanPedido.onclick = function() {
     modalPedido.style.display = "none";
}

window.onclick = function(event) {
       if (event.target == modalPedido) {
                modalPedido.style.display = "none";
       }
}