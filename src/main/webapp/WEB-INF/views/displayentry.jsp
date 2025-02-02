<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="<c:url value="/resources/style/style.css"/>">

<div class="header">
  
   <div class="firstpart">
   <img src="<c:url value="/resources/images/my diary.jpg"/>" width="50" height="50">
   </div>
   
   <div class="secondpart">My Diary App</div>
   
</div>
<br/>
<hr/>
<div style="padding:6px;">
<h1 style="font-size:18px;">Welcome<span style= "color:red; font-size:18px;">${user.username}</span></h1>
  </div>
  <div class="bodypart">
  
  <div class="bodypart1">
  <img src="<c:url value="/resources/images/addentry.png"/>">
  </div>
  <div class="bodypart2">
  <h1>view Entry</h1><br/>
  
  <table>
  <tr><td>Date :</td><td>${entry.entrydate}</td></tr>
  <tr><td>Description :</td><td>${entry.description}</td></tr>
  </table>
  
  <br/><br/>
   <a href="./userhome"><button type="button" class="Button">Home</button></a>
   
  
  </div>
  
  </div> 

</body>
</html>