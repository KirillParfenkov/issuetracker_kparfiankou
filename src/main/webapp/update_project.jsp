<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>
<c:url value="<%= Constants.SUBMIT_ISSUE_CONTROLLER %>" var="urlSubmitInserController"/>
<c:url value="<%= Constants.INSERT_UPDATE_PROJECT_CONTROLLER %>" var="urlInsertUpdateProjectController"/>

<c:set var="pageBuilds" value="${project.builds}" scope="page"></c:set>

<html>
  <head>
      <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>Details of the issue</title>
      <script src="javascript/functions.js"></script>
      <script>
		alert(${project.id});
		function attachValues(){
			updateProjectForm.projectId.value = ${project.id};
			updateProjectForm.builds.value = builds.options;
		}
		attachValues();
		alert("");
	  </script>
  </head>
    <body>
   	  <div id="header">
	  	<jsp:include page="<%=Constants.HEADER_PAGE %>"/>
	  </div>

	  <c:if test="${not empty errorMessage}">
	  	<div class=error> <c:out value="${errorMesage}"></c:out></div>
	  </c:if>

      <div id=main>
       <form name="updateProjectForm"  method="POST" action="${urlInsertUpdateProjectController}">
        <input type="hidden" name="projectId" value="${project.id}">
        <input type="hidden" name="builds" value="">
      	<table>
      		<tr>
      			<td>Name</td>
      			<td><input name="<%=Constants.KEY_NAME %>" type="text" value="${project.name}"/></td>
      		</tr>
      		<tr>
      			<td>Description</td>
      			<td><input name="<%=Constants.KEY_DESCRIPTION %>" type="text" value="${project.description}"/></td>
      		</tr>
      		<tr>
      			<td>New build</td>
      			<td><input type="text"><button>add</button></td>
      		</tr>
      		<tr>
      			<td>Builds</td>
      			<td><m:select name="<%=Constants.KEY_BUILDS%>" elements="pageBuilds"/></td>
      		</tr>
      		<tr>
      			<td>Manager</td>
				<td><m:select name="<%=Constants.KEY_MANAGER%>" elements="<%=Constants.MANAGERS%>" selectedId="${project.manager.id}"/></td>      		
      		</tr>
      		<tr>
				<td><input type="submit" value="update" onclick="updateProjectForm.projectId.value = ${issue.id};"/></td>      		
      		</tr>
		</table>
	   </form>
      </div>
    </body>
</html>