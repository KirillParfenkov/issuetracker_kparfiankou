<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.SUBMIT_ISSUE_CONTROLLER %>" var="urlSubmitInserController"/>
<c:url value="<%= Constants.INSERT_UPDATE_ISSUE_CONTROLLER %>" var="urlInsertUpdateIssueController"/>
<c:url value="<%= Constants.INSERT_COMMENT_CONTROLLER %>" var="urlInsertCommentController"/>

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
      	<form name="updateIssueForm" method=POST action="${urlInsertUpdateIssueController}">
      	 <input type=hidden name=<%= Constants.KEY_ISSUE_ID %> value="${issue.id}">
      	 <input type=hidden name=<%= Constants.KEY_CREATE_DATE %> value="${issue.createDate}">
      	 <input type=hidden name=<%= Constants.KEY_CREATER_ID %> value="${issue.creater.id}">
      	 <input type=hidden name=<%= Constants.KEY_MODIFY_DATE %> value="${issue.modifyDate}">
      	 <input type=hidden name=<%= Constants.KEY_MODIFIER_ID %> value="${issue.lastModifier.id}">
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
        		<td><m:select name="<%=Constants.KEY_STATUS%>" elements="<%=Constants.STATUSES%>" selectedId="${issue.status.id}" /></td>
        	</tr>
        	<tr>
        		<td>Type</td>
        		<td><m:select name="<%=Constants.KEY_TYPE%>" elements="<%=Constants.TYPES%>" selectedId="${issue.type.id}" /></td>
        	</tr>
        	<tr>
        		<td>Priority</td>
        		<td><m:select name="<%=Constants.KEY_PRIORITY%>" elements="<%=Constants.PRIORITYS%>" selectedId="${issue.priority.id}" /></td>
        	</tr>
        	<tr>
        		<td>Project</td>
        		<td><m:select name="<%=Constants.KEY_PROJECT%>" elements="<%=Constants.PROJECTS%>" selectedId="${issue.project.id}" /></td>
        	</tr>
        	<tr>
        		<td>Build found</td>
        		<td>${issue.build}</td>
        	</tr>
        	<tr>
        		<td>Assignee</td>
        		<td><m:select name="<%=Constants.KEY_ASSIGNEE%>" elements="<%=Constants.USERS%>" selectedId="${issue.assignee.id}" /></td>
        	</tr>
        	<tr>
        		<td>Resolution</td>
        		<td><m:select name="<%=Constants.KEY_RESOLUTION%>" elements="<%=Constants.RESOLUTIONS%>" selectedId="${issue.resolution.id}" /></td>
        	</tr>
         </table>
         <input type="submit" value="update">
        </form>

        <c:forEach var="comment" items="${comments}">
        	<table class="commentTable">
        		<tr>
        			<td>Added by: ${comment.autor}</td>
        		</tr>
        		<tr>
        			<td>Add date: ${comment.addDate}</td>
        		</tr>
        		<tr>
        			<td class="underlined">${comment.content}</td>
        		</tr>
			</table>
			<br>
        </c:forEach>

        <form name="commentIssueForm" method=POST action="${urlInsertCommentController}">
        	<input type=hidden name=<%= Constants.KEY_ISSUE_ID %> value="${issue.id}">
        	<table>
        		<tr>
        			<td><textarea rows="5" cols="45" name="<%=Constants.KEY_CONTENT%>"></textarea></td>
        		</tr>
        		<tr><td><input type="submit" value="comment"></td></tr>
        	</table>
        </form>
      </div>
    </body>
</html>