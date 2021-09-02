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
                Edit Status Update
            </div>

            <div class="card-body">
                <%--                HTML4까지 유효했음 HTML5부터는 modelAttibute 사용--%>
                <%--                <form:form commandName="statusUpdate">--%>

                <form:form modelAttribute="statusUpdate">
                    <%--                    <form:input type="hidden" path="id"></form:input>--%>
                    <form:input type="hidden" path="id"/>
                    <form:input type="hidden" path="added"/>

                    <div class="errors">
                        <form:errors path="text"/>
                    </div>
                    <div class="form-group">
                        <form:textarea path="text" rows="10" cols="50" placeholder="What are you thinking today?"></form:textarea>
                    </div>
                    <div class="submit-button">
                        <input type="submit" name="submit" value="Save" class="btn btn-dark"/>
                    </div>
                </form:form>
            </div>
        </div>

    </div>
</div>
