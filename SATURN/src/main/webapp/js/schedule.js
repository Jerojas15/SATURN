var SCHEDULE_TABLE_TEMPLATE1 = "<tr><tr>"
var classroomId = 1;
var number = 1;
var created = 0;
function getHour(hour24) {
	var hour12;

	hour24 += START_HOUR;

	if(hour24 > 12)
		hour12 = (hour24 - 12) + ":00pm"
                
	else
                if(hour24 === 12){
                    hour12 = "12:00pm"
                }else{
                    hour12 = hour24 + ":00am"
                }
		
	return hour12;
}

function fCallAlgorithm() {
        var number = $("#TextBox_GenSchedule_Number").val();
        created +=number;
        $.ajax({
		method: 'POST',
		url: URL_CLASSROOMS+"/algorithm/"+number,

		success: function(result){
			//alert(JSON.stringify(result));
			//result = result.classrooms; //Quitar cuando se pase a java
			if(result.status === "OK"){
                            alert("algoritmo comenzado");
                        }
			//$("#Select_Schedule_Classroom").val(0);
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
        fDisplaySchedule();
}

function previousNumber(){
    number--;
}

function nextNumber(){
    number++;
}

function fDisplaySchedule() {
	if(number<=1){
            $("#Btn_Previous_Schedule").hide();
        }else{
            $("#Btn_Previous_Schedule").show();
        }
        if(number>=created){
            $("#Btn_Next_Schedule").hide();
        }else{
            $("#Btn_Next_Schedule").show();
            
        }
        
        var ClassType = "";
	$("#ManagerMenu").hide();
        
	$("#Schedules").show();
        $("#Tab_Schedule_Monday table").empty();
        $("#Tab_Schedule_Tuesday table").empty();
        $("#Tab_Schedule_Wednesday table").empty();
        $("#Tab_Schedule_Thursday table").empty();
        $("#Tab_Schedule_Friday table").empty();
        $("#Tab_Schedule_Saturday table").empty();
	$.ajax({
		method: 'GET',
		url: URL_CLASSROOMS,

		success: function(result){
			//alert(JSON.stringify(result));
			//result = result.classrooms; //Quitar cuando se pase a java
			for (i in result) {
                                if(result[i].type===1){
                                    ClassType = "Aula";
                                }
				$("#Select_Schedule_Classroom").append(	SELECT_OPTION_TEMPLATE1 + result[i].id +
														SELECT_OPTION_TEMPLATE2 + ClassType +
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
                        row = "<tr>";
                        row += "<th>" + getHour(0) + "</th>";
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
                        $("#Tab_Schedule_Monday table tr").each(function(index){
                            $(this).find("th").each(function(indexB){
                                if(indexB>0){
                                    var aux= $(this);
                                    $.ajax({
                                            method: 'POST',
                                            contentType: "application/json; charset=utf-8",
                                            dataType: "json",
                                            url: URL_CLASSROOMS + "/timetables/" + number,
                                            data: JSON.stringify({"classroom":indexB,"time":index+7, "day":0}),
                                            success: function(result){
                                                aux.append(result.name);
                                            },
                                            error: function(request, status, error){
                                                    console.log("[Login] Error: " + error);
                                            }
                                        });
                                    
                                }
                            });
                        });
                        $("#Tab_Schedule_Tuesday table tr").each(function(index){
                            $(this).find("th").each(function(indexB){
                                if(indexB>0){
                                    var aux= $(this);
                                    $.ajax({
                                            method: 'POST',
                                            contentType: "application/json; charset=utf-8",
                                            dataType: "json",
                                            url: URL_CLASSROOMS + "/timetables/" + number,
                                            data: JSON.stringify({"classroom":indexB,"time":index+7, "day":1}),
                                            success: function(result){
                                                aux.append(result.name);
                                            },
                                            error: function(request, status, error){
                                                    console.log("[Login] Error: " + error);
                                            }
                                        });
                                    
                                }
                            });
                        });
                        $("#Tab_Schedule_Wednesday table tr").each(function(index){
                            $(this).find("th").each(function(indexB){
                                if(indexB>0){
                                    var aux= $(this);
                                    $.ajax({
                                            method: 'POST',
                                            contentType: "application/json; charset=utf-8",
                                            dataType: "json",
                                            url: URL_CLASSROOMS + "/timetables/" + number,
                                            data: JSON.stringify({"classroom":indexB,"time":index+7, "day":2}),
                                            success: function(result){
                                                aux.append(result.name);
                                            },
                                            error: function(request, status, error){
                                                    console.log("[Login] Error: " + error);
                                            }
                                        });
                                    
                                }
                            });
                        });
                        $("#Tab_Schedule_Thursday table tr").each(function(index){
                            $(this).find("th").each(function(indexB){
                                if(indexB>0){
                                    var aux= $(this);
                                    $.ajax({
                                            method: 'POST',
                                            contentType: "application/json; charset=utf-8",
                                            dataType: "json",
                                            url: URL_CLASSROOMS + "/timetables/" + number,
                                            data: JSON.stringify({"classroom":indexB,"time":index+7, "day":3}),
                                            success: function(result){
                                                aux.append(result.name);
                                            },
                                            error: function(request, status, error){
                                                    console.log("[Login] Error: " + error);
                                            }
                                        });
                                    
                                }
                            });
                        });
                        $("#Tab_Schedule_Friday table tr").each(function(index){
                            $(this).find("th").each(function(indexB){
                                if(indexB>0){
                                    var aux= $(this);
                                    $.ajax({
                                            method: 'POST',
                                            contentType: "application/json; charset=utf-8",
                                            dataType: "json",
                                            url: URL_CLASSROOMS + "/timetables/" + number,
                                            data: JSON.stringify({"classroom":indexB,"time":index+7, "day":4}),
                                            success: function(result){
                                                aux.append(result.name);
                                            },
                                            error: function(request, status, error){
                                                    console.log("[Login] Error: " + error);
                                            }
                                        });
                                    
                                }
                            });
                        });
                        $("#Tab_Schedule_Saturday table tr").each(function(index){
                            $(this).find("th").each(function(indexB){
                                if(indexB>0){
                                    var aux= $(this);
                                    $.ajax({
                                            method: 'POST',
                                            contentType: "application/json; charset=utf-8",
                                            dataType: "json",
                                            url: URL_CLASSROOMS + "/timetables/" + number,
                                            data: JSON.stringify({"classroom":indexB,"time":index+7, "day":5}),
                                            success: function(result){
                                                aux.append(result.name);
                                            },
                                            error: function(request, status, error){
                                                    console.log("[Login] Error: " + error);
                                            }
                                        });
                                    
                                }
                            });
                        });
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}
                                
		