var SCHEDULE_TABLE_TEMPLATE1 = "<tr><tr>"
var classroomId = 0;

function getHour(hour24) {
	var hour12;

	hour24 += START_HOUR;

	if(hour24 > 12)
		hour12 = (hour24 - 12) + ":00pm"
	else
		hour12 = hour24 + ":00am"
	return hour12;
}

function fDisplaySchedule() {
	var row;

	$("#ManagerMenu").hide();
	$("#Schedules").show();

	$.ajax({
		method: 'GET',
		url: URL_CLASSROOMS,

		success: function(result){
			//alert(JSON.stringify(result));
			result = result.classrooms; //Quitar cuando se pase a java
			for (i in result) {
				$("#Select_Schedule_Classroom").append(	SELECT_OPTION_TEMPLATE1 + result[i].classId +
														SELECT_OPTION_TEMPLATE2 + result[i].className +
														SELECT_OPTION_TEMPLATE3);
			}
			//$("#Select_Schedule_Classroom").val(0);
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});

	$.ajax({
		method: 'GET',
		url: URL_CLASSROOMS_LENGTH + "/" + classroomId,

		success: function(result){
			alert(result.len);
			for (i = 0; i < 15; i++) {
				row = "<tr>";
				row += "<th>" + getHour(i) + "</th>";

				for (j = 0; j < result.len; j++) {
					console.log(j);
					row += "<th></th>";
				}
				row += "</tr>";
				$("#Tab_Schedule_Monday table").append(row);
				$("#Tab_Schedule_Tuesday table").append(row);
				$("#Tab_Schedule_Wednesday table").append(row);
				$("#Tab_Schedule_Thursday table").append(row);
				$("#Tab_Schedule_Friday table").append(row);
				$("#Tab_Schedule_Saturday table").append(row);
			}
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}
