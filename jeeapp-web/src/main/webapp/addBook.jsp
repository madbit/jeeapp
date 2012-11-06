<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/addBook" method="post">
		<label for="title">title: </label> <input type="text" name="title" size="20" maxlength="50"> <br />
		<label for="price">price: </label> <input type="text" name="price" size="20" maxlength="50"> <br />
		<label for="description">description: </label> <textarea rows="20" cols="4" name="description"></textarea> <br />
		<label for="isbn">ISBN: </label> <input type="text" name="isbn" size="10" maxlength="10"> <br />
		<label for="nbOfPage">n. page: </label> <input type="text" name="nbOfPage" size="5" maxlength="5"> <br />
		<select>
			<option>yes</option>
			<option>no</option>
		</select> <br />
		<input type="submit">
	</form>
</body>
</html>