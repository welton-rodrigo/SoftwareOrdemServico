function anexarArquivo() {
	
	
	var mensagem = myForm.txt_mensagem.value;
	if(mensagem != ""){
		var resposta = confirm("Deseja salvar mensagem?");
		if(resposta){
		    document.getElementById("myForm").submit();
			}
	}else{
		alert('Preencha o campo mensagem');
		myForm.txt_mensagem.focus();
		return false;
		}
	
	
}


function abrirTicketFunction() {
	
	var mensagem = myForm.txt_mensagem.value;
	if(mensagem != ""){
		var resposta = confirm("Deseja salvar mensagem?");
		if(resposta){
		    document.getElementById("myForm").submit();
			}
	}else{
		alert('Preencha o campo mensagem');
		myForm.txt_mensagem.focus();
		return false;
		}
	
	
}

function novoTicketFormFunction() {
	
	var assunto = form2.txt_assunto.value;
	var mensagem = form2.txt_mensagem.value;
	if(mensagem != "" && assunto != ""){
		var resposta = confirm("Deseja salvar mensagem?");
		if(resposta){
		    document.getElementById("form2").submit();
			}
	}else{
		alert('Preencher campos');
		form2.txt_assunto.focus();
		return false;
		}
	
	
}

function Mudarestado(el) {
    var display = document.getElementById(el).style.display;
   
    	if(display == "none"){
    		document.getElementById(el).style.display = 'block';

    	}else
        document.getElementById(el).style.display = 'none';
}




