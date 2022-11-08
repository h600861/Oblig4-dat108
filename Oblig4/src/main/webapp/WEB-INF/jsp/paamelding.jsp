<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="no">
<head>
    <link href="css/simple.css" rel="stylesheet" type="text/css"/>
    <script src="js/PassordValidator.js" defer></script>
    <title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<p style="color:#ff0000">${redirectMessage}</p>
<form id="deltagerFormBean" action="/paamelding" method="post" modelAttribute="bruker">
    <fieldset>
        <label for="fornavn">Fornavn</label>
        <input id="fornavn" name="fornavn" title="Fornavn"
               pattern="\s*\p{Lu}\p{Ll}+\s*" placeholder="Fyll inn fornavn"
               required="required" type="text" value=""  />


        <label for="etternavn">Etternavn</label>
        <input id="etternavn" name="etternavn" title="Etternavn"
               pattern="\s*\p{Lu}\p{Ll}+\s*" placeholder="Fyll inn etternavn"
               required="required" type="text" value=""/>

        <label for="mobil">Mobil (8 siffer)</label>
        <input id="mobil" name="mobil" title="Må ha 8 siffer"
               pattern="\d{8}" placeholder="Fyll inn telefonnummer"
               required="required" type="text" value=""/>



        <label for="passord">Passord</label>
        <input id="passord" name="passord" title="Må være minst 8 tegn"
               pattern=".{8,}" placeholder="Velg et passord" type="password"
               required="required" value="" onfocus="sjekkPassordStyrke()"/>

        <label for="passordRepetert">Passord repetert</label>
        <input id="passordRepetert" name="passordRepetert" title="Må være lik passord"
               pattern=".{8,}$" placeholder="Gjenta passord" type="password"
               required="required" value="" onfocus="sammenlignPassord()"/>

        <label>Kjønn:
        <input id="kjonn1" name="kjonn" checked="checked" type="radio" value="mann"/>mann
        <input id="kjonn2" name="kjonn" type="radio" value="kvinne"/>kvinne
        </label>
        <br><br><button type="submit">Meld meg på</button>
    </fieldset>
</form>
</body>
</html>