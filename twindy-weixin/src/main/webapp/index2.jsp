<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="apple-touch-fullscreen" content="YES">
    <meta name="full-screen" content="yes">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="email=no">
</head>
<body>
    <p><img src="${headImgUrl}" width="50" height="50"></p>
    <p>你好， ${username}</p>
    <p>openId: ${openId}</p>
    <p>sex: ${sex}</p>
    <p>province: ${province}</p>
</body>
</html>
