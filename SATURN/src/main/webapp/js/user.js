
var USR_TYPE_MANAGER = 0;
var USR_TYPE_ASSISTANT = 1;
var USR_TYPE_COORDINATOR = 2;
var USR_TYPE_TEACHER = 3;


var USER_LIST_TEMPLATE1 = "<li class=\"s_listitem2 clickable\"><div class=\"w-row\"><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var USER_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var USER_LIST_TEMPLATE3 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_EditUser\" value=\"";
var USER_LIST_TEMPLATE4 = "\" type=\"";
var USER_LIST_TEMPLATE5 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a id=\"Btn_DeleteUser\" value=\"";
var USER_LIST_TEMPLATE6 = "\" type=\"";
var USER_LIST_TEMPLATE7 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";


var SELECT_OPTION_TEMPLATE1 = "<option value=\"";
var SELECT_OPTION_TEMPLATE2 = "\">";
var SELECT_OPTION_TEMPLATE3 = "</option>";

var editDeleteUserId;
var editDeleteUserType;

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
			//result = result.assistants; //Quitar cuando se pase a java
			for (i in result) {
				$("#Assistants ul").append(	USER_LIST_TEMPLATE1 + result[i].userName +
					 						USER_LIST_TEMPLATE2 + result[i].name + " " + result[i].lastName +
											USER_LIST_TEMPLATE3 + result[i].userId +
											USER_LIST_TEMPLATE4 + USR_TYPE_ASSISTANT +
											USER_LIST_TEMPLATE5 + result[i].userId +
											USER_LIST_TEMPLATE6 + USR_TYPE_ASSISTANT +
											USER_LIST_TEMPLATE7);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fShowAddAssistant() {
	$("#Assistants").hide();
	$("#AddUser").show();
	$("#Form_CareerSelector").show();
	$("#Btn_AddAssistantSubmit").show();
	$("#Btn_AddAssistantCancel").show();

	$.ajax({
		method: 'GET',
		url: URL_CAREERS,

		success: function(result){
			//alert(JSON.stringify(result));
			//result = result.careers; //Quitar cuando se pase a java
			for (i in result) {
				$("#Select_AddUser_Career").append(	SELECT_OPTION_TEMPLATE1 + result[i].careerId +
													SELECT_OPTION_TEMPLATE2 + result[i].university + " | " + result[i].careerName +
													SELECT_OPTION_TEMPLATE3);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

//$("#a option:selected").val()

function fAddAssistant() {
	var userName;
	var password;
	var confirmPassword;
	var name;
	var lastName;
	var careerId;

	userName = $("#TextBox_AddUser_UserName").val();
	password = $("#TextBox_AddUser_Password").val();
	confirmPassword = $("#TextBox_AddUser_Confirm_Password").val();
	name = $("#TextBox_AddUser_Name").val();
	lastName = $("#TextBox_AddUser_LastName").val();
	careerId = $("#Select_AddUser_Career option:selected").val();
	if (userName && name && lastName && password && confirmPassword && (careerId !== "none") && (password === confirmPassword)) {
		$.ajax({
			method: 'POST',
			url: URL_ASSISTANTS,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"userName" : userName, "type" : USR_TYPE_ASSISTANT, "name" : name, "lastName" : lastName, "password" : password, "careerId" : careerId}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					fClearAddAssistant();
				}
				else if(result.status === "ALREADY_EXISTS"){
					alert("Se febe mostrar mensaje de que ya existe");
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
	fClearUserForm();
	$("#Form_CareerSelector").hide();
	$("#Btn_AddAssistantSubmit").hide();
	$("#Btn_AddAssistantCancel").hide();
	$("#AddUser").hide();
	fDisplayAssistants();
}

function fDisplayCoordinator() {
	$("#AssistantMenu").hide();
	$("#Coordinator").show();
	$("#Coordinator li").each(function( index ) {
		if(index !== 0 && index !==1){
			$(this).remove();
		}
	});
	$.ajax({
		method: 'GET',
		url: URL_COORDINATORS,

		success: function(result){
			//alert(JSON.stringify(result));
			//result = result.coordinators; //Quitar cuando se pase a java
			for (i in result) {
				$("#Coordinator ul").append(	USER_LIST_TEMPLATE1 + result[i].userName +
					 							USER_LIST_TEMPLATE2 + result[i].name + " " + result[i].lastName +
												USER_LIST_TEMPLATE3 + result[i].userId +
												USER_LIST_TEMPLATE4 + USR_TYPE_COORDINATOR +
												USER_LIST_TEMPLATE5 + result[i].userId +
												USER_LIST_TEMPLATE6 + USR_TYPE_COORDINATOR +
												USER_LIST_TEMPLATE7);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fShowAddCoordinator() {
	$("#Coordinator").hide();
	$("#AddUser").show();
	$("#Btn_AddCoordinatorSubmit").show();
	$("#Btn_AddCoordinatorCancel").show();
}

function fAddCoordinator() {
	var userName;
	var password;
	var confirmPassword;
	var name;
	var lastName;

	userName = $("#TextBox_AddUser_UserName").val();
	password = $("#TextBox_AddUser_Password").val();
	confirmPassword = $("#TextBox_AddUser_Confirm_Password").val();
	name = $("#TextBox_AddUser_Name").val();
	lastName = $("#TextBox_AddUser_LastName").val();

	if (userName && name && lastName && password && confirmPassword && (password === confirmPassword)) {
		$.ajax({
			method: 'POST',
			url: URL_COORDINATORS,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"userName" : userName,"type":USR_TYPE_COORDINATOR, "name" : name, "lastName" : lastName, "password" : password, "careerId" : CAREER_ID}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					fClearAddCoordinator();
				}
				else if(result.status === "ALREADY_EXISTS"){
					alert("Se febe mostrar mensaje de que ya existe");
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

function fClearAddCoordinator() {
	fClearUserForm();
	$("#Btn_AddCoordinatorSubmit").hide();
	$("#Btn_AddCoordinatorCancel").hide();
	$("#AddUser").hide();
	fDisplayCoordinator();
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
			//result = result.teachers; //Quitar cuando se pase a java
			for (i in result) {
				$("#Teachers ul").append(	USER_LIST_TEMPLATE1 + result[i].userName +
					 						USER_LIST_TEMPLATE2 + result[i].name + " " + result[i].lastName +
											USER_LIST_TEMPLATE3 + result[i].userId +
											USER_LIST_TEMPLATE4 + USR_TYPE_TEACHER +
											USER_LIST_TEMPLATE5 + result[i].userId +
											USER_LIST_TEMPLATE6 + USR_TYPE_TEACHER +
											USER_LIST_TEMPLATE7);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fShowAddTeacher() {
	$("#Teachers").hide();
	$("#AddUser").show();
	$("#Btn_AddTeacherSubmit").show();
	$("#Btn_AddTeacherCancel").show();
}

function fShowEditUser() {
	console.log("showEditUser");
	var url;

	editDeleteUserId = $(this).attr("value");
	editDeleteUserType = $(this).attr("type");

	$("#AddUser").show();
	$("#Btn_UpdateUserSubmit").show();
	$("#Btn_UpdateUserCancel").show();
	switch (Number(editDeleteUserType)) {
		case USR_TYPE_ASSISTANT:
			url = URL_ASSISTANTS;
			$("#Assistants").hide();
			break;
		case USR_TYPE_COORDINATOR:
			url = URL_COORDINATORS;
			$("#Coordinator").hide();
			break;
		case USR_TYPE_TEACHER:
			url = URL_TEACHERS;
			$("#Teachers").hide();
			break;
	}
	$.ajax({
		method: 'GET',
		url: url + "/" + editDeleteUserId,

		success: function(result){
			$("#TextBox_AddUser_UserName").attr("placeholder", result.userName);
			$("#TextBox_AddUser_Name").attr("placeholder", result.name);
			$("#TextBox_AddUser_LastName").attr("placeholder", result.lastName);
		},
		error: function(request, status, error){
			alert("Ha ocurrido un error inesperado, porfavor recargue la página e intente de nuevo");
		}
	});
}

function fClearUserForm() {
	$("#TextBox_AddUser_UserName").val("");
	$("#TextBox_AddUser_Name").val("");
	$("#TextBox_AddUser_LastName").val("");
	$("#TextBox_AddUser_Password").val("");
	$("#TextBox_AddUser_Confirm_Password").val("");
	$("#Select_AddUser_Career option").each(function(index) {
		if (index !== 0)
			$(this).remove();
	});
}





function fAddTeacher() {
	var userName = $("#TextBox_AddUser_UserName").val();
	var password = $("#TextBox_AddUser_Password").val();
	var confirmPassword = $("#TextBox_AddUser_Confirm_Password").val();
	var name = $("#TextBox_AddUser_Name").val();
	var lastName = $("#TextBox_AddUser_LastName").val();
        var career = $("#Select_AddUser_Career").val();
	if (userName && name && lastName && password && confirmPassword) {
		if (password === confirmPassword) {
			$.ajax({
				method: 'POST',
				url: URL_TEACHERS,
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data: JSON.stringify({"userName" : userName, "type":USR_TYPE_TEACHER, "password" : password, "name" : name, "lastName" : lastName, "careerId" : CAREER_ID}),

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
	fClearUserForm();
	$("#Btn_AddTeacherSubmit").hide();
	$("#Btn_AddTeacherCancel").hide();
	$("#AddUser").hide();
	fDisplayTeachers();
}




function fEditUser() {
	var url;
	var jObj;
	var userName = $("#TextBox_AddUser_UserName").val();
	var password = $("#TextBox_AddUser_Password").val();
	var confirmPassword = $("#TextBox_AddUser_Confirm_Password").val();
	var name = $("#TextBox_AddUser_Name").val();
	var lastName = $("#TextBox_AddUser_LastName").val();

	switch (Number(editDeleteUserType)) {
		case USR_TYPE_ASSISTANT:
			url = URL_ASSISTANTS;
			break;
		case USR_TYPE_COORDINATOR:
		url = URL_COORDINATORS;
			break;
		case USR_TYPE_TEACHER:
			url = URL_TEACHERS;
			break;
	}
	jObj = {};
	if (userName || (password && confirmPassword) || name || lastName) {
		if (password === confirmPassword) {
			if (userName)
				jObj.userName = userName;
			if (password)
				jObj.password = password;
			if (name)
				jObj.name = name;
			if (lastName)
				jObj.lastName = lastName;
			$.ajax({
				method: 'PUT',
				url: url + "/" + editDeleteUserId,
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data: JSON.stringify(jObj),

				success: function(result){
					console.log("[Login] Result " + JSON.stringify(result));

					if(result.status === "OK"){
						fClearEditUser();
					}
				},

				error: function(request, status, error){
					console.log("[Login] Error: " + error);
				}
			});
		} else {
			alert("Contraseña no es igual")
		}

	} else {
		alert("Se debe mostrar mensaje de que al menos un valor debe cambiar");
	}
}

function fClearEditUser() {
	$("#TextBox_AddUser_UserName").val("");
	$("#TextBox_AddUser_Password").val("");
	$("#TextBox_AddUser_Confirm_Password").val("");
	$("#TextBox_AddUser_Name").val("");
	$("#TextBox_AddUser_LastName").val("");
	$("#TextBox_AddUser_UserName").attr("placeholder", "");
	$("#TextBox_AddUser_Password").attr("placeholder", "");
	$("#TextBox_AddUser_Confirm_Password").attr("placeholder", "");
	$("#TextBox_AddUser_Name").attr("placeholder", "");
	$("#TextBox_AddUser_LastName").attr("placeholder", "");
	$("#Btn_UpdateUserSubmit").hide();
	$("#Btn_UpdateUserCancel").hide();
	$("#AddUser").hide();

	switch (Number(editDeleteUserType)) {
		case USR_TYPE_ASSISTANT:
			fDisplayAssistants();
			break;
		case USR_TYPE_COORDINATOR:
			fDisplayCoordinator();
			break;
		case USR_TYPE_TEACHER:
			fDisplayTeachers();
			break;
	}
	editDeleteUserId = null;
	editDeleteUserType = null;
}

function fConfirmDeleteUser() {
	editDeleteUserId = $(this).attr("value");
	editDeleteUserType = $(this).attr("type");
	switch (Number(editDeleteUserType)) {
		case USR_TYPE_ASSISTANT:
			$("#Assistants").hide();
			break;
		case USR_TYPE_COORDINATOR:
			$("#Coordinator").hide();
			break;
		case USR_TYPE_TEACHER:
			$("#Teachers").hide();
			break;
	}
	$("#ConfirmAction").show();
	$("#Btn_DeleteUserSubmit").show();
	$("#Btn_DeleteUserCancel").show();
}

function fDeleteUser() {
	var url;

	$("#ConfirmAction").hide();

	switch (Number(editDeleteUserType)) {
		case USR_TYPE_ASSISTANT:
			url = URL_ASSISTANTS;
			break;
		case USR_TYPE_COORDINATOR:
			url = URL_COORDINATORS;
			break;
		case USR_TYPE_TEACHER:
			url = URL_TEACHERS;
			break;
	}
	$.ajax({
		method: 'DELETE',
		url: url + "/" + editDeleteUserId,
		success: function(result){
			console.log("[Login] Result " + result);

			if(result.status === "OK"){
				fClearDeleteUser();
			}
		},

		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fClearDeleteUser() {
	$("#Btn_DeleteUserSubmit").hide();
	$("#Btn_DeleteUserCancel").hide();
	$("#ConfirmAction").hide();

	switch (Number(editDeleteUserType)) {
		case USR_TYPE_ASSISTANT:
			fDisplayAssistants();
			break;
		case USR_TYPE_COORDINATOR:
			fDisplayCoordinator();
			break;
		case USR_TYPE_TEACHER:
			fDisplayTeachers();
			break;
	}
	editDeleteUserId = null;
	editDeleteUserType = null;
}
