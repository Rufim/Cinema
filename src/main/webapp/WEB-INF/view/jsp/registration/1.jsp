<%--
  Created by IntelliJ IDEA.
  User: Rufim
  Date: 29.03.12
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/view/jsp/include-tags.jsp" %>
<form:form method="POST"  commandName="registrationCommand" ng-submit="submit()">
<fieldset class="my-fieldset" ><legend>Registration</legend>
     <div id="left">
        <p>
            <label class="label" for="email">E-mail</label>
            <form:input id="email" path="email" value="${registrationCommand.email}" cssClass="input" maxlength="50" cssErrorClass="inputError"  tabindex="1"/>
            <form:errors path="email" cssClass="error" element="div"/>
        </p>
        <p>
            <label class="label" for="password">Password</label>
            <form:password path="password" id="password" value="${registrationCommand.password}" cssClass="input" cssErrorClass="inputError" maxlength="50" tabindex="2"/>
            <form:errors path="password" cssClass="error" element="div"/>
        <p>
            <label class="label" for="confurmpassword">Confirm Password</label>
            <form:password path="confurmpassword" id="confurmpassword" value="${registrationCommand.confurmpassword}" cssErrorClass="inputError" cssClass="input" maxlength="20" tabindex="3"/>
            <form:errors path="confurmpassword" cssClass="error" element="div"/>
        </p>
        <p>
            <form:input path="direction" style="margin-left:0;" type="submit" value="Next"  cssClass="ui-button"/>
        </p>
     </div>
 </fieldset>
</form:form>
