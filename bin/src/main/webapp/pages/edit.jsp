<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="container">
    <h2>Edit Student</h2>
    <form action="/update" method="post">
        <input type="hidden" name="id" value="${student.id}" />

        <label>Name:</label><br>
        <input type="text" name="name" value="${student.name}" required /><br><br>

        <label>Grade:</label><br>
        <input type="text" name="grade" value="${student.grade}" required /><br><br>

        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>
