<%--
  Created by IntelliJ IDEA.
  User: 33942
  Date: 2021/9/4
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}css/admin.css">
    <script src="${pageContext.request.contextPath}js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}js/pintuer.js"></script>
</head>
<body>


<form method="post" action="${pageContext.request.contextPath}/findServlet" id="listform">
    <div class="panel admin-panel">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <%--添加需要补齐--%>
                <li> <a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath}/addFlight.jsp"> 添加航班</a> </li>
            </ul>
        </div>
        <div class="padding border-bottom">
            <tr class="search" style="padding-left:10px;">
                <td>
                    选择筛选条件:
                    <label >时间段开始:</label>
                    <input name="movecid1" type="time" step="1">
                    <label >时间段结束:</label>
                    <input name="movecid2" type="time" step="1">
                    <input type="text" style="padding:5px 15px; border:1px solid #ddd;"name="movecid3" placeholder="出发城市" data-validate="required:出发城市" />
                    <input type="text" style="padding:5px 15px; border:1px solid #ddd;"name="movecid4" placeholder="抵达城市" data-validate="required:抵达城市" />
                </td>
                <td>
                    <input type="text" placeholder="航班号查询" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <input type="submit" class="button border-main icon-search" onclick="changesearch()" value="查询所有航班" > </input></td>
            </tr>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:40px;">ID</th>
                <th>序号</th>
                <th>航班号</th>
                <th>起飞城市</th>
                <th>抵达城市</th>
                <th>起飞时间</th>
                <th>抵达时间</th>
                <th width="10%">更新时间</th>
                <th width="310">操作</th>
            </tr>
            <volist name="list" id="vo">
                <c:forEach items="${list}" var="list" varStatus="index" >
                <tr>
                    <td>${index.count}</td>
                    <td style="text-align:left; padding-left:20px;">${list.fid}</td>
                    <td style="text-align:left; padding-left:20px;">${list.flightNo}</td>
                    <td style="text-align:left; padding-left:20px;">${list.departureCity}</td>
                    <td style="text-align:left; padding-left:20px;">${list.arrivalCity}</td>
                    <td style="text-align:left; padding-left:10px;">${list.departureTime}</td>
                    <td style="text-align:left; padding-left:10px;">${list.arrivalTime}</td>
                    <td style="text-align:left; padding-left:0px;" ><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="bb"/>
                            ${bb} </td>
                    <td style="text-align:left; padding-left:0px;"><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath}/editFlightServlet?fid=${list.fid}"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="${pageContext.request.contextPath}/deleteServlet?fid=${list.fid}" return del(1,1,1)><span class="icon-trash-o" ></span> 删除</a> </div></td>
                </tr>
                    </c:forEach>
        </table>
    </div>
</form>
</table>
</body>
</html>
