<%--
  Created by IntelliJ IDEA.
  User: FLAXINGER
  Date: 2021-08-25
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<tiles:insertAttribute name="content" />
</body>
</html>
