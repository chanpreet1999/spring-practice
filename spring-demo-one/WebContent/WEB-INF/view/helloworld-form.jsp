<!DOCTYPE html>
<html>
<head>
	<title>Hello World | Form</title>
	 
	<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	
</head>
<body>

  <div class="jumbotron">
 	 <h1 class="display-4">HelloWorld Form!</h1>
 </div>
	
	 <form action="processFormVersionThree" method="get">
  
  <div class="form-group">
    <label for="exampleInputName">Name</label>
    <input type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" placeholder="Enter name"
     name="studentName">  
    <small id="NameHelp" class="form-text text-muted">We'll never share your data with anyone else.</small>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
	
	
	<!-- 
	<form action="processForm" method="GET">
	<label>Name:</label>
	<input type="text" name="studentName" placeholder="What's your name?" class="name1"/>
	<input type="submit" value="Submit" />
	</form>
 -->
</body>

</html>