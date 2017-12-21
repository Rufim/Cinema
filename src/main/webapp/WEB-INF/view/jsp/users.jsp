<%--
  Created by IntelliJ IDEA.
  User: Rufim
  Date: 29.03.12
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/view/jsp/include-tags.jsp" %>
<fieldset class="my-fieldset" style=" margin-left: 100px; margin-top:  60px;"><legend>Users Details</legend>
<table style="margin-top: 20px; margin-left: 20px; width: 100%; border-collapse: inherit;"  cellspacing="0" cellpadding="4">
    <c:forEach items="${users}" var="user">
        <tr>
            <td style="border-top: #68727B solid; border-top-left-radius: 1em; padding: 20px; ">
                <table>
                    <tr><td>First Name : ${user.fname}</td></tr>
                    <tr><td>Last Name : ${user.lname}</td></tr>
                    <tr><td>Gender : ${user.gender}</td> </tr>
                    <tr><td>Email : ${user.email}</td></tr>
                    <tr><td>Birth Year : ${user.birthYear}</td></tr>
                </table>
            </td>
            <td style="border-top: #68727B solid;  border-top-right-radius: 8em; padding: 20px;">
                <label class="label" for="photo">Photo:</label>
                <c:catch>
                    <c:choose>
                        <c:when test="${not empty user.photoBase64}">
                            <img id="photo" src="data:image/jsp;base64,${user.photoBase64}"  class="border" style="width: 120px; height: 120px;"/>
                        </c:when>
                        <c:otherwise>
                            <span id="photo" style="width: 120px; height: 120px;">Empty</span>
                        </c:otherwise>
                   </c:choose>
                </c:catch>
            <td>
        </tr>
    </c:forEach>
</table>
</fieldset>