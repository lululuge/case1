<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender == 'male'}">
                <input type="radio" name="gender" value="male" checked/>male
                <input type="radio" name="gender" value="female"  />female
            </c:if>
            <c:if test="${user.gender == 'female'}">
                <input type="radio" name="gender" value="male" />male
                <input type="radio" name="gender" value="female" checked />female
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control" >
                <c:if test="${user.address == 'beijing'}">
                    <option value="beijing" selected>beijing</option>
                    <option value="tianjin">tianjin</option>
                    <option value="shanghai">shanghai</option>
                    <option value="chongqing">chongqing</option>
                    <option value="hebei">hebei</option>
                    <option value="shanxi">shanxi</option>
                    <option value="liaoning">liaoning</option>
                    <option value="jilin">jilin</option>
                </c:if>

                <c:if test="${user.address == 'tianjin'}">
                    <option value="beijing" >beijing</option>
                    <option value="tianjin" selected>tianjin</option>
                    <option value="shanghai">shanghai</option>
                    <option value="chongqing">chongqing</option>
                    <option value="hebei">hebei</option>
                    <option value="shanxi">shanxi</option>
                    <option value="liaoning">liaoning</option>
                    <option value="jilin">jilin</option>
                </c:if>

                <c:if test="${user.address == 'shanghai'}">
                    <option value="beijing">beijing</option>
                    <option value="tianjin">tianjin</option>
                    <option value="shanghai" selected>shanghai</option>
                    <option value="chongqing">chongqing</option>
                    <option value="hebei">hebei</option>
                    <option value="shanxi">shanxi</option>
                    <option value="liaoning">liaoning</option>
                    <option value="jilin">jilin</option>
                </c:if>

                <c:if test="${user.address == 'chongqing'}">
                    <option value="beijing">beijing</option>
                    <option value="tianjin">tianjin</option>
                    <option value="shanghai">shanghai</option>
                    <option value="chongqing" selected>chongqing</option>
                    <option value="hebei">hebei</option>
                    <option value="shanxi">shanxi</option>
                    <option value="liaoning">liaoning</option>
                    <option value="jilin">jilin</option>
                </c:if>

                <c:if test="${user.address == 'hebei'}">
                    <option value="beijing" >beijing</option>
                    <option value="tianjin" >tianjin</option>
                    <option value="shanghai">shanghai</option>
                    <option value="chongqing">chongqing</option>
                    <option value="hebei" selected>hebei</option>
                    <option value="shanxi">shanxi</option>
                    <option value="liaoning">liaoning</option>
                    <option value="jilin">jilin</option>
                </c:if>

                <c:if test="${user.address == 'shanxi'}">
                    <option value="beijing" >beijing</option>
                    <option value="tianjin" >tianjin</option>
                    <option value="shanghai">shanghai</option>
                    <option value="chongqing">chongqing</option>
                    <option value="hebei">hebei</option>
                    <option value="shanxi" selected>shanxi</option>
                    <option value="liaoning">liaoning</option>
                    <option value="jilin">jilin</option>
                </c:if>

                <c:if test="${user.address == 'liaoning'}">
                    <option value="beijing" >beijing</option>
                    <option value="tianjin" >tianjin</option>
                    <option value="shanghai">shanghai</option>
                    <option value="chongqing">chongqing</option>
                    <option value="hebei" >hebei</option>
                    <option value="shanxi">shanxi</option>
                    <option value="liaoning" selected>liaoning</option>
                    <option value="jilin">jilin</option>
                </c:if>

                <c:if test="${user.address == 'jilin'}">
                    <option value="beijing" >beijing</option>
                    <option value="tianjin" >tianjin</option>
                    <option value="shanghai">shanghai</option>
                    <option value="chongqing">chongqing</option>
                    <option value="hebei" >hebei</option>
                    <option value="shanxi">shanxi</option>
                    <option value="liaoning">liaoning</option>
                    <option value="jilin" selected>jilin</option>
                </c:if>

            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" value="${user.qq}" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" value="${user.email}" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
