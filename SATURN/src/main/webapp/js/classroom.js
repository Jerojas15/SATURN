var CLASSROOM_TYPES_LIST_TEMPLATE1 = "<li class=\"s_listitem2 clickable\"><div class=\"w-row\"><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var CLASSROOM_TYPES_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var CLASSROOM_TYPES_LIST_TEMPLATE3 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_EditClassroomType\" value=\"";
var CLASSROOM_TYPES_LIST_TEMPLATE4 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a id=\"Btn_DeleteClassroomType\" value=\"";
var CLASSROOM_TYPES_LIST_TEMPLATE5 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";

var CLASSROOMS_LIST_TEMPLATE1 = "<li class=\"s_listitem2 clickable\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var CLASSROOMS_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var CLASSROOMS_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div class=\"s_flex1\"><div class=\"s_text1\">";
var CLASSROOMS_LIST_TEMPLATE4 = "</div><div id=\"Btn_Edit_Delete\" class=\"s_flex2\" style=\"display: none;\"><a id=\"Btn_EditClassroom\" value=\"";
var CLASSROOMS_LIST_TEMPLATE5 = "\" href=\"#\" class=\"s_button6 w-button\"></a><a id=\"Btn_DeleteClassroom\" value=\"";
var CLASSROOMS_LIST_TEMPLATE6 = "\" href=\"#\" class=\"s_button7 w-button\"></a></div></div></div></div></li>";

var classroomTypeId;
var classroomId;

