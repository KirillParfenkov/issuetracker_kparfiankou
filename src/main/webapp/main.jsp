<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="org.training.kparfiankou.issuetracker.Constants"%>

<c:url value="<%= Constants.HEADER_PAGE %>" var="urlHeaderPageJSP"/>
<c:url value="<%= Constants.LOGIN_CONTROLLER %>" var="urlLoginController"/>

<html>
  <head>
    <meta hhtp-equiv='Content-Type' content='text/html' charset='utf-8'>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <title>Main</title>
  </head>
    <body>
   	  <div id="header">
			<jsp:include page="<%= Constants.HEADER_PAGE %>"/>
	  </div>
      <div id=main>
        <table>
          <tr class=head>
            <td>Id</td>
            <td>Priority</td>
            <td>Assignee</td>
            <td>Type</td>
            <td>Status</td>
            <td>Summary</td>
          </tr>
        </table>
      </div>

    </body>
</html>
