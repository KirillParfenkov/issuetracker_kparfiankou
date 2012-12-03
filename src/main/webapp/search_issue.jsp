<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.CREATE_SEARCH_PAGE_CONTROLLER %>" var="urlCreateSearchPageController"/>
<c:url value="<%= Constants.CREATE_UPDATE_USER_CONTROLLER %>" var="urlCreateUpdateUserController"/>

<html>
  <head>
      <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>Adding issue</title>
      <script src="javascript/functions.js"></script>
  </head>
    <body>
   	  <div id="header">
	  	<jsp:include page="<%= Constants.HEADER_PAGE %>"/>
	  </div>

	  <c:if test="${not empty errorMessage}">
	  	<div class=error> <c:out value="${errorMessage}"></c:out></div>
	  </c:if>

      <div id=main>
         <form name="searchUserForm"  method="POST" action="${urlCreateSearchPageController}">
         	<h1>Search issue!</h1>
      		<table>
      			<tr>
      				<th>Search user</th>
      			</tr>
      			<tr>
      				<td>First name</td>
      				<td><input name="<%=Constants.KEY_INPUT_FIRST_NAME %>" type="text" /></td>
      			</tr>
      			<tr>
      				<td>Last name</td>
      				<td><input name="<%=Constants.KEY_INPUT_LAST_NAME %>" type="text" /></td>
      			</tr>
      			<tr>
      				<td>Email</td>
      				<td><input name="<%=Constants.KEY_INPUT_EMAIL %>" type="text"/></td>
      			</tr>
      			<tr>
					<td><input type="submit" value="search" /></td>
      			</tr>
      		</table>	
	   	</form>

	   	<form name="listUserForm"  method="POST" action="${urlCreateUpdateUserController}">
          <input type=hidden name=<%= Constants.KEY_USER_ID %> value="">
	   	  <c:if test="${not empty users}">
      		<table>
      			<tr class=head>
      				<th>id</th>
      				<th>first name</th>
	   				<th>last name</th>
    				<th>role</th>
      				<th>email address</th>
      			</tr>
      		<c:forEach var="user" items="${users}">
      			<tr>
      				<td>
      					<a href="JavaScript:document.listUserForm.submit()"
					   	   onclick="listUserForm.userId.value = ${user.id}">
						   ${user.id}
						</a>
					</td>
      				<td>${user.firstName}</td>
      				<td>${user.lastName}</td>
      				<td>${user.role}</td>
      				<td>${user.emailAddress}</td>
      			</tr>	
      		</c:forEach>
      		</table>
     	  </c:if>
     	  <c:if test="${not empty infoMessage}">
     		<c:out value="${infoMessage}"></c:out>
     	  </c:if>
     	</form>
      </div>
    </body>
</html>