<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grade Page</title>
</head>
<body>
    <h2>Grades</h2>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Score</th>
        </tr>
        <c:forEach items="${grades}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>