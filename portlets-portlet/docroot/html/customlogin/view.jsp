<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<portlet:actionURL var="loginURL" name="Login" secure="false"></portlet:actionURL>
<aui:form method="post" action="<%=loginURL%>">
<aui:input name="username" type="text"></aui:input>
<aui:input name="password" type="password"></aui:input>
<aui:button name="login" type="submit"></aui:button>
</aui:form>


