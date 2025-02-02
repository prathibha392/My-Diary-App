<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>

<link rel="stylesheet" href="<c:url value="/resources/style/style.css"/>">

<body>
  <div class="header">
  
   <div class="firstpart">
   <img src="<c:url value="/resources/images/my diary.jpg"/>" width="50" height="50">
   </div>
   
   <div class="secondpart">My Diary App</div>
   
  </div>
  <br/>
  <hr/>
  
  <div class="bodypart">
  
  <div class="bodypart1">
  <img src="<c:url value="/resources/images/Register.png"/>">
  </div>
  <div class="bodypart2">
  <h1>Register Here</h1><br/>
  <form action="./saveuser" method="post">
   <lable class="spl">User Name</lable>  <input type="text" name="username" class="formcontroler"><br/><br/>
   <lable class="spl">Password</lable>  <input type="password" name="password" class="formcontroler"><br/><br/>
   <button type="submit" class="Button">Register</button>
  </form>
  <br/><br/>
  
  Existing User?<a href="./home">Login</a> Here
  
  </div>
  
  </div> 
</body>
</html>