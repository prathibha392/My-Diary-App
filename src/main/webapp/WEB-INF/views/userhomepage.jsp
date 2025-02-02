<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>User HomePage</title>
</head>
<body>
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
  <div class="userhome">
  <h1>Welcome <span style="color:red;">${user.username}</span>
  <a href="./signout" style="color:red; float:right; padding:15px;">LogOut</a></h1>
  
  <br/><br/><br/><br/>
  
  <span class="heading">List Of Entries</span>
  
  <a href="./addentry"><button type="button" class="addbtn">Add Entry</button></a>
  <br/><br/><br/>
  <table border="1" class="listtab">
  <tr>
  <th>Date</th>
  <th colspan="3">Actions</th>
  </tr>
  
  <c:if test="${entrieslist.size()==0}">
  <tr><td style="font-size:17px; color:green; text-align:center;" colspan="4" >user do not enter any details till now </td></tr>
  </c:if>
  
  <c:forEach items="${entrieslist}" var="e" >
  <tr>
  <td>
  <fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/>
  </td>
  <td><a href="./viewentry?id=${e.id}" style="text-decoration: none; color:blue;">View</a></td>
  <td><a href="./updateentry?id=${e.id}"style="text-decoration: none; color:blue;">Update</a></td>
  <td><a href="./deleteentry?id=${e.id}" onclick="window.confirm('Are You Sure to Delete Entry')" style="text-decoration: none; color:blue;">Delete</a></td>
  </tr>
  
  </c:forEach>
  </table>
  
  
  </div>
</body>
</html>