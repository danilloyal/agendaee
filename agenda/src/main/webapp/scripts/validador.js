function validar() {
    // Limpar mensagens de erro antigas
    limparMensagensErro();

    // Obter valores dos campos
    let nome = formContato.nome.value.trim();
    let fone = formContato.fone.value.trim();
    let email = formContato.email.value.trim();
    let isValid = true;

    // Validar campo nome
    if (nome === "") {
        exibirMensagemErro('Preencha o campo nome', 'nomeError');
        isValid = false;
    }

    // Validar campo fone
    else if (fone === "") {
        exibirMensagemErro('Preencha o campo fone', 'foneError');
        isValid = false;
    } else if (!/^\d+$/.test(fone)) { // Verifica se o campo fone contém apenas números
        exibirMensagemErro('O campo fone deve conter apenas números', 'foneError');
        isValid = false;
    }

    // Validar campo email
    if (email === "") {
        exibirMensagemErro('Preencha o campo email', 'emailError');
        isValid = false;
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) { // Verifica se o email tem um formato válido
        exibirMensagemErro('Por favor, insira um e-mail válido', 'emailError');
        isValid = false;
    }

    // Se todas as validações passarem, submete o formulário
    if (isValid) {
        document.forms["formContato"].submit();
    }

    return false; // Prevenir o envio do formulário até que seja validado
}

function exibirMensagemErro(mensagem, idElementoErro) {
    let elementoErro = document.getElementById(idElementoErro);
    elementoErro.textContent = mensagem;
    elementoErro.style.color = 'red';
    elementoErro.style.fontSize = '14px';
    elementoErro.style.marginTop = '5px';
}

function limparMensagensErro() {
    let mensagensErro = document.querySelectorAll('.error-message');
    mensagensErro.forEach(function(mensagem) {
        mensagem.textContent = '';
    });
}
