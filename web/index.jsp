<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="addEntity" method="post">
        <input type="text" name="name">
        <input type="text" name="surname">
        <input type="submit" value="addNew">
    </form>
    <form action="getXml" method="get">
        <input type="number" name="id">
        <input type="submit" value="Get Entity in XML">
    </form>
    <form action="getJson" method="get">
        <input type="submit" value="Get All in JSON">
    </form>
</body>
</html>
