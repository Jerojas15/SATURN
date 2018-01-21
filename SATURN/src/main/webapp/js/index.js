var URL_LOGIN = "/SATURN/rest/login";
var URL_CAREERS = "/SATURN/rest/careers";
var URL_ASSISTANTS = "/SATURN/rest/assistants";
var URL_COORDINATORS = "/SATURN/rest/coordinators";
var URL_TEACHERS = "/SATURN/rest/teachers";
var URL_TEACHERS_AVAILABILITIES = "/SATURN/rest/teachers/availabilities";
var URL_TEACHERS_AFINITIES = "/SATURN/rest/teachers/afinities";
var URL_COURSES = "/SATURN/rest/courses";
var URL_GROUPS = "/SATURN/rest/groups";
var URL_GROUPS_SESSIONS = "/SATURN/rest/groups/sessions";
var URL_CLASSROOMS = "/SATURN/rest/schedules";
var URL_CLASSROOMS_LENGTH = "/SATURN/rest/schedules/length";


var SELECT_OPTION_TEMPLATE1 = "<option value=\"";
var SELECT_OPTION_TEMPLATE2 = "\">";
var SELECT_OPTION_TEMPLATE3 = "</option>";

var USER_ID;
var USER_TYPE;
var CAREER_ID;

var lastEditDeleteBtn;

/*
 * Función la cual debe volver al inicio de la pagina;
 * si se presenta una sesión, deberia regresarlo al
 * menú principal del usuario especifico
 */
