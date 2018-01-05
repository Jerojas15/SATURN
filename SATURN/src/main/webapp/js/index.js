var URL_LOGIN = "/SATURN/rest/login";
var URL_CAREERS = "/SATURN/rest/careers";
var URL_ASSISTANTS = "/SATURN/rest/assistants";
var URL_TEACHERS = "/SATURN/rest/teachers";

var USR_TYPE_MANAGER = 0;
var USR_TYPE_ASSISTANT = 1;
var USR_TYPE_COORDINATOR = 2;
var USR_TYPE_TEACHER = 3;

/*
var CAREER_LIST_TEMPLATE1 = "<li id=\"";
var CAREER_LIST_TEMPLATE2 = "\" class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE4 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE5 = "</div></div></div></li>";
*/

var CAREER_LIST_TEMPLATE1 = "<li class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE4 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_Edit_Career\" value=\"";
var CAREER_LIST_TEMPLATE5 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a id=\"Btn_Delete_Career\" value=\"";
var CAREER_LIST_TEMPLATE6 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";

/*
var USER_LIST_TEMPLATE1 = "<li id=\"";
var USER_LIST_TEMPLATE2 = "\"class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var USER_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var USER_LIST_TEMPLATE4 = "</div></div></div></li>";
*/

var USER_LIST_TEMPLATE1 = "<li class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var USER_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var USER_LIST_TEMPLATE3 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_Edit_User\" value=\"";
var USER_LIST_TEMPLATE4 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a id=\"Btn_Delete_User\" value=\"";
var USER_LIST_TEMPLATE5 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";

var usrType;
var lastEditDeleteBtn;

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
	$("#AddUser").show();
	$("#Form_CareerSelector").show();
	$("#Btn_AddAssistantSubmit").show();
	$("#Btn_AddAssistantCancel").show();
}

function fShowAddTeacher() {
	$("#Teachers").hide();
	$("#AddUser").show();
	$("#Btn_AddTeacherSubmit").show();
	$("#Btn_AddTeacherCancel").show();
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
	var university = $("#TextBox_AddCareer_University").val();
	var career = $("#TextBox_AddCareer_CareerName").val();
	var plan = $("#TextBox_AddCareer_Plan").val();

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
	$("#TextBox_AddCareer_University").val("");
	$("#TextBox_AddCareer_CareerName").val("");
	$("#TextBox_AddCareer_Plan").val("");
	$("#AddCareers").hide();
	fDisplayCareers();

}

