/* Marcar las estrellas de atras hasta la seleccionada
$(".star").click(function(){
      n = Number($(this).attr("value"));
      $(this).parent().children(".star").slice(0,n).addClass("highlight");
});
*/
var URL_TEACHERS_AFINITIES = "/SATURN/rest/teachers/afinities";
var URL_COURSES = "/SATURN/rest/courses";

var AFINITY_LIST_TEMPLATE1 = "<li class=\"s_listitem2\"><div class=\"w-row\"><div class=\"s_center w-col w-col-3\"><div class=\"s_text1\">";
var AFINITY_LIST_TEMPLATE2 = "</div></div><div class=\"s_center w-col w-col-6\"><div class=\"s_text1\">";
var AFINITY_LIST_TEMPLATE3 = "</div></div><div class=\"s_center w-col w-col-3\"><div star=\"0\" course=\"";
var AFINITY_LIST_TEMPLATE4 = "\" class=\"s_div2\"><a href=\"#\" class=\"s_button9 star w-button\" value=\"1\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"2\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"3\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"4\"  style=\"background-image: none;\"></a><a href=\"#\" class=\"s_button9 star w-button\" value=\"5\"  style=\"background-image: none;\"></a></div></div></div></li>";



var userAfinity;

function fShowAfinity() {
  $("#TeacherMenu").hide();
  $("#Afinity").show();
  $("#Afinity li").each(function (index) {
    if(index !== 0 && index !== 1){
      $(this).remove();
    }
  });

  $.ajax({
		method: 'GET',
		url: URL_TEACHERS_AFINITIES + "/" + userId,

		success: function(result){
			//alert(JSON.stringify(result));
			for (i in result) {
        id = result[i].courseId;
        level = result[i].level;
        $.ajax({
      		method: 'GET',
      		url: URL_COURSES + "/" + userId,

      		success: function(result){
            $("#Afinity ul").append(  AFINITY_LIST_TEMPLATE1 + result.code +
                                      AFINITY_LIST_TEMPLATE2 + result.name +
                                      AFINITY_LIST_TEMPLATE3 + id +
                                      AFINITY_LIST_TEMPLATE4);
      		},
      		error: function(request, status, error){
      			console.log("[Login] Error: " + error);
      		}
      	});
			}
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
}

function fChangeAfinity() {

  var jObj;
  var star;
  var course;

  jObj = [];
  $("#Afinity .div-block").each(function() {
    star = $(this).attr("star");
    course = $(this).attr("course");
    jObj.push({ "star" : star,
                "course" : course});
  });


  console.log(jObj);
}

function fReloadAfinity() {

}
