<%--
  Created by IntelliJ IDEA.
  User: Rufim
  Date: 29.03.12
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/view/jsp/include-tags.jsp" %>
<form:form method="POST" commandName="registrationCommand" >
<fieldset class="my-fieldset"><legend>Registration</legend>
    <div id="left">
        <p>
            First Name :
            <form:input path="fname" value="${registrationCommand.fname}" cssErrorClass="inputError"/>
            <form:errors path="fname" cssClass="error" element="div"/>
        </p>
        <p>
            Last Name :
            <form:input path="lname" value="${registrationCommand.lname}" />
            <form:errors path="lname" cssClass="error" element="div"/>
        </p>
        <p>
            Gender :
            
                <form:radiobutton path="gender" value="M" label="M" />
                <form:radiobutton path="gender" value="F" label="F" />
            
            <form:errors path="gender" cssClass="error" element="div"/>
        </p>
        <p>
            Birth date :
            
                <form:select path="birthDay">
                   <form:option value="1" label="1"/>
                   <c:forEach var="i" begin="2" end="31">
                       <form:option value="${i}" label="${i}" />
                   </c:forEach>
                </form:select>
                <form:select path="birthMonth">
                    <form:option value="1" label="1" />
                    <c:forEach var="i" begin="2" end="12">
                        <form:option value="${i}" label="${i}" />
                    </c:forEach>
                </form:select>
                <form:select path="birthYear" >
                    <c:forEach var="i" begin="1920" end="1969">
                        <form:option value="${i}" label="${i}" />
                    </c:forEach>
                    <form:option value="1970" label="1970" selected="true" />
                    <c:forEach var="i" begin="1971" end="2020">
                        <form:option value="${i}" label="${i}" />
                    </c:forEach>
                </form:select>
            
            <form:errors path="birthYear" cssClass="error" element="div"/>
        </p>
        <p>
            <form:input path="direction" type="submit" value="Back" cssClass="ui-button"/>
            <form:input path="direction" type="submit" value="Next" cssClass="ui-button"/>
        </p>
    </div>
</fieldset>
</form:form>