<%--
  Created by IntelliJ IDEA.
  User: Rufim
  Date: 29.03.12
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/view/jsp/include-tags.jsp" %>
<script language="JavaScript">
    function HideLoad()
    {
        var image =document.getElementById("photo").value;
        if(image!=''){
            document.getElementById("Load").style.display = "none";
        } else{
            document.getElementById("Load").style.display = "block";
            document.getElementById("Load").style.marginLeft = 0;
            document.getElementById("Load").style.marginTop = "10px";
        }
    }

</script>
<form:form method="POST" enctype="multipart/form-data" commandName="registrationCommand">
<fieldset class="my-fieldset"><legend>Registration</legend>
    <div id="left">
        <p>
            <label class="label" for="languages">Languages :</label>
                <form:select path="languages" id="languages">
                    <form:option value="C++" label="C++" />
                    <form:option value="C#" label="C#" />
                    <form:option value="Java" label="Java" />
                    <form:option value="PHP" label="PHP" />
                </form:select>
        </p>
        <p> 
            <label class="label" for="aboutYou"> About you :</label>
            <form:textarea path="aboutYou" id="aboutYou"  cols="32" rows="8"/>
            <form:errors path="aboutYou" cssClass="error" element="div"/>
        </p>
        <p>
            Hobby :
                <form:checkbox path="hobby" value="Spring" label="Spring" />
                <form:checkbox path="hobby" value="Hibernate" label="Hibernate" />
                <form:checkbox path="hobby" value="Struts" label="Struts" />
        </p>
        <p>
            Photo :          
              <form:input path="photo" id="photo"  type="file"/>
              <form:input path="direction" id="Load"  type="submit" value="Load" class="ui-button"/>  <br/>
        <c:catch>
            <c:if test="${null != errors}">
              <h style="margin-top: 5px; color: #ff0000;">${errors}</h>
            </c:if>
        </p>
            <c:if test="${null != filename}">
                <p>
                    <label class="label" for="photo">Current photo:</label>
                    <img id="photo" src="data:image/jsp;base64,${registrationCommand.photoBase64}"  class="border" />
                </p>
            </c:if>
        </c:catch>
        <form:errors path="photo" cssClass="error" element="div"/>
        <p>
            <form:input path="direction" type="submit" value="Back" cssClass="ui-button"/>
            <form:input path="direction" type="submit" value="Create an Account" cssClass="ui-button"/>
        </p>
        <p>
            <c:if test="${reg eq 1}">
                <span class="success"> <spring:message  code="reg.success"/></span>
            </c:if>
        </p>
    </div>
</fieldset>
</form:form>