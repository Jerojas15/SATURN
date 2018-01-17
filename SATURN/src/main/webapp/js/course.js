
var COURSE_LIST_TEMPLATE1 = "<li class=\"s_listitem2 clickable\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var COURSE_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var COURSE_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var COURSE_LIST_TEMPLATE4 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_EditCourse\" value=\"";
var COURSE_LIST_TEMPLATE5 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a id=\"Btn_DeleteCourse\" value=\"";
var COURSE_LIST_TEMPLATE6 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";

var courseId;

function fDisplayCourses() {
	$("#CoordinatorMenu").hide();
	$("#Courses").show();
	$("#Courses li").each(function( index ) {
		if(index !== 0 && index !==1){
			$(this).remove();
		}
	});
	$.ajax({
		method: 'GET',
		url: URL_COURSES,

		success: function(result){
			//alert(JSON.stringify(result));
			//result = result.courses; //Quitar cuando se pase a java
			for (i in result) {
				$("#Courses ul").append(COURSE_LIST_TEMPLATE1 + result[i].code +
										COURSE_LIST_TEMPLATE2 + result[i].courseName +
										COURSE_LIST_TEMPLATE3 + result[i].block +
										COURSE_LIST_TEMPLATE4 + result[i].id +
										COURSE_LIST_TEMPLATE5 + result[i].id +
										COURSE_LIST_TEMPLATE6);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fShowAddCourse() {
	$("#Courses").hide();
	$("#AddCourse").show();
	$("#Btn_AddCourseSubmit").show()
	$("#Btn_AddCourseCancel").show()
}

function fAddCourse() {
	var code;
	var courseName;
	var block;

	code = $("#TextBox_AddCourse_Code").val();
	courseName = $("#TextBox_AddCourse_CourseName").val();
	block = $("#TextBox_AddCourse_Block").val();

	if (code && courseName && block) {
		$.ajax({
			method: 'POST',
			url: URL_COURSES,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"code" : code, "name" : courseName, "semester" : block, "careerId" : CAREER_ID}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					fClearCourseForm();
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

function fClearCourseForm() {
	$("#TextBox_AddCourse_Code").val("");
	$("#TextBox_AddCourse_CourseName").val("");
	$("#TextBox_AddCourse_Block").val("");
	$("#TextBox_AddCourse_Code").attr("placeholder", "Número");
	$("#TextBox_AddCourse_CourseName").attr("placeholder", "");
	$("#TextBox_AddCourse_Block").attr("placeholder", "Número");
	$("#Btn_AddCourseSubmit").hide()
	$("#Btn_AddCourseCancel").hide()

	$("#AddCourse").hide();
	fDisplayCourses();
}

function fShowEditCourse() {
	$("#Courses").hide();
	$("#AddCourse").show();
	$("#Btn_UpdateCourseSubmit").show();
	$("#Btn_UpdateCourseCancel").show();

	courseId = $(this).attr("value");

	$.ajax({
		method: 'GET',
		url: URL_COURSES + "/" + courseId,

		success: function(result){
			$("#TextBox_AddCourse_Code").attr("placeholder", result.code);
			$("#TextBox_AddCourse_CourseName").attr("placeholder", result.courseName);
			$("#TextBox_AddCourse_Block").attr("placeholder", result.block);
		},
		error: function(request, status, error){
			alert("Ha ocurrido un error inesperado, porfavor recargue la página e intente de nuevo");
		}
	});
}

function fEditCourse() {
	var code;
	var courseName;
	var block;
	var jObj;

	code = $("#TextBox_AddCourse_Code").val();
	courseName = $("#TextBox_AddCourse_CourseName").val();
	block = $("#TextBox_AddCourse_Block").val();

	jObj = {};
	if (code || courseName || block) {
		if (code)
			jObj.code = code;
		if (courseName)
			jObj.courseName = courseName;
		if (block)
			jObj.block = block;

		$.ajax({
			method: 'PUT',
			url: URL_COURSES + "/" + courseId,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify(jObj),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					courseId = null;
					fClearCourseForm();
				}
			},

			error: function(request, status, error){
				console.log("[Login] Error: " + error);
				courseId = null;
			}
		});
	} else {
		alert("Se febe mostrar mensaje de que se requieren datos");
	}
}

function fConfirmDeleteCourse() {
	courseId = $(this).attr("value");

	$("#Courses").hide();
	$("#ConfirmAction").show();
	$("#Btn_DeleteCourseSubmit").show();
	$("#Btn_DeleteCourseCancel").show();
}

function fDeleteCourse() {

	$.ajax({
		method: 'DELETE',
		url: URL_COURSES + "/" + courseId,
		success: function(result){
			console.log("[Login] Result " + JSON.stringify(result));

			if(result.status === "OK"){
				fClearDeleteCourse();
			}
		},

		error: function(request, status, error){
			console.log("[Login] Error: " + error);
			careerId = null;
		}
	});
}

function fClearDeleteCourse() {
	courseId = null;

	$("#Btn_DeleteCourseSubmit").hide();
	$("#Btn_DeleteCourseCancel").hide();
	$("#ConfirmAction").hide();

	fDisplayCourses();
}
