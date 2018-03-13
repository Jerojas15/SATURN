
var GROUP_LIST_TEMPLATE1 = "<li class=\"s_listitem2 clickable\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var GROUP_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var GROUP_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var GROUP_LIST_TEMPLATE4 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var GROUP_LIST_TEMPLATE5 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_EditGroup\" value=\"";
var GROUP_LIST_TEMPLATE6 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a  id=\"Btn_DeleteGroup\" value=\"";
var GROUP_LIST_TEMPLATE7 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";

var ADD_GROUP_SESSION_TEMPLATE1 = "<div class=\"element\"><label class=\"s_boldcentertext\">Horas:</label><input type=\"text\" class=\"w-input\" maxlength=\"2\" placeholder=\"";
var ADD_GROUP_SESSION_TEMPLATE2 = "\" required=\"\"><label class=\"s_boldcentertext\">Tipo de Aula:</label><select required=\"\" class=\"w-select\"><option value=\"\">------</option></select></div>";

var groupId;
var sessions = 0;
var classroomTypes = null;

function checkSessions(arr) {
    for (i in arr) {
        if (!arr[i].hours || !arr[i].classroomType)
            return false;
    }
    return true;
}

function fDisplayGroups() {
    $("#AssistantMenu").hide();
    $("#CoordinatorMenu").hide();
    $("#Groups").show();
    $("#Groups li").each(function (index) {
        if (index !== 0 && index !== 1) {
            $(this).remove();
        }
    });
    $.ajax({
        method: 'GET',
        url: URL_GROUPS + "/careerId/" + CAREER_ID,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.groups; //Quitar cuando se pase a java
            for (i in result) {
                $("#Groups ul").append(GROUP_LIST_TEMPLATE1 + result[i].number +
                        GROUP_LIST_TEMPLATE2 + result[i].courseName +
                        GROUP_LIST_TEMPLATE3 + result[i].teacherName +
                        GROUP_LIST_TEMPLATE4 + result[i].capacity +
                        GROUP_LIST_TEMPLATE5 + result[i].groupId +
                        GROUP_LIST_TEMPLATE6 + result[i].groupId +
                        GROUP_LIST_TEMPLATE7);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fShowAddGroup() {
    $("#Groups").hide();
    $("#AddGroup").show();
    $("#Btn_AddGroupSubmit").show()
    $("#Btn_AddGroupCancel").show()

    $.ajax({
        method: 'GET',
        url: URL_COURSES + "/careerId/" + CAREER_ID,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.courses; //Quitar cuando se pase a java
            for (i in result) {
                $("#Select_AddGroup_Course").append(SELECT_OPTION_TEMPLATE1 + result[i].courseId +
                        SELECT_OPTION_TEMPLATE2 + result[i].name +
                        SELECT_OPTION_TEMPLATE3);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
    $.ajax({
        method: 'GET',
        url: URL_TEACHERS + "/careerId/" + CAREER_ID,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.teachers; //Quitar cuando se pase a java
            for (i in result) {
                $("#Select_AddGroup_Teacher").append(SELECT_OPTION_TEMPLATE1 + result[i].userId +
                        SELECT_OPTION_TEMPLATE2 + result[i].name + " " + result[i].lastName +
                        SELECT_OPTION_TEMPLATE3);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
    $.ajax({
        method: 'GET',
        url: URL_CLASSROOM_TYPES,

        success: function (result) {
            classroomTypes = result;
            fDisplaySessions();
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fAddGroup() {

    var code;
    var courseId;
    var userId;
    var capacity;
    var arr;

    code = $("#TextBox_AddGroup_Number").val();
    courseId = $("#Select_AddGroup_Course option:selected").val();
    userId = $("#Select_AddGroup_Teacher option:selected").val();
    capacity = $("#TextBox_AddGroup_Capacity").val();
    arr = [];
    $("#AddGroup_Sessions .element").each(function () {
        hours = $(this).children("input").val();
        classroomType = $(this).children("select").val();
        arr.push({"hours": hours, "classroomType": classroomType});
    });
    alert(JSON.stringify(arr));


    if (code && courseId && userId && capacity && checkSessions(arr)) {
        var obj = JSON.stringify({"number": code, "courseId": courseId, "teacher": userId, "capacity": capacity, "sessions": arr});

        $.ajax({
            method: 'POST',
            url: URL_GROUPS,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: obj,

            success: function (result) {

                console.log("[Login] Result " + JSON.stringify(result));

                if (result.status === "OK") {
                    fCancelAddEditGroup();
                } else if (result.status === "ALREADY_EXISTS") {

                }
            },

            error: function (request, status, error) {
                console.log("[Login] Error: " + error);
            }
        });
    } else {
        alert("Se deben insertar todos los datos");
    }
}

function fCancelAddEditGroup() {
    fClearGroupForm();
    fDisplayGroups();
}

function fClearGroupForm() {
    $("#TextBox_AddGroup_Number").val("");
    $("#TextBox_AddGroup_Capacity").val("");
    $("#TextBox_AddGroup_Number").attr("placeholder", "");
    $("#TextBox_AddGroup_Capacity").attr("placeholder", "");
    $("#Select_AddGroup_Course option").each(function (index) {
        if (index !== 0)
            $(this).remove();
    });
    $("#Select_AddGroup_Teacher option").each(function (index) {
        if (index !== 0)
            $(this).remove();
    });
    $("#Select_AddGroup_Sessions").val(1);
    $("#AddGroup_Sessions .element").each(function (index) {
        $(this).remove();
    });
    sessions = 0;

    $("#Btn_AddGroupSubmit").hide();
    $("#Btn_AddGroupCancel").hide();
    $("#Btn_UpdateGroupSubmit").hide();
    $("#Btn_UpdateGroupCancel").hide();
    $("#AddGroup").hide();
}

function fShowEditGroup() {

    var courseId;
    var userId;
    var n;

    $("#Groups").hide();
    $("#AddGroup").show();
    $("#Btn_UpdateGroupSubmit").show();
    $("#Btn_UpdateGroupCancel").show();

    groupId = $(this).attr("value");

    $.ajax({
        method: 'GET',
        url: URL_COURSES + "/careerId/" + CAREER_ID,

        success: function (result) {

            for (i in result) {
                $("#Select_AddGroup_Course").append(SELECT_OPTION_TEMPLATE1 + result[i].courseId +
                        SELECT_OPTION_TEMPLATE2 + result[i].name +
                        SELECT_OPTION_TEMPLATE3);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });

    $.ajax({
        method: 'GET',
        url: URL_TEACHERS + "/careerId/" + CAREER_ID,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.teachers; //Quitar cuando se pase a java
            for (i in result) {
                $("#Select_AddGroup_Teacher").append(SELECT_OPTION_TEMPLATE1 + result[i].userId +
                        SELECT_OPTION_TEMPLATE2 + result[i].name + " " + result[i].lastName +
                        SELECT_OPTION_TEMPLATE3);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });

    $.ajax({
        method: 'GET',
        url: URL_CLASSROOM_TYPES,

        success: function (result) {

            classroomTypes = result;

            $.ajax({
                method: 'GET',
                url: URL_GROUPS + "/" + groupId,

                success: function (result) {

                    length = result.sessions.length;

                    $("#Select_AddGroup_Sessions").val(length);
                    fDisplaySessions();

                    $("#TextBox_AddGroup_Number").attr("placeholder", result.number);
                    $("#Select_AddGroup_Course").val(result.courseId);
                    $("#Select_AddGroup_Teacher").val(result.teacher);
                    $("#TextBox_AddGroup_Capacity").attr("placeholder", result.capacity);

                    for (i in result.sessions) {
                        $("#AddGroup_Sessions .element").eq(i).val(result.sessions[i].sessionId);
                        $("#AddGroup_Sessions .element").eq(i).children("input").attr("placeholder", result.sessions[i].hours);
                        $("#AddGroup_Sessions .element").eq(i).children("select").val(result.sessions[i].classroomType);
                    }
                },
                error: function (request, status, error) {
                    alert("Ha ocurrido un error inesperado, porfavor recargue la página e intente de nuevo");
                }
            });
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fEditGroup() {
    var code;
    var courseId;
    var userId;
    var capacity;
    var jObj;
    var arr;

    code = $("#TextBox_AddGroup_Number").val();
    courseId = $("#Select_AddGroup_Course").val();
    userId = $("#Select_AddGroup_Teacher").val();
    capacity = $("#TextBox_AddGroup_Capacity").val();
    arr = [];
    $("#AddGroup_Sessions .element").each(function () {
        sessionId = $(this).val();
        hours = $(this).children("input").val();
        classroomType = $(this).children("select").val();

        if (!sessionId) {
            sessionId = 0;
        }
        if (!hours) {
            hours = $(this).children("input").attr("placeholder");
        }

        arr.push({"sessionId": sessionId, "hours": hours, "classroomType": classroomType});

    });

    jObj = {};
    if (checkSessions(arr)) {
        if (code || courseId || userId || capacity) {

            if (code)
                jObj.number = code;
            if (courseId)
                jObj.courseId = courseId;
            if (userId)
                jObj.teacher = userId;
            if (capacity)
                jObj.capacity = capacity;
            if (arr.length > 0) {
                jObj.sessions = arr;
            }

            $.ajax({
                method: 'PUT',
                url: URL_GROUPS + "/" + groupId,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify(jObj),

                success: function (result) {
                    console.log("[Login] Result " + JSON.stringify(result));

                    if (result.status === "OK") {
                        groupId = null;
                        fClearGroupForm();
                        fDisplayGroups();
                    }
                },

                error: function (request, status, error) {
                    console.log("[Login] Error: " + error);
                    groupId = null;
                }
            });
        } else {
            alert("Se deben insertar todos los datos");
        }
    } else {
        alert("Los datos de sesiones son incorrectos");
    }

}

function fConfirmDeleteGroup() {
    userId = $(this).attr("value");

    $("#Groups").hide();
    $("#ConfirmAction").show();
    $("#Btn_DeleteGroupSubmit").show();
    $("#Btn_DeleteGroupCancel").show();
}

function fDeleteGroup() {

    $.ajax({
        method: 'DELETE',
        url: URL_GROUPS + "/" + userId,
        success: function (result) {
            console.log("[Login] Result " + JSON.stringify(result));

            if (result.status === "OK") {
                fCancelDeleteGroup();
            }
        },

        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
            groupId = null;
        }
    });
}

function fCancelDeleteGroup() {
    fClearDeleteGroup();
    fDisplayGroups();
}

function fClearDeleteGroup() {
    groupId = null;

    $("#Btn_DeleteGroupSubmit").hide();
    $("#Btn_DeleteGroupCancel").hide();
    $("#ConfirmAction").hide();
}

function fDisplaySessions() {
    var n;

    n = Number($("#Select_AddGroup_Sessions").val());
    if (n > sessions) {
        x = n - sessions;
        while (x--) {
            $("#AddGroup_Sessions").append(ADD_GROUP_SESSION_TEMPLATE1 + "Número" +
                    ADD_GROUP_SESSION_TEMPLATE2);
        }
        for (i in classroomTypes) {
            $("#AddGroup_Sessions select").slice(sessions, n).append(SELECT_OPTION_TEMPLATE1 + classroomTypes[i].classroomTypeId +
                    SELECT_OPTION_TEMPLATE2 + classroomTypes[i].name +
                    SELECT_OPTION_TEMPLATE3);
        }
        sessions = n;
    }
    if (n < sessions) {
        $("#AddGroup_Sessions .element").slice(n, sessions).remove();
        sessions = n;
    }
}
