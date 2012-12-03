<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>


<c:url value="<%= Constants.INSERT_UPDATE_PASSWORD_CONTROLLER %>" var="urlInsertUpdatePasswordController"/>

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
       <form name="updatePasswordForm"  method="POST" action="${urlInsertUpdatePasswordController}">
      	<table>
      		<tr>
      			<td>New password</td>
      			<td><input name="<%=Constants.KEY_INPUT_PASSWORD %>" type="password" value=""/></td>
      		</tr>
      		<tr>
      			<td>Password confirmation</td>
      			<td><input name="<%=Constants.KEY_INPUT_CON_PASSWORD %>" type="password" value=""/></td>
      		</tr>
      		<tr>
				<td><input type="submit" value="update"/></td>      		
      		</tr>
		</table>
	   </form>
      </div>
    </body>
</html>