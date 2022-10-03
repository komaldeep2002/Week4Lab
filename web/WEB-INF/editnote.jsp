<%-- 
    Document   : editnote
    Created on : Oct 2, 2022, 9:52:08 PM
    Author     : Komaldeep Kaur Virk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1><br>
        <h2>Edit Note </h2><br>
        <form action="noteKeeper" method="post">
            Title: <input type="text" name="title" value="${title}"><br>
            Contents: <input type="text" name="contents" value="${contents}"><br>
            <input type="submit" value="Save"> 
        </form><br>
        <p>${message}</p>
    </body>
</html>
