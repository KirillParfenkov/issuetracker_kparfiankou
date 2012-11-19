<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.CREATE_UPDATE_PROJECT_CONTROLLER %>" var="urlCreateUpdateProjectController"/>

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
       <form name="listProjectForm"  method=POST action="${urlCreateUpdateProjectController}">
        <input type=hidden name=<%= Constants.KEY_PROJECT_ID %> value="">
      	<table>
      		<tr class=head>
      			<td>Name</td>
      			<td>Manager</td>
      			<td>Description</td>
      		</tr>
      		<c:forEach var="project" items="${projects}">
      		 	<tr>
      		 		<td>
      		 			<a href="JavaScript:document.listProjectForm.submit()" 
					   	   onclick="listProjectForm.projectId.value = ${project.id}">
						   ${project.name}
						</a>
					</td>
      				<td>${project.manager}</td>
      				<td>${project.description}</td>
      			</tr>
      		</c:forEach>
      	</table>
       </form>
      </div>
    </body>
</html>