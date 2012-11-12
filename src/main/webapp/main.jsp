<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>

<html>
  <head>
    <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>Main</title>
  </head>
    <body>
   	  <div id="header">
			<jsp:include page="<%= Constants.HEADER_PAGE %>"/>
	  </div>

	  <c:if test="${not empty errorMessage}">
	  	<div class=error> <c:out value="${errorMessage}"></c:out></div>
	  </c:if>

      <div id=main>
        <table>
          <tr class=head>
            <td>Id</td>
            <td>Priority</td>
            <td>Assignee</td>
            <td>Type</td>
            <td>Status</td>
            <td>Summary</td>
          </tr>
          <c:forEach var="issue" items="${issues}">
          	<tr>
          		<td> <c:out value="${issue.id}"/> </td>
          		<td> <c:out value="${issue.priority}"/> </td>
          		<td> <c:out value="${issue.assignee}"/> </td>
          		<td> <c:out value="${issue.type}"/> </td>
          		<td> <c:out value="${issue.status}"/> </td>
          		<td> <c:out value="${issue.summary}"/> </td>
          	</tr>
          </c:forEach>
        </table>
      </div>
    </body>
</html>