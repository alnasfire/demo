<%--
  Created by IntelliJ IDEA.
  User: alnasfire
  Date: 7/12/16
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<c:url var="addAction" value="/messages/add"/>
<form:form action="${addAction}" commandName="message">
    <label>Message ID</label>
    <input type="text" name="messageid"/>
    <input type="submit" value="<spring:message text="Get Message"/>" />
</form:form>

<br/>
<br/>

<h1>Messages List</h1>

<c:if test="${!empty listMessages}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="320">Body</th>
        </tr>
        <c:forEach items="${listMessages}" var="message">
            <tr>
                <td>${message.id}</td>
                <td>${message.value}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
