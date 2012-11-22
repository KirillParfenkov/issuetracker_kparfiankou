<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.CREATE_PROJECTS_LIST_PAGE_CONTROLLER %>" var="urlCreateProjectsListPageController"/>

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

      	 <h4>Looking:</h4>
         <ul>
         	<li><a href="${urlCreateProjectsListPageController}">List of projects</a> <br></li>
         	<li>List of statuses</li>
         	<li>List of resolutions</li>
         	<li>List of priorities</li>
         	<li>List of types</li>
         </ul>
         <h4>Adding:</h4>
         <ul>
         	<li>Project</a> <br></li>
         	<li>Resolution</li>
         	<li>Priority</li>
         	<li>Type</li>
         </ul>
      	 
      	 <h4>Working with Users:</h4>
      	 <ul>
         	<li>Search user</a> <br></li>
         	<li>Add user</li>
         </ul>
      </div>
    </body>
</html>