<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.INSERT_UPDATE_STATUS_CONTROLLER %>" var="urlInsertUpdateStatusController"/>

<html>
  <head>
      <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>Details of the type</title>
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
       <form name="updateStatusForm"  method="POST" action="${urlInsertUpdateStatusController}">
        <input type="hidden" name="statusId" value="${status.id}">
      	<table>
      		<tr>
      			<td>Name</td>
      			<td><input name="<%=Constants.KEY_NAME %>" type="text" value="${status.name}"/></td>
      		</tr>
      		<tr>
				<td><input type="submit" value="update"/></td>
      		</tr>
		</table>
	   </form>
      </div>
    </body>
</html>