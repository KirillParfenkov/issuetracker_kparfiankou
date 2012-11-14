<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.SUBMIT_ISSUE_CONTROLLER %>" var="urlSubmitInserController"/>
<c:url value="<%= Constants.INSERT_UPDATE_ISSUE_CONTROLLER %>" var="urlInsertUpdateIssueController"/>


<html>
  <head>
      <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>Details of the issue</title>
      <script src="javascript/functions.js"></script>
  </head>
    <body>
   	  <div id="header">
	  	<jsp:include page="<%= Constants.HEADER_PAGE %>"/>
	  </div>

	  <c:if test="${not empty errorMessage}">
	  	<div class=error> <c:out value="${errorMesage}"></c:out></div>
	  </c:if>

      <div id=main>
         <table>
        	<tr>
        		<td>Id</td>
        		<td>${issue.id}</td>
        	</tr>
        	<tr>
        		<td>Create date</td>
        		<td>${issue.createDate}</td>
        	</tr>
        	<tr>
        		<td>Create by</td>
        		<td>${issue.creater}</td>
        	</tr>
        	<tr>
        		<td>Modify date</td>
        		<td>${issue.modifyDate}</td>
        	</tr>
        	<tr>
        		<td>Modified by</td>
        		<td>${issue.lastModifier}</td>
        	</tr>
        	<tr>
        		<td>Summary</td>
        		<td><input name="<%=Constants.KEY_SUMMARY%>" type="text" size="45" value="${issue.summary}"/></td>
        	</tr>
        	<tr>
        		<td>Description</td>
        		<td><textarea rows="5" cols="45" name="<%=Constants.KEY_DESCRIPTION%>">${issue.description}</textarea></td>
        	</tr>
        	<tr>
        		<td>Status</td>
        		<td>${issue.status}</td>
        	</tr>
        	<tr>
        		<td>Type</td>
        		<td>${issue.type}</td>
        	</tr>
        	<tr>
        		<td>Priority</td>
        		<td>${issue.priority}</td>
        	</tr>
        	<tr>
        		<td>Project</td>
        		<td>${issue.project}</td>
        	</tr>
        	<tr>
        		<td>Build found</td>
        		<td>${issue.build}</td>
        	</tr>
        	<tr>
        		<td>Assignee</td>
        		<td>${issue.assignee}</td>
        	</tr>
        	<tr>
        		<td>Resolution</td>
        		<td>${issue.resolution}</td>
        	</tr>
         </table>
      </div>
    </body>
</html>
