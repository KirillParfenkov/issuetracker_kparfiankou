<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.SUBMIT_ISSUE_CONTROLLER %>" var="urlSubmitInserController"/>

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
	  	<div class=error> <c:out value="${errorMesage}"></c:out></div>
	  </c:if>

      <div id=main>
        <form name="submitIssueForm" method=POST action="${urlSubmitInserController}">
        	<table>
        		<tr>
        			<td>Summary</td>
        			<td><input type="text" name="<%=Constants.KEY_SUMMARY%>"></td>
        		</tr>
        		<tr>
        			<td>Description</td>
        			<td><textarea rows="5" cols="45" name="<%=Constants.KEY_DESCRIPTION%>"></textarea></td>
        		</tr>
        		<tr>
        			<td>Status</td>
        			<td><m:select name="<%=Constants.KEY_STATUS%>" elements="<%=Constants.STATUSES%>"/></td>
				</tr>
				<tr>
        			<td>Type</td> 
        			<td><m:select name="<%=Constants.KEY_TYPE%>" elements="<%=Constants.TYPES%>"/></td>
				</tr>
        		<tr>
        			<td>Priority</td>
        			<td><m:select name="<%=Constants.KEY_PRIORITY%>" elements="<%=Constants.PRIORITYS%>"/></td>
        		</tr>
        		<tr>
        			<td>Project</td>
        			<td><m:select id="projectSelect" name="<%=Constants.KEY_PROJECT%>" elements="<%=Constants.PROJECTS%>"/></td>
        		</tr>
        		<tr class="nascent" id="buildSelect" >
        			<td>Build</td> 
        			<td>
        				<select name="<%=Constants.KEY_BUILD%>">
        				<c:forEach var="build" items="${projects[0].builds}">
        					<option value="${build.id}">${build}</option>
        				</c:forEach>
        				</select>
        			</td>
        		</tr>
        		<tr>
        			<td>Assignee</td>
        			<td><m:select name="<%=Constants.KEY_ASSIGNEE%>" elements="<%=Constants.USERS%>"/></td>
        		</tr>
        		<tr><td><input type="submit" value="add"></td></tr>
        	</table>
        </form>
      </div>
    </body>
</html>

<script>
	var elem = document.getElementById("projectSelect");
	elem.addEventListener("change",showBuilds);
</script>