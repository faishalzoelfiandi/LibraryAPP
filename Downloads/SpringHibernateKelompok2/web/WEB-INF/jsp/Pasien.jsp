<%-- 
    Document   : Pasien
    Created on : Jun 14, 2021, 3:30:46 PM
    Author     : Arief
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pasien</title>
    </head>
    <body>
        <h1>List Pasien</h1>
        <table border="1">
            <tr>
                <th>ID</th> <th>Nama Pasien</th> <th>Jenis Kelamin</th> <th>Alamat</th>
            </tr>
            <c:forEach var="user" items="${datapasien}">
                <tr>
                    <td> <c:out value="${user.getId()}"></c:out> </td>
                    <td> <c:out value="${user.getNamaPasien()}"></c:out> </td>
                    <td> <c:out value="${user.getJenisKelamin()}"></c:out> </td>
                    <td> <c:out value="${user.getAlamat()}"></c:out> </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
