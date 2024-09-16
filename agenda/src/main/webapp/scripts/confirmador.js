function confirmar(id){
	
	let resposta = confirm("Confirma a exclusão deste contato?");
	if(resposta){
		window.location.href="delete?id=" + id;
	}
}