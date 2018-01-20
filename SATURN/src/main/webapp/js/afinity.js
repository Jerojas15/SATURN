
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
		url: URL_COURSES + "/?" + "careerId=" + CAREER_ID,

		success: function(result){

			result = result.courses;//Quitar cuando se pase a java
			for (i in result) {
				$("#Afinity ul").append(  AFINITY_LIST_TEMPLATE1 + result[i].code +
					AFINITY_LIST_TEMPLATE2 + result[i].courseName +
					AFINITY_LIST_TEMPLATE3 + result[i].id +
					AFINITY_LIST_TEMPLATE4);
			}
			$.ajax({
				method: 'GET',
				url: URL_TEACHERS_AFINITIES + "/" + USER_ID,

				success: function(result){

					result = result.afinities;//Quitar cuando se pase a java
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
		afinities.push({ "star" : star,
		"course" : course});
	});
	$.ajax({
		method: 'POST',
		url: URL_TEACHERS_AFINITIES + "/" + USER_ID,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify({"afinities" : afinities}),

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
		url: URL_TEACHERS + "/?" + "careerId=" + CAREER_ID,

		success: function(result){
			//alert(JSON.stringify(result));
			result = result.teachers; //Quitar cuando se pase a java
			for (i in result) {
				$("#TeachersAfinity ul").append(TEACHERS_LIST_TEMPLATE1 + result[i].id +
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
	alert($(this).val());
	$("#TeachersAfinity").hide();
	$("#TeachersAfinityCourses").show();

	$("#TeachersAfinityCourses li").each(function (index) {
		if(index !== 0){
			$(this).remove();
		}
	});

	$.ajax({
		method: 'GET',
		url: URL_COURSES + "/?" + "careerId=" + CAREER_ID,

		success: function(result){

			result = result.courses;//Quitar cuando se pase a java
			for (i in result) {
				$("#TeachersAfinityCourses ul").append(	AFINITY_NONCLICKABLE_LIST_TEMPLATE1 + result[i].code +
														AFINITY_NONCLICKABLE_LIST_TEMPLATE2 + result[i].courseName +
														AFINITY_NONCLICKABLE_LIST_TEMPLATE3 + result[i].id +
														AFINITY_NONCLICKABLE_LIST_TEMPLATE4);
			}
			$.ajax({
				method: 'GET',
				url: URL_TEACHERS_AFINITIES + "/" + USER_ID,

				success: function(result){

					result = result.afinities;//Quitar cuando se pase a java
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
