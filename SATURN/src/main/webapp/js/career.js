
var CAREER_LIST_TEMPLATE1 = "<li class=\"s_listitem2 clickable\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var CAREER_LIST_TEMPLATE4 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_EditCareer\" value=\"";
var CAREER_LIST_TEMPLATE5 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a id=\"Btn_DeleteCareer\" value=\"";
var CAREER_LIST_TEMPLATE6 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";

var careerId;

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
			//result = result.careers; //Quitar cuando se pase a java
			for (i in result) {
				$("#Careers ul").append(CAREER_LIST_TEMPLATE1 + result[i].university +
					 					CAREER_LIST_TEMPLATE2 + result[i].careerName +
										CAREER_LIST_TEMPLATE3 + result[i].plan +
										CAREER_LIST_TEMPLATE4 + result[i].careerId +
										CAREER_LIST_TEMPLATE5 + result[i].careerId +
										CAREER_LIST_TEMPLATE6);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fShowAddCareer() {
	$("#Careers").hide();
	$("#AddCareer").show();
	$("#Btn_AddCareerSubmit").show()
	$("#Btn_AddCareerCancel").show()
}

function fAddCareer() {
	var university;
	var career;
	var plan;

	university = $("#TextBox_AddCareer_University").val();
	career = $("#TextBox_AddCareer_CareerName").val();
	plan = $("#TextBox_AddCareer_Plan").val();

	if (university && career && plan) {
		$.ajax({
			method: 'POST',
			url: URL_CAREERS,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"university" : university, "careerName" : career, "plan" : plan}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					fCancelAddEditCareer();
				}
				else if(result.status === "ALREADY_EXISTS"){

				}
			},

			error: function(request, status, error){
				console.log("[Login] Error: " + error);
			}
		});
	} else {
		alert("Se deben insertar todos los datos");
	}
}

function fCancelAddEditCareer() {
	fClearCareerForm();
	fDisplayCareers();
}

function fClearCareerForm() {
	$("#TextBox_AddCareer_University").val("");
	$("#TextBox_AddCareer_CareerName").val("");
	$("#TextBox_AddCareer_Plan").val("");
	$("#TextBox_AddCareer_University").attr("placeholder", "[TEC] [UCR] [UNA] [UNED]");
	$("#TextBox_AddCareer_CareerName").attr("placeholder", "");
	$("#TextBox_AddCareer_Plan").attr("placeholder", "");
	$("#Btn_AddCareerSubmit").hide();
	$("#Btn_AddCareerCancel").hide();
	$("#Btn_UpdateCareerSubmit").hide();
	$("#Btn_UpdateCareerCancel").hide();
	$("#AddCareer").hide();
}

function fShowEditCareer() {

	$("#Careers").hide();
	$("#AddCareer").show();
	$("#Btn_UpdateCareerSubmit").show();
	$("#Btn_UpdateCareerCancel").show();

	careerId = $(this).attr("value");

	$.ajax({
		method: 'GET',
		url: URL_CAREERS + "/" + careerId,

		success: function(result){
			$("#TextBox_AddCareer_University").attr("placeholder", result.university);
			$("#TextBox_AddCareer_CareerName").attr("placeholder", result.careerName);
			$("#TextBox_AddCareer_Plan").attr("placeholder", result.plan);
		},
		error: function(request, status, error){
			alert("Ha ocurrido un error inesperado, porfavor recargue la página e intente de nuevo");
		}
	});
}

function fEditCareer() {
	var university;
	var career;
	var plan;
	var jObj;

	university = $("#TextBox_AddCareer_University").val();
	careerName = $("#TextBox_AddCareer_CareerName").val();
	plan = $("#TextBox_AddCareer_Plan").val();

	jObj = {};
	if (university || careerName || plan) {
		if (university)
			jObj.university = university;
		if (careerName)
			jObj.careerName = careerName;
		if (plan)
			jObj.plan = plan;

		$.ajax({
			method: 'PUT',
			url: URL_CAREERS + "/" + careerId,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify(jObj),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					careerId = null;
					fClearCareerForm();
					fDisplayCareers();
				}
			},

			error: function(request, status, error){
				console.log("[Login] Error: " + error);
				careerId = null;
			}
		});
	} else {
		alert("Se deben insertar todos los datos");
	}
}

function fConfirmDeleteCareer() {
	careerId = $(this).attr("value");

	$("#Careers").hide();
	$("#ConfirmAction").show();
	$("#Btn_DeleteCareerSubmit").show();
	$("#Btn_DeleteCareerCancel").show();
}

function fDeleteCareer() {

	$.ajax({
		method: 'DELETE',
		url: URL_CAREERS + "/" + careerId,
		success: function(result){
			console.log("[Login] Result " + JSON.stringify(result));

			if(result.status === "OK"){
				fCancelDeleteCareer();
			}
		},

		error: function(request, status, error){
			console.log("[Login] Error: " + error);
			careerId = null;
		}
	});
}

function fCancelDeleteCareer() {
	fClearDeleteCareer();
	fDisplayCareers();
}

function fClearDeleteCareer() {
	careerId = null;

	$("#Btn_DeleteCareerSubmit").hide();
	$("#Btn_DeleteCareerCancel").hide();
	$("#ConfirmAction").hide();
}
