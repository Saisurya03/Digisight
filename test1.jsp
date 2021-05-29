
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload to Database Demo</title>
</head>
<body>
    <center>
        <h1>File Upload to Database Demo</h1>
        <form method="post" action="testfile" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Assignment name: </td>
                    <td><input type="text" name="aname" size="50"/></td>
                </tr>
                <tr>
                    <td>Deadline: </td>
                    <td><input type="text" name="dl" size="50"/></td>
                </tr>
                <tr>
                    <td>Subject: </td>
                    <td><input type="text" name="subj" size="50"/></td>
                </tr>
                <tr>
                    <td>file: </td>
                    <td><input type="file" name="file" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>