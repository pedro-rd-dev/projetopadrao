function logarApi(email, password) {

    var usuario = JSON.stringify({ email: email, password: password })

    $.ajax({
        url: "https://escolarapp2.herokuapp.com/account/login/",
        contentType: 'application/json',
        cache: false,
        method: 'POST',
        dataType: 'json',
        data: usuario,
        success: function(objetoToken) {
            console.log(objetoToken)

            /////////////////////ARMAZENAMENTO//////////////////////////
            ///////////////////preparando token/////////////////////////
            const key = "Token " + objetoToken.key;

            //SALVANDO O TOKEN NO LOCAL STORAGE DO NAVEGADOR
            window.localStorage.setItem("Token", key);


            objetotextoLogando.style.display = 'none';
            objetoTextoLogin.style.display = 'inline';

            window.location.href = "../../tarefas/tarefas.html"

        },
        error: function(error) {
            var erros = JSON.parse(error.responseText)

            console.log(erros.non_field_errors[0])


        }
    });
}

function logoffApi() {
    window.localStorage.removeItem("Token", "");
    console.log("indo para index")
    window.location.href = "../index.html"
}