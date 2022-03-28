<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World - Input Form</title>
</head>
<body>
	
	<!-- Process Form 1 -->
	<h1>Process Form 1</h1><br><br>
	
	<form action="processForm" method="get">
		<input type="text" name="studentName" placeholder="What's your name?" />
		<input type="submit" />
	</form>
	
	<!-- Process Form 2-->
	<h1>Process Form 2</h1><br><br>
	<form action="processFormVersionTwo" method="get">
		<input type="text" name="studentName" placeholder="What's your name?" />
		<input type="submit" />
	</form>
	
	<h1>Process Form 3</h1><br><br>
	<form action="processFormVersionThree" method="get">
		<input type="text" name="studentName" placeholder="What's your name?" />
		<input type="submit" />
	</form>
	
	
</body>
</html>