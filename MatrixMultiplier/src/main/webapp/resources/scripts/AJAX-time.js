            function timeView() {                       
                 $.get('TimeServlet',function(responseText) { 
                        $('#time').text(responseText);         
                    });
            }
            setInterval( "timeView()", 900 );