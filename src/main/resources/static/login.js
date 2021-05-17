var objetoEmail = document.getElementById("exampleInputEmail1");
var objetoPassword = document.getElementById("exampleInputPassword1");
var objetoAlertaEmail = document.getElementById("alertaEmail");
var objetotextoLogando = document.getElementById("textoLogando");
var objetoTextoLogin = document.getElementById("textoLogin");

objetotextoLogando.style.display = 'none';
objetoEmail.value = "pedroh.mix@gmail.com"
objetoPassword.value = "123456";

function login() {

    var retorno = validateEmail(objetoEmail.value);

    if (!retorno) {
        objetoAlertaEmail.innerHTML = "Este não é um email  valido"
    } else {

        objetoTextoLogin.style.display = 'none';
        objetotextoLogando.style.display = 'inline';
        objetoAlertaEmail.innerHTML = ""


        logarApi(objetoEmail.value,objetoPassword.value);
    }

}


