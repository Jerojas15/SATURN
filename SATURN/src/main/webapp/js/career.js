/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
$(document).ready(function(){
    showCareers();
    
});

function addCareers(career){
    var table = document.getElementById("careerTable");
    
    var template = "<li class='list-item'><div class='text-block-3'>{{University}}"+
   "</div><div class='text-block-4'>{{Career}}"+
"</div><div class='text-block-5'>{{Plan}}"+
"</div><a href='info-carrera.html' class='button-11 w-button'></a></li>";
    table.append(Mustache.render(template,career));
};

function showCareers(){
     
    
    $.ajax({
        url: 'http://localhost:8080/SATURN/careers',
        dataType: 'json',
        type: 'GET',
        success: function( Careers, textStatus, jQxhr ){
                console.log('success',Careers);
                $.each(Careers, function(i , Career){
                    addCareer(Career);

                });
        },
        error: function( jqXhr, textStatus, errorThrown ){
            console.log( errorThrown );
        }
    });
};

