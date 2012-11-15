<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.LOGOUT_CONTROLLER %>" var="urlLogoutController"/>
<c:url value="<%= Constants.SUBMIT_ISSUE_CONTROLLER %>" var="urlSubmitInserController"/>
<c:url value="<%= Constants.SUBMIT_CREATE_CONTROLLER %>" var="urlSubmitCreateController"/>
<c:url value="<%= Constants.MAIN_CONTROLLER %>" var="urlMainController"/>
<c:url value="<%= Constants.CREATE_ADMINISTRATION_PAGE_CONTROLLER %>" var="urlCreateAdministrationPageController"/>
<c:url value="<%= Constants.CREATE_PROFILE_PAGE_CONTROLLER %>" var="urlCreateProfilePageController"/>
<c:url value="<%= Constants.CREATE_SEARCH_PAGE_CONTROLLER %>" var="urlCreateSearchPageController"/>


  <a class=hElem href="${urlMainController}">Main</a>
  <a class=hElem href="${urlCreateSearchPageController}">Search</a>

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
  	<a class=hElem href="${urlSubmitCreateController}">Submit Issue</a>
  	<a class=hElem href="${urlCreateProfilePageController}">Profile</a>
  	<a class=hElem href="${urlCreateAdministrationPageController}">Administration</a>
  </c:if>
