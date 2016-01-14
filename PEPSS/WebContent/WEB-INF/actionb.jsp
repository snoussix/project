<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.sdzee.bdd.TestMongo"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cours action</title>
<script type="text/javascript">
var xhttp;

function callback(){
    if (xhttp.readyState == 4 && xhttp.status == 200) {
	      document.getElementById("values").innerHTML = xhttp.responseText;
}
}

function post(share) {
	  if (action == "") {
	    document.getElementById("values").innerHTML = "";
	    return;
	  }
	  
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = callback;
	  xhttp.open("POST", "/PEPSS/actionbb?q="+share, true);
	  xhttp.send();
    
    
}

</script>
</head>

<select id="action" onchange="post(this.value)">
  <option value="DHR">DANAHER</option>
  <option value="A">AGILENT TECHNOLOGIES</option>
  <option value="ECL">ECOLAB</option>
  <option value="PNR">PENTAIR</option>
  <option value="FLS">FLOWSERVE</option> 
  <option value="ROP">ROPER INDUSTRIES </option><!--  TODO: VERIFICATION of ISIN CODE for match -->
  <option value="XYL">XYLEM</option>
  <option value="VIE.PA">Veolia Environnement</option>
  <option value="UU.L">UNITED UTILITIES GROUP</option>
  <option value="TMO">Thermo Fisher </option>
  <option value="TM">Toyota Motor </option>
  <option value="SIE.DE">Siemens</option>
  <option value="EMR">Emerson Electric </option>
  <option value="ETN">EATON</option>
  <option value="CMI">CUMMINS </option>
  <option value="CSX">CSX </option>
  <option value="SU.PA">SCHNEIDER ELECTRIC</option>
  <option value="LIN.DE">Linde </option>
  <option value="EJPRY">East Japan Railway  </option>
  <option value="BWA">BORGWARNER  </option>
  <option value="KPN.AS">KONINKLIJKE </option>
  <option value="DOW">DOW CHEMICAL</option>
  <option value="MDLZ">MONDELEZ </option>
  <option value="DE">DEERE & CO  </option>
  <option value="AGCO">AGCO  </option>
  <option value="CNI">CANADIAN NATIONAL RAILWAY </option>
  <option value="K">KELLOGG</option>
  <option value="MOS">MOSAIC</option>
  <option value="CF">CF INDUSTRIES</option>
  <option value="BRFS">BRF SA</option> 
</select>

<div id="values"></div>
<body>
<table>
	<tr>
		<th>Table of historic</th>
	</tr>
	<c:forEach var="message" items="${messages}" >
		<tr>
			<td>${message}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>