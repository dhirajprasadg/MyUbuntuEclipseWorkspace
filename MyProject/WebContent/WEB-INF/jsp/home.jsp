<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
        var contexPath = "<%=request.getContextPath()%>";
</script>
<script type="text/javascript" src="/resources/js/user.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- <link rel="stylesheet" type="text/css" href="styles.css">
 -->
 
<link rel="stylesheet" href="/MyProject/resources/style.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">

$( function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  } );
  </script>

<!-- 
<script type="text/javascript"> 
    function doSearch() {
 
    	$.getJSON("looseSearch.sp", 
    		 { CHARS: $('#searchBox').val() },
    		 function(data) 
               {   
                  $('#results').text('');
         
                  for (var index in data) {
        
                     $('#results').append('<p>' + data[index].userName + '</p>'); 
                  }
               });
 }
</script> -->



</head>
<body>

	<h2>Admin Home Page</h2>

	<jsp:include page="/resources/_menu.jsp"></jsp:include>



	<div class="ui-widget">
		<label for="tags">Tags: </label>
		<input id="tags">
	</div>

	<h3>Get List of Users</h3>

	<table>
		<tr>
			<td colspan="2"><div id="error" class="error"></div></td>
		</tr>

		<tr>
			<td>Enter Name :</td>
			<td><input type="text" id="name"><br /></td>
		</tr>

		<tr>
			<br />
			<td colspan="2" align="right"><input type="button" value="Get User" onclick="dousersearch()"><br /></td>
		</tr>

		<tr>
			<td colspan="2"><div id="info" class="success"></div></td>
		</tr>

	</table>

	<h3 style="color: green; margin-left: 80%; margin-top: -5%">Welcome ${userDetailss.userName}</h3>
	</br>
	</br>


</body>
</html>