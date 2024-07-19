<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome, ${username}!</h2>
    <a href="/quiz">${quizLinkLabel}</a><br>
    <a href="/grades">View Grades</a><br>
    <a href="/logout">Logout</a>
</body>
</html>