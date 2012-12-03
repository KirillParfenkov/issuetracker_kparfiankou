<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>


<c:url value="<%= Constants.INSERT_ADDING_USER_CONTROLLER %>" var="urlInsertAddingUserController"/>

<html>
  <head>
      <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>New type</title>
      <script src="javascript/functions.js"></script>
  </head>
    <body>
   	  <div id="header">
	  	<jsp:include page="<%=Constants.HEADER_PAGE %>"/>
	  </div>

	  <c:if test="${not empty errorMessage}">
	  	<div class=error> <c:out value="${errorMesage}"></c:out></div>
	  </c:if>

      <div id=main>
       <form name="addingUForm"  method="POST" action="${urlInsertAddingUserController}">
      	<table>
      		<tr>
      			<th>Create new user</th>
      		</tr>
      		<tr>
      			<td>First name</td>
      			<td><input name="<%=Constants.KEY_INPUT_FIRST_NAME %>" type="text" value=""/></td>
      		</tr>
      		<tr>
      			<td>Last name</td>
      			<td><input name="<%=Constants.KEY_INPUT_LAST_NAME %>" type="text" value=""/></td>
      		</tr>
      		<tr>
      			<td>Email</td>
      			<td><input name="<%=Constants.KEY_INPUT_EMAIL %>" type="text" value=""/></td>
      		</tr>
      		<tr>
      			<td>Role</td>
      			<td>
      				<select name="<%=Constants.KEY_INPUT_ROLE %>">
      					<option value="ADMINISTRATOR">Administrator</option>
      					<option value="USER">User</option>
      				</select>
      			</td>
      		</tr>
      		<tr>
      			<td>Password</td>
      			<td><input name="<%=Constants.KEY_INPUT_PASSWORD %>" type="password" value=""/></td>
      		</tr>
      		<tr>
      			<td>Password confirmation</td>
      			<td><input name="<%=Constants.KEY_INPUT_CON_PASSWORD %>" type="password" value=""/></td>
      		</tr>
      		<tr>
				<td><input type="submit" value="add"/></td>	
      		</tr>
		</table>
	   </form>
      </div>
    </body>
</html>