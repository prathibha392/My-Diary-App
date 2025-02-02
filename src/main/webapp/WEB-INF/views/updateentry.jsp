<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<h1 style="font-size:18px;">Welcome  <span style= "color:red; font-size:18px;">${user.username}</span></h1>
  </div>
  <div class="bodypart">
  
  <div class="bodypart1">
  <img src="<c:url value="/resources/images/addentry.png"/>">
  </div>
  <div class="bodypart2">
  <h1>Update Entry</h1><br/>
  <form action="./processentryupdate" method="post">
   <lable class="spl">Date</lable>  <input type="text" name="entrydate" class="formcontroler" value="<fmt:formatDate value="${entry.entrydate}" pattern="yyyy-MM-dd"/>" readonly><br/><br/>
   <lable class="spl">Description</lable>  <textarea rows="10" cols="30" name="description">
    ${entry.description}
   </textarea>
   <input type="hidden" name="userid" value="${user.id}">
   <input type="hidden" name="id" value="${entry.id}">
   
   <br/><br/>
   <button type="submit" class="Button">Update</button>
  </form>
  <br/><br/>
  
  </div>
  
  </div> 

</body>
</html>