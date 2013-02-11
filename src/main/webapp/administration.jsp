<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.CREATE_PROJECTS_LIST_PAGE_CONTROLLER %>" var="urlCreateProjectsListPageController"/>
<c:url value="<%= Constants.CREATE_TYPES_LIST_PAGE_CONTROLLER %>" var="urlCreateTypesListPageController"/>
<c:url value="<%= Constants.CREATE_STATUSES_LIST_PAGE_CONTROLLER %>" var="urlCreateStatusesListPageController"/>
<c:url value="<%= Constants.CREATE_RESOLUTIONS_LIST_PAGE_CONTROLLER %>" var="urlCreateResolutionsListPageController"/>
<c:url value="<%= Constants.CREATE_PRIORITIES_LIST_PAGE_CONTROLLER %>" var="urlCreatePrioritiesListPageController"/>
<c:url value="<%= Constants.CREATE_ADDING_PROJECT_PAGE_CONTROLLER %>" var="urlCreateAddingProjectPageController"/>
<c:url value="<%= Constants.ADDING_TYPE_PAGE %>" var="urlAddingTypePage"/>
<c:url value="<%= Constants.ADDING_PRIORITY_PAGE %>" var="urlAddingPriorityPage"/>
<c:url value="<%= Constants.ADDING_RESOLUTION_PAGE %>" var="urlAddingResolutionPage"/>
<c:url value="<%= Constants.ADDING_PROJECT_PAGE %>" var="urlAddingProjectPage"/>
<c:url value="<%= Constants.ADDING_USER_PAGE%>" var="urlAddingUserPage"/>
<c:url value="<%= Constants.SEARCH_USER_PAGE%>" var="urlSearchUserPage"/>

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
         	<li><a href="${urlCreateProjectsListPageController}">List of projects</a></li>
         	<li><a href="${urlCreateStatusesListPageController}">List of statuses</a></li>
         	<li><a href="${urlCreateResolutionsListPageController}">List of resolutions</a></li>
         	<li><a href="${urlCreatePrioritiesListPageController}">List of priorities</a></li>
         	<li><a href="${urlCreateTypesListPageController}">List of types</a></li>
         </ul>
         <h4>Adding:</h4>
         <ul>
         	<li><a href="${urlCreateAddingProjectPageController}">Project</a></li>
         	<li><a href="${urlAddingResolutionPage}">Resolution</a></li>
         	<li><a href="${urlAddingPriorityPage}">Priority</a></li>
         	<li><a href="${urlAddingTypePage}">Type</a></li>
         </ul>
      	 
      	 <h4>Working with Users:</h4>
      	 <ul>
         	<li><a href="${urlSearchUserPage}">Search user</a></li>
         	<li><a href="${urlAddingUserPage}">Add user</a></li>
         </ul>
      </div>
    </body>
</html>