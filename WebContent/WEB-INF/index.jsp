<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Great Number Game</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<style>
		.no {
			text-align: center;
			color: white;
			width: 160px;
			height: 100px;
			background-color: red;
			margin-bottom: 10px;
			padding: 10px;
		}
		.yes {
			text-align: center;
			color: white;
			width: 160px;
			height: 100px;
			background-color: green;
			margin-bottom: 10px;
			padding: 10px;
			
		}
	</style>
</head>
<body>
<div class="container">
	<div class="row">

		<h1>Welcome to the Great Number Game!</h1>
		<h4>I am thinking of a number between 1 and 100</h4>
		<h4>Take a guess!</h4>
	
	</div>

	<div class="row box">
		<% if(session.getAttribute("num") != null){ %>
			<% int num = (int) session.getAttribute("num"); %>
			<% int randomNumber = (int) session.getAttribute("randomNumber"); %>
			<% if(num>randomNumber){ %>
				<div class="no">Too High!</div>
			<%} else if (num<randomNumber){%>
				<div class="no">Too Low!</div>
			<%} else {%>
				<div class="yes">
					<%= num %> was the number!
					<br>
					<form action="/greatNumberGame/greatNumberGame" method="POST">
						<input type="submit" class="btn btn-light" value="Play again!">
					</form>
					<br>
				</div>
			<%} %>
		<%} %>
		
	</div>
	
	<form action="/greatNumberGame/greatNumberGame" method="POST">
		<div class="row">
			<input type="text" name="num">
		</div>
		<br>
		<div class="row">
			<button type="submit" class="btn btn-warning">Submit</button>
		</div>
	</form>
		
</div>
  
</body>
</html>