function fReload() { //Sin terminar
	switch (USER_TYPE) {
		case USR_TYPE_MANAGER:
			fClearCareerForm();
			fClearDeleteCareer();
			fClearAddAssistant();
			fClearDeleteUser();
			//ocultar y limpiar horarios(scheduleMenu)
			$("#Careers").hide();
			$("#Assistants").hide();
                        $("#Schedules").hide();
			$("#ManagerMenu").show();
			break;
		case USR_TYPE_ASSISTANT:
			fClearAddCoordinator();
			fClearDeleteUser();
			fClearGroupForm();
			fClearDeleteGroup();
			fClearAddTeacher();
			$("#Coordinator").hide();
			$("#Groups").hide();
			$("#Teachers").hide();
			$("#AssistantMenu").show();
			break;
		case USR_TYPE_COORDINATOR:
			fClearCourseForm();
			fClearDeleteCourse();
			fClearGroupForm();
			fClearDeleteGroup();
			$("#TeachersAfinity").hide();
			$("#TeachersAfinityCourses").hide();
			$("#Courses").hide();
			$("#Groups").hide();
			$("#CoordinatorMenu").show();
			break;
		case USR_TYPE_TEACHER:
			$("#Availability").hide();
			$("#Btn_SaveAvailability").hide();
			$("#Btn_CancelAvailability").hide();
			$("#Afinity").hide();
			$("#Btn_SaveAfinity").hide();
			$("#Btn_CancelAfinity").hide();
			$("#TeacherMenu").show();
			break;
	}
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


/*
 * Función la cual obtiene los parametros para iniciar sesión
 * y se comunica con el sistema para iniciar sesión
 */
function fLogIn() {
	var userName;
	var pass;
	var helloMsg;

	userName = $("#TextBox_UserName").val();
	pass = $("#TextBox_Password").val(); //se debe tranformar en el sha256 en vez del texto plano.....

	if(userName && pass){
		$.ajax({
			method: 'POST',
			url: URL_LOGIN,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify({"email" : userName, "password" : pass}),

			success: function(result){
				console.log("[Login] Result " + JSON.stringify(result));

				if(result.status === "OK"){
					$("#TextBox_UserName").val(""); //Es importante limpiar los campos de texto
					$("#TextBox_Password").val("");
					$("#LogIn").hide();
					$("#Btn_LogOut").show();

					USER_ID = result.userId;
					USER_TYPE = result.userType;
					CAREER_ID = result.careerId;
					switch (USER_TYPE) {
						case USR_TYPE_MANAGER:
						$("#ManagerMenu").show();
						helloMsg = "Bienvenido, Administrador";
						break;

						case USR_TYPE_ASSISTANT:
						$("#AssistantMenu").show();
						helloMsg = "Bienvenido, Asistente";
						break;

						case USR_TYPE_COORDINATOR:
						$("#CoordinatorMenu").show();
						helloMsg = "Bienvenido, Coordinador";
						break;

						case USR_TYPE_TEACHER:
                                                
						$("#TeacherMenu").show();
                                                $("#Availability").hide();
						helloMsg = "Bienvenido, Profesor";
						break;
					}
					fShowHelloMsg(helloMsg);
				}
			},

			error: function(request, status, error){
			alert("Usuario o contraseña incorrecto");
				console.log("[Login] Error: " + error);
			}
		});

	}else {
		alert("Se febe mostrar mensaje de que se requieren datos");
	}
}

function fLogOut() {
	location.reload();
}

$(document).ready(function(){
	$(document).on("click", "#Btn_Start", fReload);

	/*Handler para el inicio de sesion*/
	$(document).on("click", "#Btn_LogIn1", fShowLogIn);
	$(document).on("click", "#Btn_LogIn2", fShowLogIn);
	$(document).on("click", "#Btn_LogInSubmit", fLogIn);
	$(document).on("click", "#Btn_LogOut", fLogOut);
	//$(document).on("click", "#Btn_Schedules", );

	/*Handler para las carreras*/
	$(document).on("click", "#Btn_Careers", fDisplayCareers);
	$(document).on("click", "#Btn_AddCareer", fShowAddCareer);
	$(document).on("click", "#Btn_AddCareerSubmit", fAddCareer);
	$(document).on("click", "#Btn_AddCareerCancel", fCancelAddEditCareer);
	$(document).on("click", "#Btn_EditCareer", fShowEditCareer);
	$(document).on("click", "#Btn_UpdateCareerSubmit", fEditCareer);
	$(document).on("click", "#Btn_UpdateCareerCancel", fCancelAddEditCareer);
	$(document).on("click", "#Btn_DeleteCareer", fConfirmDeleteCareer);
	$(document).on("click", "#Btn_DeleteCareerSubmit", fDeleteCareer);
	$(document).on("click", "#Btn_DeleteCareerCancel", fCancelDeleteCareer);

	$(document).on("click", "#Btn_Assistants", fDisplayAssistants);
	$(document).on("click", "#Btn_AddAssistant", fShowAddAssistant);
	$(document).on("click", "#Btn_AddAssistantSubmit", fAddAssistant);
	$(document).on("click", "#Btn_AddAssistantCancel", fCancelAddAssistant);

	$(document).on("click", "#Btn_Coordinators", fDisplayCoordinator);
	$(document).on("click", "#Btn_AddCoordinator", fShowAddCoordinator);
	$(document).on("click", "#Btn_AddCoordinatorSubmit", fAddCoordinator);
	$(document).on("click", "#Btn_AddCoordinatorCancel", fCancelAddCoordinator);

	$(document).on("click", "#Btn_Teachers1", fDisplayTeachers);
	$(document).on("click", "#Btn_AddTeacher", fShowAddTeacher);
	$(document).on("click", "#Btn_AddTeacherSubmit", fAddTeacher);
	$(document).on("click", "#Btn_AddTeacherCancel", fCancelAddTeacher);

	$(document).on("click", "#Btn_UpdateUserSubmit", fEditUser);
	$(document).on("click", "#Btn_UpdateUserCancel", fCancelEditUser);
	$(document).on("click", "#Btn_DeleteUserSubmit", fDeleteUser);
	$(document).on("click", "#Btn_DeleteUserCancel", fCancelDeleteUser);
	$(document).on("click", "#Btn_EditUser", fShowEditUser);
	$(document).on("click", "#Btn_DeleteUser", fConfirmDeleteUser);

	$(document).on("click", "#Btn_Courses", fDisplayCourses);
	$(document).on("click", "#Btn_AddCourse", fShowAddCourse);
	$(document).on("click", "#Btn_AddCourseSubmit", fAddCourse);
	$(document).on("click", "#Btn_AddCourseCancel", fCancelAddEditCourse);
	$(document).on("click", "#Btn_EditCourse", fShowEditCourse);
	$(document).on("click", "#Btn_UpdateCourseSubmit", fEditCourse);
	$(document).on("click", "#Btn_UpdateCourseCancel", fCancelAddEditCourse);
	$(document).on("click", "#Btn_DeleteCourse", fConfirmDeleteCourse);
	$(document).on("click", "#Btn_DeleteCourseSubmit", fDeleteCourse);
	$(document).on("click", "#Btn_DeleteCourseCancel", fCancelDeleteCourse);


	$(document).on("click", "#Btn_Groups1", fDisplayGroups);
	$(document).on("click", "#Btn_Groups2", fDisplayGroups);
	$(document).on("click", "#Btn_AddGroup", fShowAddGroup);
	$(document).on("click", "#Btn_AddGroupSubmit", fAddGroup);
	$(document).on("click", "#Btn_AddGroupCancel", fCancelAddEditGroup);
	$(document).on("click", "#Btn_EditGroup", fShowEditGroup);
	$(document).on("click", "#Btn_UpdateGroupSubmit", fEditGroup);
	$(document).on("click", "#Btn_UpdateGroupCancel", fCancelAddEditGroup);
	$(document).on("click", "#Btn_DeleteGroup", fConfirmDeleteGroup);
	$(document).on("click", "#Btn_DeleteGroupSubmit", fDeleteGroup);
	$(document).on("click", "#Btn_DeleteGroupCancel", fCancelDeleteGroup);
	$(document).on("change", "#Select_AddGroup_Sessions", fDisplaySessions);


	$(document).on("click", "#Btn_Schedules", fDisplaySchedule);
        $(document).on("click", "#Btn_GenSchedule_Submit", fCallAlgorithm);
        $(document).on("click", "#Btn_Previous_Schedule", previousNumber);
        $(document).on("click", "#Btn_Previous_Schedule", fDisplaySchedule); 
        $(document).on("click", "#Btn_Next_Schedule", nextNumber);
        $(document).on("click", "#Btn_Next_Schedule", fDisplaySchedule);
        
	$(document).on("click", "#Btn_Availability", fShowAvailability); //{id: userId}

	$(document).on("click", "#Availability .monday", {btnClassName: "monday", btnMarkAll: "Btn_AllMonday"}, fPressBox);
	$(document).on("click", "#Availability .tuesday", {btnClassName: "tuesday", btnMarkAll: "Btn_AllTuesday"}, fPressBox);
	$(document).on("click", "#Availability .wednesday", {btnClassName: "wednesday", btnMarkAll: "Btn_AllWednesday"}, fPressBox);
	$(document).on("click", "#Availability .thursday", {btnClassName: "thursday", btnMarkAll: "Btn_AllThursday"}, fPressBox);
	$(document).on("click", "#Availability .friday", {btnClassName: "friday", btnMarkAll: "Btn_AllFriday"}, fPressBox);
	$(document).on("click", "#Availability .saturday", {btnClassName: "saturday", btnMarkAll: "Btn_AllSaturday"}, fPressBox);

	$(document).on("click", "#Btn_AllMonday", {btnClassName: "monday"}, fPressAllBoxes);
	$(document).on("click", "#Btn_AllTuesday", {btnClassName: "tuesday"}, fPressAllBoxes);
	$(document).on("click", "#Btn_AllWednesday", {btnClassName: "wednesday"}, fPressAllBoxes);
	$(document).on("click", "#Btn_AllThursday", {btnClassName: "thursday"}, fPressAllBoxes);
	$(document).on("click", "#Btn_AllFriday", {btnClassName: "friday"}, fPressAllBoxes);
	$(document).on("click", "#Btn_AllSaturday", {btnClassName: "saturday"}, fPressAllBoxes);

	$(document).on("click", "#Btn_SaveAvailabilitySubmit", fChangeAvailability);
	$(document).on("click", "#Btn_SaveAvailabilityCancel", fReloadAvailability);
	$(document).on("click", "#Btn_SaveAvailability", fConfirmSaveAvailability);
	$(document).on("click", "#Btn_CancelAvailability", fReloadAvailability);

	$(document).on("click", "#Btn_Afinity", fDisplayAfinity);
	$(document).on("click", "#Btn_SaveAfinity", fChangeAfinity);
	$(document).on("click", "#Btn_CancelAfinity", fReloadAfinity);
	$(document).on("click", ".star", fMarkStar);

	$(document).on("click", "#Btn_Teachers2", fShowTeachers);

	$(document).on("click", ".userAfinity", fShowTeacherAfinities);



	/* Agregar un handler de tipo click a elementos de una lista que aun no han sido agregados */
	$(document).on("click", "ul .clickable",function(){
		if (lastEditDeleteBtn) {
			lastEditDeleteBtn.hide();
		}
		lastEditDeleteBtn = $(this).find("#Btn_Edit_Delete");
		lastEditDeleteBtn.show();
	});

});



var AFINITY_LIST_TEMPLATE1 = "<li class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var AFINITY_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var AFINITY_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div star=\"0\" course=\"";
var AFINITY_LIST_TEMPLATE4 = "\" class=\"s_div2 stars\"><a href=\"#\" class=\"s_button9 star w-button\" value=\"1\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"2\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"3\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"4\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"5\"  style=\"background-image: none;\"></a></div></div></div></li>";

var AFINITY_NONCLICKABLE_LIST_TEMPLATE1 = "<li class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var AFINITY_NONCLICKABLE_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var AFINITY_NONCLICKABLE_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div star=\"0\" course=\"";
var AFINITY_NONCLICKABLE_LIST_TEMPLATE4 = "\" class=\"s_div2 nonclickablestars\"><a href=\"#\" class=\"s_button9 star w-button\" value=\"1\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"2\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"3\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"4\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"5\"  style=\"background-image: none;\"></a></div></div></div></li>";

var TEACHERS_LIST_TEMPLATE1 = "<li class=\"s_listitem2 userAfinity\" value=\"";
var TEACHERS_LIST_TEMPLATE2 = "\"><div class=\"w-row\"><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var TEACHERS_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var TEACHERS_LIST_TEMPLATE4 = "</div></div></div></li>";



var userAfinity;
var jObj = {};

function fDisplayAfinity() {

	$("#TeacherMenu").hide();
	$("#Afinity").show();
	$("#Afinity li").each(function (index) {
		if(index !== 0 && index !== 1){
			$(this).remove();
		}
	});

	$.ajax({
		method: 'GET',
		url: URL_COURSES + "/careerId/" + CAREER_ID,

		success: function(result){

			//result = result.courses;//Quitar cuando se pase a java
			for (i in result) {
				$("#Afinity ul").append(  AFINITY_LIST_TEMPLATE1 + result[i].code +
					AFINITY_LIST_TEMPLATE2 + result[i].name +
					AFINITY_LIST_TEMPLATE3 + result[i].courseId +
					AFINITY_LIST_TEMPLATE4);
			}
			$.ajax({
				method: 'GET',
				url: URL_TEACHERS_AFINITIES + "/" + USER_ID,

				success: function(result){
                                        //alert(result);
					//result = result.afinities;//Quitar cuando se pase a java
					for (i in result) {
						jObj[result[i].courseId] = result[i].level;
					}
					fReloadAfinity();
				},
				error: function(request, status, error){
					console.log("[Login] Error: " + error);
				}
			});
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fMarkStar() {
	n = Number($(this).attr("value"));
	$(this).parent().children(".star").slice(0,n).css("background-image", "");
	$(this).parent().children(".star").slice(n,5).css("background-image", "none");
	$(this).parent().attr("star", n);
	$("#Btn_SaveAfinity").show();
	$("#Btn_CancelAfinity").show();
}

function fChangeAfinity() {

	var afinities;
	var star;
	var course;

	afinities = [];
	$("#Afinity .stars").each(function() {
		star = $(this).attr("star");
		course = $(this).attr("course");
		afinities.push({ "professorId":USER_ID, "level" : star,
		"courseId" : course});
	});
        //alert(JSON.stringify(afinities))
	$.ajax({
		method: 'POST',
		url: URL_TEACHERS_AFINITIES,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(afinities),

		success: function(result){
			console.log("[Login] Result " + JSON.stringify(result));

			if(result.status === "OK"){
				fDisplayAfinity();
			}
		},

		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fReloadAfinity() {
	$("#Btn_SaveAfinity").hide();
	$("#Btn_CancelAfinity").hide();
	$(".stars").each(function () {

		courseId = $(this).attr("course");

		$(this).attr("star", 0);
		$(this).find("a").slice(0, 5).css("background-image", "none");
		if(jObj.hasOwnProperty(courseId)) {
			$(this).attr("star", jObj[courseId]);
			$(this).find("a").slice(0, jObj[courseId]).css("background-image", "");
		}
	});
}


/*Funciones las cuales tienen relacion con la muestra de las afinidades al coordinador.*/

function fShowTeachers() {
	$("#CoordinatorMenu").hide();
	$("#TeachersAfinity").show();
	$("#TeachersAfinity li").each(function( index ) {
		if(index !== 0){
			$(this).remove();
		}
	});
	$.ajax({
		method: 'GET',
		url: URL_TEACHERS + "/careerId/" + CAREER_ID,

		success: function(result){
			//alert(JSON.stringify(result));
			//result = result.teachers; //Quitar cuando se pase a java
			for (i in result) {
				$("#TeachersAfinity ul").append(TEACHERS_LIST_TEMPLATE1 + result[i].userId +
												TEACHERS_LIST_TEMPLATE2 + result[i].userName +
												TEACHERS_LIST_TEMPLATE3 + result[i].name + " " + result[i].lastName +
												TEACHERS_LIST_TEMPLATE4);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}


function fShowTeacherAfinities() {
	var value = $(this).val();
	$("#TeachersAfinity").hide();
	$("#TeachersAfinityCourses").show();

	$("#TeachersAfinityCourses li").each(function (index) {
		if(index !== 0){
			$(this).remove();
		}
	});

	$.ajax({
		method: 'GET',
		url: URL_COURSES + "/careerId/" + CAREER_ID,

		success: function(result){

			//result = result.courses;//Quitar cuando se pase a java
			for (i in result) {
				$("#TeachersAfinityCourses ul").append(	AFINITY_NONCLICKABLE_LIST_TEMPLATE1 + result[i].code +
														AFINITY_NONCLICKABLE_LIST_TEMPLATE2 + result[i].name +
														AFINITY_NONCLICKABLE_LIST_TEMPLATE3 + result[i].courseId +
														AFINITY_NONCLICKABLE_LIST_TEMPLATE4);
			}
			$.ajax({
				method: 'GET',
				url: URL_TEACHERS_AFINITIES + "/" + value,

				success: function(result){
					//result = result.afinities;//Quitar cuando se pase a java

					for (i in result) {
						jObj[result[i].courseId] = result[i].level;
                                                
					}
					$(".nonclickablestars").each(function () {

						courseId = $(this).attr("course");
                                                
						$(this).attr("star", 0);
						$(this).find("a").slice(0, 5).css("background-image", "none");
						if(jObj.hasOwnProperty(courseId)) {
							$(this).attr("star", jObj[courseId]);
							$(this).find("a").slice(0, jObj[courseId]).css("background-image", "");
						}
					});
				},
				error: function(request, status, error){
					console.log("[Login] Error: " + error);
				}
			});
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

