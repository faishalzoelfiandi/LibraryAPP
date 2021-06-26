<%-- 
    Document   : Obat
    Created on : Jun 14, 2021, 3:30:53 PM
    Author     : Arief
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Obat</title>
    </head>
    <body>
        <h1>List Obat</h1>
        <table border="1">
            <tr>
                <th>ID</th> <th>Nama Obat</th> <th>Jenis Obat</th> <th>Harga</th>
            </tr>
            <c:forEach var="user" items="${dataobat}">
                <tr>
                    <td> <c:out value="${user.getId()}"></c:out> </td>
                    <td> <c:out value="${user.getNamaObat()}"></c:out> </td>
                    <td> <c:out value="${user.getJenisObat()}"></c:out> </td>
                    <td> <c:out value="${user.getHarga()}"></c:out> </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
