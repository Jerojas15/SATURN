var URL_LOGIN = "/SATURN/rest/login";

/*
 * Función la cual debe volver al inicio de la pagina;
 * si se presenta una sesión, deberia regresarlo al
 * menú principal del usuario especifico
*/
function fReload() { //Sin terminar
	location.reload();
}

/*
 * Función la cual muestra el menú de inicio de sesión cuando se
 * presionan los botones de "Iniciar Sesión"
*/
function fShowLogIn() {
	$("#Btn_LogIn1").hide();
	$("#StartManu").hide();
	$("#LogIn").show();
}

/*
 * Función la cual obtiene los parametros para iniciar sesión
 * y se comunica con el sistema para iniciar sesión
 */
function fLogIn() {
	email = $("#TextBox_Email").val();
	pass = $("#TextBox_Password").val();

	if(email && pass){
		$.ajax({
        method: 'POST',
        url: URL_LOGIN,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({"email" : email, "password" : pass}),

        success: function(result){
            console.log("[Login] Result " + JSON.stringify(result));
			alert(result.status);
        },

        error: function(request, status, error){
            console.log("[Login] Error: " + error);
        }
    });

	}else {
		alert("Se febe mostrar mensaje de que se requieren datos");
	}
}

$(document).ready(function(){
	$("#Btn_Start").click(fReload);
	$("#Btn_LogIn1").click(fLogIn);
	$("#Btn_LogIn2").click(fShowLogIn);
	$("#Btn_LogInSumbit").click(fLogIn);
});
