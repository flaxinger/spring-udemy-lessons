<%--
  Created by IntelliJ IDEA.
  User: FLAXINGER
  Date: 2021-08-26
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="row">
    <fmt:setLocale value="en"/>
    <div class="col-md-8">

<%--        Request statusUpdate attibute: <%= request.getAttribute("statusUpdate")%><br/>--%>
<%--        JSP object: <%= this %><br/>--%>
<%--        JSP class: <%= this.getClass()%><br/>--%>

        <div class="card card-add-status">
            <div class="card-header">
                Add a Status Update
            </div>

            <div class="card-body">
<%--                HTML4까지 유효했음 HTML5부터는 modelAttibute 사용--%>
<%--                <form:form commandName="statusUpdate">--%>

                <form:form modelAttribute="statusUpdate">
<%--                    <form:input type="hidden" path="id"></form:input>--%>
                    <div class="errors">
                        <form:errors path="text"/>
                    </div>
                    <div class="form-group">
                        <form:textarea path="text" rows="10" cols="50" placeholder="What are you thinking today?"></form:textarea>
<%--                        <form:textarea path="text"></form:textarea>--%>
                    </div>
                    <div class="submit-button">
                        <input type="submit" name="submit" value="Add Status" class="btn btn-dark"/>
                    </div>
                </form:form>
            </div>

<%--            <ul class="list-group list-group-flush">--%>
<%--                <li class="list-group-item">An item</li>--%>
<%--                <li class="list-group-item">A second item</li>--%>
<%--                <li class="list-group-item">A third item</li>--%>
<%--            </ul>--%>
        </div>

    </div>
    <div class="col-md-1">
        <div class="card latest-status">
            <div class="card-header">
                <fmt:setLocale value="en_US" />
                <div class="card-title">Current status update added on:<br> <fmt:formatDate pattern="yyyy'년' MM'월' dd'일' EEEE H:mm:ss" value="${latestStatusUpdate.added}"/></div>
            </div>
            <div class="card-body">
                <div class="card-title"><c:out value="${latestStatusUpdate.text}"/></div>
            </div>
        </div>
    </div>
</div>

<%--<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>--%>
<%--<script>--%>

<%--    document.addEventListener('focusin', function (e) { if (e.target.closest('.tox-tinymce-aux, .moxman-window, .tam-assetmanager-root') !== null) { e.stopImmediatePropagation(); } });--%>
<%--    tinymce.init({--%>
<%--        selector: 'textarea'--%>
<%--    });--%>

<%--</script>--%>

