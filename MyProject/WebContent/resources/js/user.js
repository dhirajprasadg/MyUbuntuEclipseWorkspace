function dousersearch() {
	var name = $("#name").val();
    console.log("dousersearch called  : Name " + name );
   alert("dousersearch called");
    $.ajax({
    	 // The URL for the request
    	 url: contexPath + "/dousersearch.sp",
    	 // The data to send (will be converted to a query string)
    	 data: "name=" + name,    	 
         // Whether this is a POST or GET request
         type: "GET",
    	 // The type of data we expect back
    	 dataType : "json",
    	 headers: { 
            Accept : "application/json"
        },
        success: function(response){
            // we have the response
            if(response.status == "SUCCESS"){
                console.log("response.result.length " + response.result.length );
                userInfo = "<ol>";
                for(i =0 ; i < response.result.length ; i++){
                    console.log("response.result.length " +  response.result[i].userName );
                    userInfo += "<br><li><b>Name</b> : " + response.result[i].userName +";" +
                    		"<b> id</b> : " + response.result[i].id+";" +
                    "<b> password</b> : " + response.result[i].password+";" +
                    "<b> isactive</b> : " + response.result[i].isactive;
                    
                 }
                userInfo += "</ol>";
                 $('#info').html("User has been added to the list successfully. " + userInfo);
                 $('#name').val('');
                 $('#education').val('');
                 $('#error').hide('slow');
                 $('#info').show('slow');
             }else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#info').hide('slow');
                 $('#error').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
}