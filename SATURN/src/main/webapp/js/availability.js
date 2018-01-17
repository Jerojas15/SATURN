var START_HOUR = 7;
var END_HOUR = 21;

var DAY_TYPE_MONDAY = 0;
var DAY_TYPE_TUESDAY = 1;
var DAY_TYPE_WEDNESDAY = 2;
var DAY_TYPE_THURSDAY = 3;
var DAY_TYPE_FRIDAY = 4;
var DAY_TYPE_SATURDAY = 5;
var DAYS = ["monday", "tuesday", "wednesday", "thursday", "friday", "saturday"];

var userAvailability;

function fShowAvailability(event) {


	//console.log(USER);

        $("#TeacherMenu").hide();
        $("#Availability").show();
        $.ajax({
                method: 'GET',
                url: URL_TEACHERS_AVAILABILITIES + "/" + USER_ID,

                success: function(result){
                        userAvailability = result;
                        fReloadAvailability();
                },
                error: function(request, status, error){
                        alert("Ha ocurrido un error inesperado, porfavor recargue la página e intente de nuevo");
                }
        });

}

function fPressAllBoxes(event) {
	var btnClassName;
	var pressed;

	btnClassName = event.data.btnClassName;

	pressed = $(this).attr("pressed");

	if (pressed === "true") {
		$(this).attr("pressed", false);
		$(this).css("background-image", "none");
		$("." + btnClassName).each(function () {
			$(this).attr("pressed", false);
			$(this).css("background-image", "none");
		});

	} else {
		$(this).attr("pressed", true);
		$(this).css("background-image", "");
		$("." + btnClassName).each(function () {
			$(this).attr("pressed", true);
			$(this).css("background-image", "");
		});
	}
	$("#Btn_SaveAvailability").show();
	$("#Btn_CancelAvailability").show();
}

function fPressBox(event) {
	var btnClassName;
	var btnMarkAll;
	var pressed;
	var allPressed;

	btnClassName = event.data.btnClassName;
	btnMarkAll = event.data.btnMarkAll;

	pressed = $(this).attr("pressed");

	if (pressed === "true") {
		$(this).attr("pressed", false);
		$(this).css("background-image", "none");
		$("#" + btnMarkAll).attr("pressed", false);
		$("#" + btnMarkAll).css("background-image", "none");

	} else {
		$(this).attr("pressed", true);
		$(this).css("background-image", "");

		allPressed = true;
		$("." + btnClassName).each(function () {
			if($(this).attr("pressed") === "false") {
				allPressed = false;
				return false;
			}
		});

		if (allPressed) {
			$("#" + btnMarkAll).attr("pressed", true);
			$("#" + btnMarkAll).css("background-image", "");
		}
	}
	$("#Btn_SaveAvailability").show();
	$("#Btn_CancelAvailability").show();
}

