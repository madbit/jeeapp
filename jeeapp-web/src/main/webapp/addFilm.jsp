<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Video library - Add film</title>
</head>
<body>
	<form action="addFilm" method="post">
		<table>
			<tr>
				<td>Title: </td>
				<td><input type="text" name="title" size="20" maxlength="50"></td>
			</tr>
			<tr>
				<td>Release date: </td>
				<td><input type="text" name="releaseDate" size="20" maxlength="50"></td>
			</tr>
			<tr>
				<td>Running time: </td>
				<td><input type="text" name="runningTime" size="20" maxlength="50"></td>
			</tr>
			<tr>
				<td>Director: </td>
				<td><input type="text" name="directorFirstname" size="20" maxlength="50"> 
				<input type="text" name="directorMidname" size="20" maxlength="50"> 
				<input type="text" name="directorLastname" size="20" maxlength="50"></td>
			</tr>
			<tr>
				<td>Actor: </td>
				<td><input type="text" name="actorFirstname" size="20" maxlength="50"> 
				<input type="text" name="actorMidname" size="20" maxlength="50"> 
				<input type="text" name="actorLastname" size="20" maxlength="50"></td>
			</tr>
		</table>
		<input type="submit">
	</form>
</body>
</html>