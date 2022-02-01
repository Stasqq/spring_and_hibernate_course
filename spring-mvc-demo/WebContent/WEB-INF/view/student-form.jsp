<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
	Last name: <form:input path="lastName" />

	<br><br>

	Country:
	
	<form:select path="country">
	
		<form:options items="${student.countryOptions}" />
		
	</form:select>

	<br><br>
	
	Favorite Programming Language:
	<br>
	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	<br>
	C# <form:radiobutton path="favoriteLanguage" value="C#"/>
	<br>
	PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
	<br>
	Python <form:radiobutton path="favoriteLanguage" value="Python"/>
	<br>
	
	<br><br>
	
	Operating Systems:
	<br>
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	<br>
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	<br>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	
	<br><br>
		
	<input type="submit" value="Submit" />
		
	</form:form>

</body>
</html>