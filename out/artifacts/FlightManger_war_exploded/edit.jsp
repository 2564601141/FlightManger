<%--
  Created by IntelliJ IDEA.
  User: 南球
  Date: 2021/9/5
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改航班信息</strong></div>
    <div class="body-content">
<%--跳转页面的地址--%>
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/updateFlightServlet">
            <div class="form-group">
                <div class="label">
                    <label> 序号:</label>
                </div>
                <div class="field">
                    <input type="text" class="input " name="fid" value="${flt1.fid}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label> 航班号:</label>
                </div>
                <div class="field">
                    <input type="text" class="input " name="flightNo" value="${flt1.flightNo}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label> 起飞城市:</label>
                </div>
                <div class="field">
                    <input type="text" class="input " name="departureCity" value="${flt1.departureCity}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>抵达城市:</label>
                </div>
                <div class="field">
                    <input type="text" class="input " name="arrivalCity"value="${flt1.arrivalCity}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>起飞时间:</label>
                </div>
                <div class="field">
                    <input type="text" class="input " name="departureTime" value="${flt1.departureTime}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>达到时间:</label>
                </div>
                <div class="field">
                    <input type="text" class="input " name="arrivalTime" value="${flt1.arrivalTime}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <input type="submit" value="修改">
                </div>
            </div>
        </form>
    </div>
</div>
</body></html>
<%--  隐藏字段  --%>
<%--    <input type="hidden" name="fid" value="${flt1.fid}">--%>
<%--    航班号:<input type="text" name="flightNo" value="${flt1.flightNo}"><br>--%>
<%--    起飞城市:<input type="text" name="departureCity" value="${flt1.departureCity}"><br>--%>
<%--    抵达城市:<input type="text" name="arrivalCity"value="${flt1.arrivalCity}"><br>--%>
<%--    起飞时间:<input type="text" name="departureTime" value="${flt1.departureTime}"><br>--%>
<%--    达到时间:<input type="text" name="arrivalTime" value="${flt1.arrivalTime}"><br>--%>
<%--    <input type="submit" value="修改">--%>
