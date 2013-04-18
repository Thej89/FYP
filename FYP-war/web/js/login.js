/* 
 * Final Year Project(EasyContact)
 */

/**
 *
 * login
 * Mar 11, 2013 2:03:26 PM
 * Thejanee Walgamage <2008061>
 */


function login()
{ 
    var dataURL = "/fyp-war/login.htm?username="+document.getElementById("username_login").value+
    "&password="+document.getElementById("password_login").value;
    var JSONdata = jQuery.ajax({
        type: "GET",
        dataType: "json",
        url: dataURL
    }).done(function(jsonData){
        // do something with the data, it should already be parsed
        alert(jsonData.length); // your data sample is an array, see if it gets a length back
    }).fail(function(xhr){
        // uh oh, we failed.. you should always handle failures too.
        });
}
