<%-- 
    Document   : viewnote
    Created on : Oct 2, 2022, 9:58:11 PM
    Author     : Komaldeep Kaur Virk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><b>Title: </b>${note.title}</p>
        <b>Contents: </b><p>${note.contents}</p>
        <a href="noteKeeper?edit">Edit</a>
    </body>
</html>
