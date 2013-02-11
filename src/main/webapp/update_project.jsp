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
      			<td>Description2</td>
      			<td><input name="<%=Constants.KEY_DESCRIPTION %>" type="text" value="${project.description}"/></td>
      		</tr>
      		<tr>
      			<td>New build</td>
      			<td><input name="nameNewBuild" type="text"><button name="addBuildButton" type="button">add</button></td>
      		</tr>
      		<tr>
      			<td>Builds</td>
                <td>
                    <select id="buildsId" name="selectBuilds" size=5>
                    </select>
                </td>
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

    <script>
        addEvent(updateProjectForm.addBuildButton, "click", function() {
            var selBuilds = updateProjectForm.selectBuilds;
            selBuilds.options[selBuilds.options.length] = new Option(updateProjectForm.nameNewBuild.value, -1);
            updateProjectForm.builds.value = JSON.stringify(convertSelectToArray(updateProjectForm.selectBuilds.options), ['text','value']);
        });
    </script>
</body>
</html>