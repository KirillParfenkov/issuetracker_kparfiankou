<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>


<c:url value="<%= Constants.INSERT_UPDATE_USER_CONTROLLER %>" var="urlInsertUpdateUserController"/>

<c:set var="pageBuilds" value="${project.builds}" scope="page"></c:set>

<html>
  <head>
      <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>Details of the issue</title>
      <script src="javascript/functions.js"></script>
  </head>
    <body>
   	  <div id="header">
	  	<jsp:include page="<%=Constants.HEADER_PAGE %>"/>
	  </div>

	  <c:if test="${not empty errorMessage}">
	  	<div class=error> <c:out value="${errorMessage}"></c:out></div>
	  </c:if>

      <div id=main>
       <form name="updateUserForm"  method="POST" action="${urlInsertUpdateUserController}">
        <input type="hidden" name="updateUserId" value="${updateUser.id}">
      	<table>
      		<tr>
      			<td>First name</td>
      			<td><input name="<%=Constants.KEY_INPUT_FIRST_NAME %>" type="text" value="${updateUser.firstName}"/></td>
      		</tr>
      		<tr>
      			<td>Last name</td>
      			<td><input name="<%=Constants.KEY_INPUT_LAST_NAME %>" type="text" value="${updateUser.lastName}"/></td>
      		</tr>
      		<tr>
      			<td>Email address</td>
      			<td><input name="<%=Constants.KEY_INPUT_EMAIL %>" type="text" value="${updateUser.emailAddress}"/></td>
      		</tr>
      		<tr>
      			<td>
      				<select name="<%=Constants.KEY_INPUT_ROLE %>">
      					<option value="ADMINISTRATOR">Administrator</option>
      					<option value="USER">User</option>
      				</select>
      			</td>
      		</tr>
      		<tr>
				<td><input type="submit" value="update"/></td>      		
      		</tr>
		</table>
	   </form>
      </div>
    </body>
</html>