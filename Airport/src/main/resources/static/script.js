document.getElementById("demo").innerHTML = "Hello, World!";

$(document).ready(function() {
    $("#demo").html("Hello, World!");
});

$(document).ready(function() {
    $.get("http://localhost:8080/api/airplane/", function(myData, status){
        alert("Data: " + myData + "\nStatus: " + status);
    });
});

$(document).ready(function() {
        $("#div1").load("http://localhost:8080/api/airplane/");
});