function fDisplayClassrooms() {
    $("#ManagerMenu").hide();
    $("#Classrooms").show();
    $("#Classrooms li").each(function (index) {
        if (index !== 0 && index !== 1) {
            $(this).remove();
        }
    });
    $.ajax({
        method: 'GET',
        url: URL_CLASSROOMS,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.classrooms; //Quitar cuando se pase a java
            for (i in result) {
                $("#Classrooms ul").append(CLASSROOMS_LIST_TEMPLATE1 + result[i].name +
                        CLASSROOMS_LIST_TEMPLATE2 + result[i].classroomTypeName +
                        CLASSROOMS_LIST_TEMPLATE3 + result[i].capacity +
                        CLASSROOMS_LIST_TEMPLATE4 + result[i].classroomId +
                        CLASSROOMS_LIST_TEMPLATE5 + result[i].classroomId +
                        CLASSROOMS_LIST_TEMPLATE6);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fShowAddClassroom() {
    $("#Classrooms").hide();
    $("#AddClassroom").show();
    $("#Btn_AddClassroomSubmit").show()
    $("#Btn_AddClassroomCancel").show()

    $.ajax({
        method: 'GET',
        url: URL_CLASSROOM_TYPES,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.classroomTypes; //Quitar cuando se pase a java
            for (i in result) {
                $("#Select_AddClassroom_ClassroomType").append(SELECT_OPTION_TEMPLATE1 + result[i].classroomTypeId +
                        SELECT_OPTION_TEMPLATE2 + result[i].name +
                        SELECT_OPTION_TEMPLATE3);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fAddClassroom() {
    var name;
    var capacity;
    var classroomType;

    name = $("#TextBox_AddClassroom_ClassroomName").val();
    capacity = $("#TextBox_AddClassroom_ClassroomCapacity").val();
    classroomType = $("#Select_AddClassroom_ClassroomType option:selected").val();

    if (name && capacity && classroomType) {
        $.ajax({
            method: 'POST',
            url: URL_CLASSROOMS,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify({"name": name, "capacity": capacity, "classroomType": classroomType}),

            success: function (result) {

                console.log("[Login] Result " + JSON.stringify(result));

                if (result.status === "OK") {
                    fCancelAddEditClassroom();
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

function fCancelAddEditClassroom() {
    fClearClassroomForm();
    fDisplayClassrooms();
}

function fClearClassroomForm() {
    $("#TextBox_AddClassroom_ClassroomName").val("");
    $("#TextBox_AddClassroom_ClassroomCapacity").val("");
    $("#TextBox_AddClassroom_ClassroomName").attr("placeholder", "");
    $("#TextBox_AddClassroom_ClassroomCapacity").attr("placeholder", "");
    $("#Select_AddClassroom_ClassroomType option").each(function (index) {
        if (index !== 0)
            $(this).remove();
    });

    $("#Btn_AddClassroomSubmit").hide();
    $("#Btn_AddClassroomCancel").hide();
    $("#Btn_UpdateClassroomSubmit").hide();
    $("#Btn_UpdateClassroomCancel").hide();
    $("#AddClassroom").hide();
}

function fShowEditClassroom() {
    var classroomType;

    $("#Classrooms").hide();
    $("#AddClassroom").show();
    $("#Btn_UpdateClassroomSubmit").show();
    $("#Btn_UpdateClassroomCancel").show();

    classroomId = $(this).attr("value");

    $.ajax({
        method: 'GET',
        url: URL_CLASSROOMS + "/" + classroomId,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.courses; //Quitar cuando se pase a java
            $("#TextBox_AddClassroom_ClassroomName").attr("placeholder", result.name);
            $("#TextBox_AddClassroom_ClassroomCapacity").attr("placeholder", result.capacity);
            classroomType = result.classroomType;
            $.ajax({
                method: 'GET',
                url: URL_CLASSROOM_TYPES,

                success: function (result) {
                    //alert(JSON.stringify(result));
                    //result = result.classroomTypes; //Quitar cuando se pase a java
                    for (i in result) {
                        $("#Select_AddClassroom_ClassroomType").append(SELECT_OPTION_TEMPLATE1 + result[i].classroomTypeId +
                                SELECT_OPTION_TEMPLATE2 + result[i].name +
                                SELECT_OPTION_TEMPLATE3);
                    }
                    $("#Select_AddClassroom_ClassroomType").val(classroomType);
                },
                error: function (request, status, error) {
                    console.log("[Login] Error: " + error);
                }
            });
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fEditClassroom() {
    var name;
    var capacity;
    var classroomType;

    name = $("#TextBox_AddClassroom_ClassroomName").val();
    capacity = $("#TextBox_AddClassroom_ClassroomCapacity").val();
    classroomType = $("#Select_AddClassroom_ClassroomType option:selected").val();

    jObj = {};
    if (name || capacity || classroomType) {
        if (name)
            jObj.name = name;
        if (capacity)
            jObj.capacity = capacity;
        if (classroomType)
            jObj.classroomType = classroomType;

        $.ajax({
            method: 'PUT',
            url: URL_CLASSROOMS + "/" + classroomId,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(jObj),

            success: function (result) {
                console.log("[Login] Result " + JSON.stringify(result));

                if (result.status === "OK") {
                    fClearClassroomForm();
                    fDisplayClassrooms();
                }
            },

            error: function (request, status, error) {
                console.log("[Login] Error: " + error);
                classroomId = null;
            }
        });
    } else {
        alert("Se deben insertar todos los datos");
    }
}

function fConfirmDeleteClassroom() {
    classroomId = $(this).attr("value");
    $("#Classrooms").hide();
    $("#ConfirmAction").show();
    $("#Btn_DeleteClassroomSubmit").show();
    $("#Btn_DeleteClassroomCancel").show();
}

function fDeleteClassroom() {
    $.ajax({
        method: 'DELETE',
        url: URL_CLASSROOMS + "/" + classroomId,
        success: function (result) {
            console.log("[Login] Result " + JSON.stringify(result));

            if (result.status === "OK") {
                fCancelDeleteClassroom();
            }
        },

        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
            classroomTypeId = null;
        }
    });
}

function fCancelDeleteClassroom() {
    fClearDeleteClassroom();
    fDisplayClassrooms();
}

function fClearDeleteClassroom() {
    classroomId = null;
    $("#Btn_DeleteClassroomSubmit").hide();
    $("#Btn_DeleteClassroomCancel").hide();
    $("#ConfirmAction").hide();
}




function fDisplayClassroomTypes() {
    $("#ManagerMenu").hide();
    $("#ClassroomTypes").show();
    $("#ClassroomTypes li").each(function (index) {
        if (index !== 0 && index !== 1) {
            $(this).remove();
        }
    });
    $.ajax({
        method: 'GET',
        url: URL_CLASSROOM_TYPES,

        success: function (result) {
            //alert(JSON.stringify(result));
            //result = result.classroomTypes; //Quitar cuando se pase a java
            for (i in result) {
                $("#ClassroomTypes ul").append(CLASSROOM_TYPES_LIST_TEMPLATE1 + result[i].name +
                        CLASSROOM_TYPES_LIST_TEMPLATE2 + result[i].description +
                        CLASSROOM_TYPES_LIST_TEMPLATE3 + result[i].classroomTypeId +
                        CLASSROOM_TYPES_LIST_TEMPLATE4 + result[i].classroomTypeId +
                        CLASSROOM_TYPES_LIST_TEMPLATE5);
            }
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fShowAddClassroomType() {
    $("#ClassroomTypes").hide();
    $("#AddClassroomType").show();
    $("#Btn_AddClassroomTypeSubmit").show();
    $("#Btn_AddClassroomTypeCancel").show();
}

function fAddClassroomType() {
    var name;
    var description;

    name = $("#TextBox_AddClassroomType_ClassroomTypeName").val();
    description = $("#TextArea_AddClassroomType_Description").val();

    if (name && description) {
        $.ajax({
            method: 'POST',
            url: URL_CLASSROOM_TYPES,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify({"name": name, "description": description}),

            success: function (result) {

                console.log("[Login] Result " + JSON.stringify(result));

                if (result.status === "OK") {
                    fCancelAddEditClassroomType();
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

function fCancelAddEditClassroomType() {
    fClearClassroomTypeForm();
    fDisplayClassroomTypes();
}

function fClearClassroomTypeForm() {
    $("#TextBox_AddClassroomType_ClassroomTypeName").val("");
    $("#TextArea_AddClassroomType_Description").val("");
    $("#TextBox_AddClassroomType_ClassroomTypeName").attr("placeholder", "");
    $("#TextArea_AddClassroomType_Description").attr("placeholder", "");
    $("#Btn_AddClassroomTypeSubmit").hide();
    $("#Btn_AddClassroomTypeCancel").hide();
    $("#Btn_UpdateClassroomTypeSubmit").hide();
    $("#Btn_UpdateClassroomTypeCancel").hide();
    $("#AddClassroomType").hide();
}

function fShowEditClassroomType() {
    $("#ClassroomTypes").hide();
    $("#AddClassroomType").show();
    $("#Btn_UpdateClassroomTypeSubmit").show();
    $("#Btn_UpdateClassroomTypeCancel").show();

    classroomTypeId = $(this).attr("value");

    $.ajax({
        method: 'GET',
        url: URL_CLASSROOM_TYPES + "/" + classroomTypeId,

        success: function (result) {
            $("#TextBox_AddClassroomType_ClassroomTypeName").attr("placeholder", result.name);
            $("#TextArea_AddClassroomType_Description").attr("placeholder", result.description);
        },
        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
        }
    });
}

function fEditClassroomType() {
    var name;
    var description;

    name = $("#TextBox_AddClassroomType_ClassroomTypeName").val();
    description = $("#TextArea_AddClassroomType_Description").val();

    jObj = {};
    if (name || description) {
        if (name)
            jObj.name = name;
        if (description)
            jObj.description = description;
        
        $.ajax({
            method: 'PUT',
            url: URL_CLASSROOM_TYPES + "/" + classroomTypeId,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(jObj),

            success: function (result) {

                console.log("[Login] Result " + JSON.stringify(result));

                if (result.status === "OK") {
                    fCancelAddEditClassroomType();
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

function fConfirmDeleteClassroomType() {
    classroomTypeId = $(this).attr("value");
    $("#ClassroomTypes").hide();
    $("#ConfirmAction").show();
    $("#Btn_DeleteClassroomTypeSubmit").show();
    $("#Btn_DeleteClassroomTypeCancel").show();
}

function fDeleteClassroomType() {
    $.ajax({
        method: 'DELETE',
        url: URL_CLASSROOM_TYPES + "/" + classroomTypeId,
        success: function (result) {
            console.log("[Login] Result " + JSON.stringify(result));

            if (result.status === "OK") {
                fCancelDeleteClassroomType();
            } else if (result.status === "FAIL") {
                alert("Fallo al eliminar, puede que existan aulas asignadas con el tipo de aula que se desea eliminar");
                fCancelDeleteClassroomType();
            }
        },

        error: function (request, status, error) {
            console.log("[Login] Error: " + error);
            classroomTypeId = null;
        }
    });
}

function fCancelDeleteClassroomType() {
    fClearDeleteClassroomType();
    fDisplayClassroomTypes();
}

function fClearDeleteClassroomType() {
    classroomTypeId = null;
    $("#Btn_DeleteClassroomTypeSubmit").hide();
    $("#Btn_DeleteClassroomTypeCancel").hide();
    $("#ConfirmAction").hide();
}
