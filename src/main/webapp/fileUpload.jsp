<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
    <form method="post" action="fileuploadservlet" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="Upload"/>
    </form>
</body>
</html>
