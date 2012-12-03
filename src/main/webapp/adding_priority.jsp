<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/m.tld" prefix="m"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.INSERT_ADDING_SIMPLE_ENTITY_CONTROLLER %>" var="urlInsertAddingSimpleEntityController"/>

<html>
  <head>
      <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>New priority</title>
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
       <form name="addingPriorityForm"  method="POST" action="${urlInsertAddingSimpleEntityController}">
        <input type="hidden" name="typeEntity" value="PRIORITY">
      	<table>
      		<tr>
      			<th>Create new priority</th>
      		</tr>
      		<tr>
      			<td>Name</td>
      			<td><input name="<%=Constants.KEY_NAME %>" type="text" value=""/></td>
      		</tr>
      		<tr>
				<td><input type="submit" value="add"/></td>      		
      		</tr>
		</table>
	   </form>
      </div>
    </body>
</html>