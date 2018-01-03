var URL_LOGIN = "/SATURN/rest/login";
var URL_CAREERS = "/SATURN/rest/careers";
var URL_ASSISTANTS = "/SATURN/rest/assistants";

var USR_TYPE_MANAGER = "manager";
var USR_TYPE_ASSISTANT = "assistant";
var USR_TYPE_COORDINATOR = "coordinator";
var USR_TYPE_TEACHER = "teacher";

var CAREER_LIST_TEMPLATE1 = "<li id=\"";
var CAREER_LIST_TEMPLATE2 = "\" class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE4 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE5 = "</div></div></div></li>";

var ASSISTANT_LIST_TEMPLATE1 = "<li id=\"";
var ASSISTANT_LIST_TEMPLATE2 = "\"class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var ASSISTANT_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var ASSISTANT_LIST_TEMPLATE4 = "</div></div></div></li>";

var usrType;

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
	$("#StartMenu").hide();
	$("#LogIn").show();
}

function fShowHelloMsg(msg) {
	$("#HelloMsg").show();
	$("#Text_Hello").text(msg);
}

function fShowAddCareer() {
	$("#Careers").hide();
	$("#AddCareers").show();
}

function fShowAddAssistant() {
	$("#Assistants").hide();
	$("#AddAssistants").show();
}

/*
 * Función la cual obtiene los parametros para iniciar sesión
 * y se comunica con el sistema para iniciar sesión
 */
function fLogIn() {
	email = $("#TextBox_Email").val();
	pass = $("#TextBox_Password").val(); //se debe tranformar en el sha256 en vez del texto plano.....

	if(email && pass){
		$.ajax({
			method: 'POST',
			url: URL_LOGIN,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"email" : email, "password" : pass}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					$("#TextBox_Email").val(""); //Es importante limpiar los campos de texto
					$("#TextBox_Password").val("");
					$("#LogIn").hide();
					usrType = result.usrType;
					switch (usrType) {
						case USR_TYPE_MANAGER:
						$("#ManagerMenu").show();
						break;null

						case USR_TYPE_ASSISTANT:
						$("#AssistantMenu").show();
						break;

						case USR_TYPE_COORDINATOR:
						$("#CoordinatorMenu").show();
						break;

						case USR_TYPE_TEACHER:
						$("#TeacherMenu").show();
						break;
					}
					fShowHelloMsg(result.helloMsg);
				}
			},

			error: function(request, status, error){
				console.log("[Login] Error: " + error);
			}
		});

	}else {
		alert("Se febe mostrar mensaje de que se requieren datos");
	}
}

function fAddCareer() {
	var university = $("#TextBox_University").val();
	var career = $("#TextBox_CareerName").val();
	var plan = $("#TextBox_Plan").val();

	if (university && career && plan) {
		$.ajax({
			method: 'POST',
			url: URL_CAREERS,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"university" : university, "career" : career, "plan" : plan}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					fClearAddCareer();
				}
				else if(result.status === "ALREADY_EXISTS"){

				}
			},

			error: function(request, status, error){
				console.log("[Login] Error: " + error);
			}
		});
	} else {
		alert("Se febe mostrar mensaje de que se requieren datos");
	}
}

function fClearAddCareer() {
	$("#TextBox_University").val("");
	$("#TextBox_CareerName").val("");
	$("#TextBox_Plan").val("");
	$("#AddCareers").hide();
	fDisplayCareers();

}

function fAddAssistant() {
	var userName = $("#TextBox_UserName").val();
	var name = $("#TextBox_Name").val();
	var lastName = $("#TextBox_LastName").val();
	if (userName && name && lastName) {
		$.ajax({
			method: 'POST',
			url: URL_ASSISTANTS,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"userName" : userName, "name" : name, "lastName" : lastName}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					fClearAddAssistant();
				}
				else if(result.status === "ALREADY_EXISTS"){

				}
			},

			error: function(request, status, error){
				console.log("[Login] Error: " + error);
			}
		});
	} else {
		alert("Se febe mostrar mensaje de que se requieren datos");
	}
}

function fClearAddAssistant() {
	$("#TextBox_UserName").val("");
	$("#TextBox_Name").val("");
	$("#TextBox_LastName").val("");
	$("#AddAssistants").hide();
	fDisplayAssistants();
}

function fDisplayCareers() {
	$("#ManagerMenu").hide();
	$("#Careers").show();
	$("#Careers li").each(function( index ) {
		if(index !== 0 && index !==1){
			$(this).remove();
		}
	});
	$.ajax({
		method: 'GET',
		url: URL_CAREERS,

		success: function(result){
			//alert(JSON.stringify(result));
			for (i in result) {
				$("#Careers ul").append(CAREER_LIST_TEMPLATE1 + result[i].id +
					 					CAREER_LIST_TEMPLATE2 + result[i].university +
										CAREER_LIST_TEMPLATE3 + result[i].career +
										CAREER_LIST_TEMPLATE4 + result[i].plan +
										CAREER_LIST_TEMPLATE5);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fDisplayAssistants() {
	$("#ManagerMenu").hide();
	$("#Assistants").show();
	$("#Assistants li").each(function( index ) {
		if(index !== 0 && index !==1){
			$(this).remove();
		}
	});
	$.ajax({
		method: 'GET',
		url: URL_ASSISTANTS,

		success: function(result){
			//alert(JSON.stringify(result));
			for (i in result) {
				$("#Assistants ul").append(	ASSISTANT_LIST_TEMPLATE1 + result[i].id +
					 						ASSISTANT_LIST_TEMPLATE2 + result[i].userName +
											ASSISTANT_LIST_TEMPLATE3 + result[i].name + " " + result[i].lastName +
											ASSISTANT_LIST_TEMPLATE4);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

$(document).ready(function(){
	$("#Btn_Start").click(fReload);
	$("#Btn_LogIn1").click(fShowLogIn);
	$("#Btn_LogIn2").click(fShowLogIn);
	$("#Btn_LogInSubmit").click(fLogIn);
	$("#Btn_Careers").click(fDisplayCareers);
	$("#Btn_Assistants").click(fDisplayAssistants);
	$("#Btn_AddCareer").click(fShowAddCareer);
	$("#Btn_AddCareerSubmit").click(fAddCareer);
	$("#Btn_AddCareerCancel").click(fClearAddCareer);
	$("#Btn_AddAssistant").click(fShowAddAssistant);
	$("#Btn_AddAssistantSubmit").click(fAddAssistant);
	$("#Btn_AddAssistantCancel").click(fClearAddAssistant);
});

/* eliminar elementos de una lista eceptuando los elementos 0 y 1
$("#myList li").each(function( index ) {
	alert( index + ": " + $( this ).text() );
	if(index !== 0 && index !==1){
		$(this).remove();
	}
});
 */
