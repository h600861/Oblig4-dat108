<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p class="error">${error}</p>
<form action="innlogging" method="post">
    <fieldset>
        <label for="mobil">Mobil:</label>
        <input id="mobil" type="text" name="mobil" pattern="\d{8}" value="${mobil}" required/>

        <label for="passord">Passord:</label>
        <input id="passord" type="password" name="passord" pattern=".{8,}$" required/>
        <br><br><button type="submit">Logg inn</button>
        <br><br>


        <a href="paamelding">Gå til påmeldingssiden</a>
    </fieldset>
</form>
</body>
</html>