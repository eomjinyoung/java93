<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test</title>
</head>
<body>
<h1>파일 업로드 결과</h1>
name: ${name}<br>
age: ${age}<br>
file1: ${file1}<br>
<img id="img1" height="150"><br>
file2: ${file2}<br>
<img id="img2" height="150"><br>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
setTimeout(function() {
  $("#img1").attr("src", "${pageContext.request.contextPath}/upload/${file1}")
  $("#img2").attr("src", "${pageContext.request.contextPath}/upload/${file2}")
}, 5000);

</script>

</body>
</html>