function fGetAvailability(jObj, btnClassName, btnMarkAll) {
	var pressed;
	var startHour;
	var endHour;
	var cont;
	var day;

	switch (btnClassName) {
		case "monday":
			day = DAY_TYPE_MONDAY;
			break;
		case "tuesday":
			day = DAY_TYPE_TUESDAY;
			break;
		case "wednesday":
			day = DAY_TYPE_WEDNESDAY;
			break;
		case "thursday":
			day = DAY_TYPE_THURSDAY;
			break;
		case "friday":
			day = DAY_TYPE_FRIDAY;
			break;
		case "saturday":
			day = DAY_TYPE_SATURDAY;
			break;
	}
	if ($("#" + btnMarkAll).attr("pressed") === "true") {
		jObj.push({	"day" : day,
					"startHour" : START_HOUR,
					"endHour" : END_HOUR});

	} else {
		pressed = false;
		cont = 7;
		startHour;
		endHour;
		$("#Availability ." + btnClassName).each(function () {
			if ($(this).attr("pressed") === "true") {
				if (!pressed) {
					pressed = true;
					startHour = cont;
				}

			} else {
				if (pressed) {
					pressed = false;
					endHour = cont - 1;
					jObj.push({	"day" : day,
								"startHour" : startHour,
								"endHour" : endHour});
				}
			}
			cont++;
		});
		if (pressed) {
			endHour = cont - 1;
			jObj.push({	"day" : day,
						"startHour" : startHour,
						"endHour" : endHour});
		}
	}
	return jObj;
}
function fChangeAvailability() {
	var jObj = [];

	fGetAvailability(jObj, "monday", "Btn_AllMonday");
	fGetAvailability(jObj, "tuesday", "Btn_AllTuesday");
	fGetAvailability(jObj, "wednesday", "Btn_AllWednesday");
	fGetAvailability(jObj, "thursday", "Btn_AllThursday");
	fGetAvailability(jObj, "friday", "Btn_AllFriday");
	fGetAvailability(jObj, "saturday", "Btn_AllSaturday");

	console.log(URL_TEACHERS_AVAILABILITIES + "/" + USER_ID);
	console.log(jObj);
	$.ajax({
		method: 'PUT',
		url: URL_TEACHERS_AVAILABILITIES + "/" + USER_ID,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(jObj),

		success: function(result){
			console.log("[Login] Result " + JSON.stringify(result));

			if(result.status === "OK"){
				userAvailability = jObj;
				fReloadAvailability();
			}
		},

		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function fReloadAvailability() {

	$("#ConfirmAction").hide();
	$("#Btn_SaveAvailabilitySubmit").hide();
	$("#Btn_SaveAvailabilityCancel").hide();
	$("#Availability").show();

	var btnMarkAll;
	var startHour;
	var endHour;


	console.log(userAvailability);


	for (i in DAYS) {
		$("#Availability ." + DAYS[i]).each(function() {
			$(this).attr("pressed", false);
			$(this).css("background-image", "none");
		});
	}

	$("#Btn_AllMonday").attr("pressed", false);
	$("#Btn_AllMonday").css("background-image", "none");
	$("#Btn_AllTuesday").attr("pressed", false);
	$("#Btn_AllTuesday").css("background-image", "none");
	$("#Btn_AllWednesday").attr("pressed", false);
	$("#Btn_AllWednesday").css("background-image", "none");
	$("#Btn_AllThursday").attr("pressed", false);
	$("#Btn_AllThursday").css("background-image", "none");
	$("#Btn_AllFriday").attr("pressed", false);
	$("#Btn_AllFriday").css("background-image", "none");
	$("#Btn_AllSaturday").attr("pressed", false);
	$("#Btn_AllSaturday").css("background-image", "none");

	for(i in userAvailability){

		startHour = userAvailability[i].startHour;
		endHour = userAvailability[i].endHour;

		switch (userAvailability[i].day) {
			case DAY_TYPE_MONDAY:
				day = "monday";
				btnMarkAll = "Btn_AllMonday";
				break;
			case DAY_TYPE_TUESDAY:
				day = "tuesday";
				btnMarkAll = "Btn_AllTuesday";
				break;
			case DAY_TYPE_WEDNESDAY:
				day = "wednesday";
				btnMarkAll = "Btn_AllWednesday";
				break;
			case DAY_TYPE_THURSDAY:
				day = "thursday";
				btnMarkAll = "Btn_AllThursday";
				break;
			case DAY_TYPE_FRIDAY:
				day = "friday";
				btnMarkAll = "Btn_AllFriday";
				break;
			case DAY_TYPE_SATURDAY:
				day = "saturday";
				btnMarkAll = "Btn_AllSaturday";
				break;
		}
		if (startHour === START_HOUR && endHour === END_HOUR) {
			$("#" + btnMarkAll).attr("pressed", true);
			$("#" + btnMarkAll).css("background-image", "");
		}

		$("#Availability ." + day).slice(startHour - START_HOUR, endHour - START_HOUR + 1).attr("pressed", true);
		$("#Availability ." + day).slice(startHour - START_HOUR, endHour - START_HOUR + 1).css("background-image", "");

	}
	$("#Btn_SaveAvailability").hide();
	$("#Btn_CancelAvailability").hide();
}

function fConfirmSaveAvailability() {

	$("#Availability").hide();
	$("#ConfirmAction").show();
	$("#Btn_SaveAvailabilitySubmit").show();
	$("#Btn_SaveAvailabilityCancel").show();
}
