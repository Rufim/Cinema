<%--
  Created by IntelliJ IDEA.
  User: Rufim
  Date: 05.04.12
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/view/jsp/include-tags.jsp" %>
<form:form method="POST"  commandName="settings" >
    <fieldset class="my-fieldset"><legend>Settings</legend>
        <div id="left">
            <p>
                <label class="label" for="uname">Username</label>
                <form:input id="uname" path="uname" value="${settings.uname}" cssClass="input" maxlength="50" cssErrorClass="inputError"  tabindex="1"/>
                <form:errors path="uname" cssClass="error" element="div"/>
            </p>
            <p>
                <label class="label" for="password">Password</label>
                    <form:password path="password" id="password" value="${settings.password}" cssClass="input" cssErrorClass="inputError" maxlength="50" tabindex="2"/>
                    <form:errors path="password" cssClass="error" element="div"/>
            <p>
            <p>
                <label class="label" for="hostName">HostName</label>
                    <form:input path="hostName" id="hostName" value="${settings.hostName}" cssClass="input" cssErrorClass="inputError" maxlength="15" tabindex="3"/>
                    <form:errors path="hostName" cssClass="error" element="div"/>
            <p>
            <p>
                <label class="label" for="port">Port</label>
                    <form:input path="port" id="port" value="${settings.port}" cssClass="input" cssErrorClass="inputError" maxlength="4" tabindex="4"/>
                    <form:errors path="port" cssClass="error" element="div"/>
            <p>
                <input style="margin-left:0;" type="submit" value="Test Connection"  class="ui-button"/>
            </p>
            <p>
                <c:choose>
                    <c:when test="${err eq 0}">
                       <span class="success"> <spring:message  code="connection.success"/></span>
                    </c:when>
                    <c:when test="${err eq 1}">
                       <span class="error" > <spring:message  code="connection.error"/></span>
                    </c:when>
                </c:choose>
            </p>
        </div>
    </fieldset>
</form:form>