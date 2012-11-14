<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.CREATE_UPDATE_ISSUE_CONTROLLER %>" var="urlCreateUpdateIssueController"/>

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
       <form name="listIssueForm"  method="POST" action="${urlCreateUpdateIssueController}">
       	<input type=hidden name=<%= Constants.KEY_ISSUE_ID %> value="">
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
          		<td> 
          			<a href="JavaScript:document.listIssueForm.submit()" 
					   onclick="listIssueForm.issueId.value = ${issue.id}">
						${issue.id}
					</a>
				</td>
          		<td> ${issue.priority} </td>
          		<td> ${issue.assignee} </td>
          		<td> ${issue.type} </td>
          		<td> ${issue.status} </td>
          		<td> ${issue.summary}</td>
          	</tr>
          </c:forEach>
        </table>
       </form>
      </div>
    </body>
</html>