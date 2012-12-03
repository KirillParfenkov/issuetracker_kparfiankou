<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>


<c:url value="<%= Constants.UPDATE_PROFILE_CONTROLLER %>" var="urlUpdateProfileController"/>
<c:url value="<%= Constants.UPDATE_PASSWORD_PAGE %>" var="urlUpdatePasswordPage"/>

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
      	<form name="updateProjectForm"  method="POST" action="${urlUpdateProfileController}">
         <table>
      		<tr>
      			<td>First name</td>
      			<td><input name="<%=Constants.KEY_INPUT_FIRST_NAME %>" type="text" value="${user.firstName}"/></td>
      		</tr>
      		<tr>
      			<td>Last name</td>
      			<td><input name="<%=Constants.KEY_INPUT_LAST_NAME %>" type="text" value="${user.lastName}"/></td>
      		</tr>
      		<tr>
      			<td>Email address</td>
      			<td><input name="<%=Constants.KEY_INPUT_EMAIL %>" type="text" value="${user.emailAddress}"/></td>
      		</tr>
      		<tr>
				<td><input type="submit" value="update"/></td>      		
      		</tr>
		 </table>
      		
	    </form>
	    <br><a href="${urlUpdatePasswordPage}">New password</a>
      </div>
    </body>
</html>