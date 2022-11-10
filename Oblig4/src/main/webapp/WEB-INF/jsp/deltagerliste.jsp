<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="bruker" scope="session" type="no.hvl.dat108.oblig4.entity.Bruker" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Deltagerliste</title>
</head>
<body>
<p>Innlogget som: ${bruker.mobil} / ${bruker.fornavn} ${bruker.etternavn}</p>
<h2>Deltagerliste</h2>
<p style="color:#ff0000">${redirectMessage}</p>
<table>
    <tr>
        <th>Kjønn</th>
        <th>Navn</th>
        <th>Mobil</th>
    </tr>
    <c:forEach var="b" items="${brukere}">
      <tr style="${b.mobil.equals(bruker.mobil) ? "background-color:limegreen;" : ""}">
       <td>${b.kjonn.equals("mann") ? "&#9794;" : "&#9792;"}</td>
        <td>${b.fornavn} ${b.etternavn}</td>
        <td>${b.mobil}</td>
      </tr>
    </c:forEach>
</table>
<br>
<form action="loggut" method="post">
    <button type="submit">Logg ut</button>
</form>
</body>