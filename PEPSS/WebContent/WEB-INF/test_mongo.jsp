<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Tests JDBC</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body>
        <h1>Tests JDBC</h1>

<table>
	<tr>
		<th>Table of current/estimated portfolio</th>
	</tr>
	
	<c:forEach var="message" items="${messages}" >
		<tr>
			<td>${message}</td>
		</tr>
	</c:forEach>
</table>
    	<button>historique des cours.</button>
    	<button>pricer.</button>
    	<button>historique du portefeuille.</button>
    	<button>Recalibrer portefeuille.</button>
    	<button>Valider recalibration.</button>

    </body>
</html>