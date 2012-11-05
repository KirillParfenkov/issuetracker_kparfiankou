<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>

<form name=headerForm method=POST action="${urlLoginController}" >
  <span>Email </span>
  <input class=hElem type=text name="email">
  <span>Password </span>
  <input class=hElem type=password name="pass">
  <input class=hElem type=submit value="sign in">
</form>