function fAddAssistant() {
	var userName = $("#TextBox_AddUser_UserName").val();
	var name = $("#TextBox_AddUser_Name").val();
	var lastName = $("#TextBox_AddUser_LastName").val();
	if (userName && name && lastName) {
		$.ajax({
			method: 'POST',
			url: URL_ASSISTANTS,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"userName" : userName, "name" : name, "lastName" : lastName, "type" : USR_TYPE_ASSISTANT}),

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
	$("#TextBox_AddUser_UserName").val("");
	$("#TextBox_AddUser_Name").val("");
	$("#TextBox_AddUser_LastName").val("");
	$("#Form_CareerSelector").hide();
	$("#Btn_AddAssistantSubmit").hide();
	$("#Btn_AddAssistantCancel").hide();
	$("#AddUser").hide();
	fDisplayAssistants();
}

function fAddTeacher() {
	var userName = $("#TextBox_AddUser_UserName").val();
	var password = $("#TextBox_AddUser_Password").val();
	var confirmPassword = $("#TextBox_AddUser_Confirm_Password").val();
	var name = $("#TextBox_AddUser_Name").val();
	var lastName = $("#TextBox_AddUser_LastName").val();
	if (userName && name && lastName && password && confirmPassword) {
		if (password === confirmPassword) {
			$.ajax({
				method: 'POST',
				url: URL_TEACHERS,
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data: JSON.stringify({"userName" : userName, "password" : password, "name" : name, "lastName" : lastName, "type" : USR_TYPE_TEACHER}),

				success: function(result){
					console.log("[Login] Result " + JSON.stringify(result));

					if(result.status === "OK"){
						fClearAddTeacher();
					}
					else if(result.status === "ALREADY_EXISTS"){
						alert("Se febe mostrar mensaje de que ya existe el profesor");
					}
				},

				error: function(request, status, error){
					console.log("[Login] Error: " + error);
				}
			});
		} else {
			alert("Contraseña no igual");
		}
	} else {
		alert("Se febe mostrar mensaje de que se requieren datos");
	}
}

function fClearAddTeacher() {
	$("#TextBox_AddUser_UserName").val("");
	$("#TextBox_AddUser_Name").val("");
	$("#TextBox_AddUser_LastName").val("");
	$("#TextBox_AddUser_Password").val("");
	$("#TextBox_AddUser_Confirm_Password").val("");
	$("#Form_CareerSelector").hide();
	$("#Btn_AddAssistantSubmit").hide();
	$("#Btn_AddAssistantCancel").hide();
	$("#AddUser").hide();
	fDisplayTeachers();
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
				$("#Careers ul").append(CAREER_LIST_TEMPLATE1 + result[i].university +
					 					CAREER_LIST_TEMPLATE2 + result[i].career +
										CAREER_LIST_TEMPLATE3 + result[i].plan +
										CAREER_LIST_TEMPLATE4 + result[i].id +
										CAREER_LIST_TEMPLATE5 + result[i].id +
										CAREER_LIST_TEMPLATE6);
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
				$("#Assistants ul").append(	USER_LIST_TEMPLATE1 + result[i].id +
					 						USER_LIST_TEMPLATE2 + result[i].userName +
											USER_LIST_TEMPLATE3 + result[i].name + " " + result[i].lastName +
											USER_LIST_TEMPLATE4);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fDisplayTeachers() {
	$("#AssistantMenu").hide();
	$("#Teachers").show();
	$("#Teachers li").each(function( index ) {
		if(index !== 0 && index !==1){
			$(this).remove();
		}
	});
	$.ajax({
		method: 'GET',
		url: URL_TEACHERS,

		success: function(result){
			//alert(JSON.stringify(result));
			for (i in result) {
				$("#Teachers ul").append(	USER_LIST_TEMPLATE1 + result[i].userName +
					 						USER_LIST_TEMPLATE2 + result[i].name + " " + result[i].lastName +
											USER_LIST_TEMPLATE3 + result[i].id +
											USER_LIST_TEMPLATE4 + result[i].id +
											USER_LIST_TEMPLATE5);
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
	//$("#Btn_Schedules").click();
	$("#Btn_AddCareer").click(fShowAddCareer);
	$("#Btn_AddCareerSubmit").click(fAddCareer);
	$("#Btn_AddCareerCancel").click(fClearAddCareer);
	$("#Btn_AddAssistant").click(fShowAddAssistant);
	$("#Btn_AddAssistantSubmit").click(fAddAssistant);
	$("#Btn_AddAssistantCancel").click(fClearAddAssistant);
	//$("Btn_Coordinators").click();
	//$("Btn_Groups1").click();
	$("#Btn_Teachers1").click(fDisplayTeachers);
	$("#Btn_AddTeacher").click(fShowAddTeacher);
	$("#Btn_AddTeacherSubmit").click(fAddTeacher);
	$("#Btn_AddTeacherCancel").click(fClearAddTeacher);
});
/* Agregar un handler de tipo click a elementos de una lista que aun no han sido agregados */
$(document).on('click','ul li',function(){
	if (lastEditDeleteBtn) {
		lastEditDeleteBtn.hide();
	}
    lastEditDeleteBtn = $(this).find("#Btn_Edit_Delete");
	lastEditDeleteBtn.show();
});

/* Saber si un boton fue oprimido y optener valores del boton
$(document).on('click','#list #Btn1',function(){
    alert($(this).attr("value"));
});
*/
/* eliminar elementos de una lista eceptuando los elementos 0 y 1
$("#myList li").each(function( index ) {
	alert( index + ": " + $( this ).text() );
	if(index !== 0 && index !==1){
		$(this).remove();
	}
});
 */
