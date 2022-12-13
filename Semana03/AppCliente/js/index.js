
function fnListado(){
    alert("Hola");
}


function cargarPagina(idDiv, pagina){
    let codigo = "#" + idDiv;
    $(codigo).load(pagina);
}
