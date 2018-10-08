document.getElementById("demo").innerHTML = "Airplanes";

$(document).ready(function() {
    $("#demo").html("Airplanes");
});

$(document).ready(function() {
    $.get("http://localhost:8080/api/airplane/", function(myData, status){
        alert("Data: " + myData + "\nStatus: " + status);
    });
});

$(document).ready(function() {
        $("#div1").load("http://localhost:8080/api/airplane/");
});

$(document).ready(function() {
    // Setup - add a text input to each footer cell
    $('#data-table thead th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    } );

var table = $("#data-table").DataTable({
    "iDisplayLength": -1,
    ajax: {
                url: "http://localhost:8080/api/airplane/",
                dataSrc: ''
    },
    columns: [
                { data: 'id' },
                { data: 'fuel' },
                { data: 'location' }
    ]
});

// Apply the search
table.columns().every( function () {
    var that = this;

    $( 'input', this.header() ).on( 'keyup change', function () {
        if ( that.search() !== this.value ) {
            that
                .search( this.value )
                .draw();
        }
    } );
} );

});