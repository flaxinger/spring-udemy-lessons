<%--
  Created by IntelliJ IDEA.
  User: FLAXINGER
  Date: 2021-08-25
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jwp"%>


<%--param gets the parameter--%>
<%--Page number: ${param.p}--%>

<c:url var="url" value="/viewstatus"/>

<div class="row">
    <fmt:setLocale value="en"/>
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                Recent Status
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col" class = "status-list-id">#</th>
                        <th scope="col" class = "status-list-status">Status</th>
                        <th scope="col" class = "status-list-date">Date</th>
                        <th scope="col" class = "status-list-edit">Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="statusUpdate" items="${page.content}">
                            <c:url var="editLink" value="/editstatus?id=${statusUpdate.id}"/>
                            <c:url var="deleteLink" value="/deletestatus?id=${statusUpdate.id}"/>
                            <tr>
                            <th scope="row" class = "status-list-id">${statusUpdate.id}</th>
                            <td class = "status-list-status"><c:out value="${statusUpdate.text}"></c:out></td>
                            <td class = "status-list-date"><c:out value="${statusUpdate.added}"></c:out></td>
                            <td class = "status-list-edit">
                                <div>
                                    <a href="${editLink}" class="btn btn-light edit-btn">edit</a> | <a onclick="return confirm('This status may not be retrieved')" href="${deleteLink}" class="btn btn-light edit-btn">delete</a>
                                </div>
                            </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <jwp:pagination page="${page}" url="${url}"></jwp:pagination>
            </div>

        </div>

    </div>
</div>