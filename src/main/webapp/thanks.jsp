<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Thanks for taking our survey!</h1>

<p>Here is the information that you entered:</p>

<label>First Name:</label>
<span>${survey.user.firstName}</span><br>
<label>Last Name:</label>
<span>${survey.user.lastName}</span><br>
<label>Email:</label>
<span>${survey.user.email}</span><br>
<label>Date of Birth:</label>
<span>${survey.user.dateOfBirth}</span><br>
<label>Heard From:</label>
<span>${survey.hearAboutUs}</span><br>

<label>Announcements:</label>
<div class="values">
    <c:choose>
        <c:when test="${empty survey.announcements}">None</c:when>
        <c:otherwise>
            <c:forEach var="a" items="${survey.announcements}">
                <div>${a}</div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>

<label>Contact By:</label>
<span>${survey.contactBy}</span><br>

<p>To enter another survey, click on the Back
    button in your browser or the Return button shown
    below.</p>

<form action="index.html" method="get">
    <input type="submit" value="Return">
</form>

</body>
</html>