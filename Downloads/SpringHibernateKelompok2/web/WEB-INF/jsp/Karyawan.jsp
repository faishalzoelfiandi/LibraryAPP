<%-- 
    Document   : Karyawan
    Created on : Jun 14, 2021, 3:30:39 PM
    Author     : Arief
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Karyawan</title>
    </head>
    <body>
        <h1>List Karyawan</h1>
        <table border="1">
            <tr>
                <th>ID</th> <th>Nama Karyawan</th> <th>Jenis Kelamin</th> <th>Jabatan</th> <th>Alamat</th>
            </tr>
            <c:forEach var="user" items="${datakaryawan}">
                <tr>
                    <td> <c:out value="${user.getId()}"></c:out> </td>
                    <td> <c:out value="${user.getNamaKaryawan()}"></c:out> </td>
                    <td> <c:out value="${user.getJenisKelamin()}"></c:out> </td>
                    <td> <c:out value="${user.getJabatan()}"></c:out> </td>
                    <td> <c:out value="${user.getAlamat()}"></c:out> </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
