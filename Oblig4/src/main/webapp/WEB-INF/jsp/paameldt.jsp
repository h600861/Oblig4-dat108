
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bruker" scope="session" type="no.hvl.dat108.oblig4.entity.Bruker" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p> ${bruker.fornavn}</p>
<p> ${bruker.etternavn}</p>
<p> ${bruker.mobil}</p>
<p> ${bruker.kjonn}</p>
<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>