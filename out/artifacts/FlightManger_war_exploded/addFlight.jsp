<%--
  Created by IntelliJ IDEA.
  User: 18476
  Date: 2021/9/5
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add1.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>

</head>
<body>
<div class="panel admin-panel">

    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/addFlight">
            <div class="form-group">
                <div class="gogogo"><h1 class="ggg">增加航班</h1></div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>航班号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="flightNo" data-validate="required:航班号不能为空"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>起飞城市：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="departureCity"
                           data-validate="required:请输入起飞城市"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>抵达城市：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="arrivalCity" data-validate="required:请输入抵达城市："/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>起飞时间：</label>
                </div>
                <div class="field">
                    <input type="time" step="1" class="input w50" value="" name="departureTime"
                           data-validate="required:起飞时间不能为空"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>到达时间：</label>
                </div>
                <div class="field">
                    <input type="time" step="1" class="input w50" value="" name="arrivalTime"
                           data-validate="required:到达时间不能为空"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit" href="addFlight.jsp"
                            onclick="return confirm('确定要提交航班吗？')"> 提交航班
                    </button>

                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
