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
            <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男" checked/>男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${user.gender == '女'}">
                <input type="radio" name="gender" value="男" />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control" >
                <c:if test="${user.address == '中国'}">
                    <option value="中国" selected>中国</option>
                    <option value="美国">美国</option>
                    <option value="澳大利亚">澳大利亚</option>
                    <option value="西班牙">西班牙</option>
                    <option value="俄罗斯">俄罗斯</option>
                    <option value="德国">德国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '美国'}">
                    <option value="中国">中国</option>
                    <option value="美国" selected>美国</option>
                    <option value="澳大利亚">澳大利亚</option>
                    <option value="西班牙">西班牙</option>
                    <option value="俄罗斯">俄罗斯</option>
                    <option value="德国">德国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '澳大利亚'}">
                    <option value="中国">中国</option>
                    <option value="美国">美国</option>
                    <option value="澳大利亚" selected>澳大利亚</option>
                    <option value="西班牙">西班牙</option>
                    <option value="俄罗斯">俄罗斯</option>
                    <option value="德国">德国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '西班牙'}">
                    <option value="中国">中国</option>
                    <option value="美国">美国</option>
                    <option value="澳大利亚">澳大利亚</option>
                    <option value="西班牙" selected>西班牙</option>
                    <option value="俄罗斯">俄罗斯</option>
                    <option value="德国">德国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '俄罗斯'}">
                    <option value="中国">中国</option>
                    <option value="美国">美国</option>
                    <option value="澳大利亚">澳大利亚</option>
                    <option value="西班牙">西班牙</option>
                    <option value="俄罗斯" selected>俄罗斯</option>
                    <option value="德国">德国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '德国'}">
                    <option value="中国">中国</option>
                    <option value="美国">美国</option>
                    <option value="澳大利亚">澳大利亚</option>
                    <option value="西班牙">西班牙</option>
                    <option value="俄罗斯">俄罗斯</option>
                    <option value="德国" selected>德国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '英国'}">
                    <option value="中国">中国</option>
                    <option value="美国">美国</option>
                    <option value="澳大利亚">澳大利亚</option>
                    <option value="西班牙">西班牙</option>
                    <option value="俄罗斯">俄罗斯</option>
                    <option value="德国">德国</option>
                    <option value="英国" selected>英国</option>
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
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
<%--            <input class="btn btn-default" type="button" value="返回"/>--%>
        </div>
    </form>
</div>
</body>
</html>
