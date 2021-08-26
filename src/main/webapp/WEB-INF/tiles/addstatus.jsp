<%--
  Created by IntelliJ IDEA.
  User: FLAXINGER
  Date: 2021-08-26
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="card">
            <div class="card-header">
                Add a Status Update
            </div>
            <div class="card-body">
                <form>
                    <div class="form-group">
                        <textarea name="text" rows="10" cols="50"></textarea>
                    </div>
                    <div class="submit-button">
                        <input type="submit" name="submit" value="Add Status" class="btn btn-dark"/>
                    </div>
                </form>
            </div>
<%--            <ul class="list-group list-group-flush">--%>
<%--                <li class="list-group-item">An item</li>--%>
<%--                <li class="list-group-item">A second item</li>--%>
<%--                <li class="list-group-item">A third item</li>--%>
<%--            </ul>--%>
        </div>
    </div>
</div>
