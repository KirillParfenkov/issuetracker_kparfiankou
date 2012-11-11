<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.LOGOUT_CONTROLLER %>" var="urlLogoutController"/>
<c:url value="<%= Constants.SUBMIT_ISSUE_CONTROLLER %>" var="urlSubmitController"/>

  <c:if test="${empty user}">
  	<form name=headerForm method=POST action="${urlLoginController}" >
  		<span>Email </span>
  		<input class=hElem type=text name="<%= Constants.KEY_INPUT_EMAIL %>">
  		<span>Password </span>
  		<input class=hElem type=password name="<%= Constants.KEY_INPUT_PASSWORD %>">
  		<input class=hElem type=submit value="sign in">
  	</form>
  </c:if>

  <c:if test="${not empty user}">
  	<c:out value="Hi, ${user.firstName}  ${user.lastName}"></c:out>
  	<a class=hElem href="${urlLogoutController}">Logout</a>
  	<a class=hElem href="${urlSubmitController}">Add Issue</a>

  </c:if>
  
	
			
	
	
	

