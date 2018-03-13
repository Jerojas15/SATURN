var SCHEDULE_TABLE_TEMPLATE1 = "<tr><tr>"
var classroomId = 1;
var number = 1;
var created = 0;
var classType = "";
var version = 1;
var typeClass = [];
var pos;
var type;
var schedule = [];

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
        var type = $("#Select_Schedule_Classroom").val();
        var obj = JSON.stringify({"times":number, "type":type});
        
        $.ajax({
		method: 'POST',
		url: URL_SCHEDULES+"/algorithm",
                contentType: "application/json; charset=utf-8",
		dataType: "json",
                data : obj,
		success: function(result){
			//alert(JSON.stringify(result));
			//result = result.classrooms; //Quitar cuando se pase a java
			if(result.status === "OK"){
                            alert("El algoritmo ha terminado su ejecución");
                            fDisplaySchedule();
                        }
			//$("#Select_Schedule_Classroom").val(0);
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
}

function previousNumber(){
    number--;
}

function nextNumber(){
    number++;
}

function write(i,column, result, dayTable, daynum){
    while(result[i].day<daynum){
        i++;
    }
    $("#"+dayTable+" table tr").each(function(index){
        $(this).find("th#"+column).each(function(){
         if(index > 0){
                var aux= $(this);
            //for (i in result){
                if(result[i].day === daynum){
                    var name = "";
                    if(index+6 >= result[i].startHour && index+6 < result[i].endHour){
                        name = result[i].courseName+result[i].university;
                        aux.append(name);
                    }
                    if(index+7 === result[i].endHour){
                        i++;
                        if(result[i-1].endHour>result[i].startHour){
                        column++;
                        write(i,column,result, dayTable,daynum);
                    }
                    }

                }
                
                
            }
        });
    });
}

function fScheduleGennerator(number, type){
    $.ajax({
        method: 'GET',
        url: URL_SCHEDULES + "/timetables/" + number + "/" + type,

        success: function(result){
           // schedule = result;
           console.log("HOLLA ");
           console.log(result);
               write(0,0, result, "Tab_Schedule_Monday",0);
               write(0,0, result, "Tab_Schedule_Tuesday",1);
               write(0,0, result, "Tab_Schedule_Wednesday",2);
               write(0,0, result, "Tab_Schedule_Thursday",3);
               write(0,0, result, "Tab_Schedule_Friday",4);
               write(0,0, result, "Tab_Schedule_Saturday",5);
        },
        error: function(request, status, error){
           console.log("[Login] Error: " + error);
        }
    });
}

function fDisplaySchedule() {
    // se encarga de mostrar la lista de tipos de aulas
    $.ajax({
        method: 'GET',
        url: URL_CLASSROOM_TYPES,

        success: function (result) {
            
            for (i in result) {
                pos = typeClass.indexOf(result[i].name);
                if(pos == -1){
                    $("#Select_Schedule_Classroom").append(SELECT_OPTION_TEMPLATE1 + result[i].classroomTypeId +
                        SELECT_OPTION_TEMPLATE2 + result[i].name +
                        SELECT_OPTION_TEMPLATE3);
                    typeClass.push(result[i].name);
                }
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
        $.ajax({
		method: 'GET',
		url: URL_SCHEDULES+"/lastSchedules/"+1,

		success: function(result){
			number = result.size;
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
	});
        Type = $("#Select_Schedule_Classroom").val(); // saber el tipo de aula
        console.log("Tipo " + Type);
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

	$("#ManagerMenu").hide();

	$("#Schedules").show();
        $("#Tab_Schedule_Monday table").empty();
        $("#Tab_Schedule_Tuesday table").empty();
        $("#Tab_Schedule_Wednesday table").empty();
        $("#Tab_Schedule_Thursday table").empty();
        $("#Tab_Schedule_Friday table").empty();
        $("#Tab_Schedule_Saturday table").empty();
        $("#Left_Table table").empty();
        
        classroomId = $("#Select_Schedule_Classroom").val();
	$.ajax({
		method: 'GET',
		url: URL_SCHEDULES_LENGTH + "/" + Type,

		success: function(result){
                        row = "<tr><th></th>";
                        var cont = 1;

                        for (j = 0; j < result.len; j++) {
                            row+=("<th>"+$("#Select_Schedule_Classroom option:selected").text()+" "+cont+"</th>");
                            cont+=1;
                        }
                        row += "</tr>";
                        $("#Tab_Schedule_Monday table").append(row);
                        $("#Tab_Schedule_Tuesday table").append(row);
                        $("#Tab_Schedule_Wednesday table").append(row);
                        $("#Tab_Schedule_Thursday table").append(row);
                        $("#Tab_Schedule_Friday table").append(row);
                        $("#Tab_Schedule_Saturday table").append(row);
                        row = "<tr>";
                        row += "<th>" + getHour(0) + "</th>";

                        for (i = 0; i < 15; i++) {

				row = "<tr>";
				row += "<th>" + getHour(i) + "</th>";

				for (j = 0; j < result.len; j++) {

					row += "<th id =\""+j+"\"></th>";
				}
				row += "</tr>";
				$("#Tab_Schedule_Monday table").append(row);
				$("#Tab_Schedule_Tuesday table").append(row);
				$("#Tab_Schedule_Wednesday table").append(row);
				$("#Tab_Schedule_Thursday table").append(row);
				$("#Tab_Schedule_Friday table").append(row);
				$("#Tab_Schedule_Saturday table").append(row);
			}
                        fScheduleGennerator(number, classroomId);
                        /*
                        console.log("HOLLLA"); 
                        console.log(schedule);
                        $("#Tab_Schedule_Monday table tr").each(function(index){
                            $(this).find("th").each(function(indexB){
                                if(indexB>0 && index > 0){
                                    var aux= $(this);
                                    for (i in schedule){
                                        if(schedule[i].Day === 0){
                                            var name = "";
                                            if(index+7 >= schedule[i].StartHour && index+7 >= schedule[i].EndHour){
                                                name = schedule[i].CourseName+schedule[i].University;
                                                aux.append(name);
                                                
                                            }
                                            
                                        }
                                        
                                    }

                                }
                            });
                        });
                        */
                       
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
                    
	});
                   
        $.ajax({
                method: 'GET',
		url: URL_SCHEDULES + "/leftSession/" + number,
                success: function(result){
                        console.log(result);
			var res = ""
                        for(i in result){
                            console.log(result[i]);
                            res+="<tr><th>"+result[i].left+"</th></tr>";
                        }
                        $("#Left_Table table").append(res);
		},
		error: function(request, status, error){
			console.log("[Login] Error: " + error);
		}
        });
}
