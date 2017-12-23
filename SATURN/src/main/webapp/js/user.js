/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    showUsers();
    
});

function addUser(User){
    var table = document.getElementById("userTable");
    
    var template = "<li class='list-item'><div class='text-block-3'>{{Name}}"+
   "</div><div class='text-block-4'>{{Last_Name}}"+
"</div><a href='info-carrera.html' class='button-11 w-button'></a></li>";
    table.append(Mustache.render(template,User));
};

function showUsers(){
     
    
    $.ajax({
        //url: 'http://localhost:8080/BasesProyecto/rest/proyects/list',
        dataType: 'json',
        type: 'GET',
        success: function( Users, textStatus, jQxhr ){
                console.log('success',Users);
                $.each(Users, function(i , User){
                    addUser(User);

                });
        },
        error: function( jqXhr, textStatus, errorThrown ){
            console.log( errorThrown );
        }
    });
};

