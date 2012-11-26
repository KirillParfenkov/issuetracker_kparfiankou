<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.CREATE_UPDATE_PRIORITY_CONTROLLER %>" var="urlCreateUpdatePriorityController"/>

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
       <form name="listPriorityForm"  method=POST action="${urlCreateUpdatePriorityController}">
        <input type=hidden name=<%= Constants.KEY_PRIORITY_ID %> value="">
      	<table>
      		<tr class=head>
      			<td>Priority name</td>
      		</tr>
      		<c:forEach var="priority" items="${priorities}">
      		 	<tr>
      		 		<td>
      		 			<a href="JavaScript:document.listPriorityForm.submit()" 
					   	   onclick="listPriorityForm.priorityId.value = ${priority.id}">
						   ${priority.name}
						</a>
					</td>
      			</tr>
      		</c:forEach>
      	</table>
       </form>
      </div>
    </body>
</html>