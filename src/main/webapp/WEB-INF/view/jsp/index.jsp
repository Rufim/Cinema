<%--
  Created by IntelliJ IDEA.
  User: Rufim
  Date: 05.04.12
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/view/jsp/include-tags.jsp" %>
<html lang="en" ng-app="CinemaApp">
<head>
  <base href="/">
  <!--[if IE]>
  <style type="text/css" >
    legend {
      height: 0;
      margin: 0;
      padding: 0;
      width: 0;
    }
  </style>
  <![endif]-->
  <style type="text/css">
    li {
      list-style-type: none;
      padding: 0px;
      margin: 0px;
      display: inline-block;
    }
  </style>
  <title>Menu</title>
  <%@ include file="/WEB-INF/view/jsp/include-header.jsp" %>
</head>
<body>
<form method="POST">
  <c:if test="${null != errors}">
    <span class="errorblock">${errors}</span>
  </c:if>
  <fieldset class="my-fieldset menu-fieldset" style="width: 1100px">
    <legend>Menu</legend>
    <ul id="left">
      <li style="margin-bottom: 40px">
        <a href="/registration/1" class="ui-button">Registration</a>
      </li>

      <li style="margin-bottom: 40px">
        <a href="/users" class="ui-button">Show All Users</a>
      </li>

      <li style="margin-bottom: 40px">
        <a href="/cinema" class="ui-button">Cinema</a>
      </li>

      <li style="margin-bottom: 40px">
        <a href="/settings" class="ui-button">Database Settings</a>
      </li>
    </ul>
  </fieldset>
</form>
<div ng-view></div>
<%@ include file="/WEB-INF/view/jsp/include-footer.jsp" %>
</body>
</html>