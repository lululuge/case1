<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            // 用户安全提示
            if (confirm("您确定要删除该用户吗？")) {
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id=" + id;
            }
        }

        function deleteSelected() {
            // 用户安全提示
            if (confirm("您确定要删除选中的用户吗？")) {
                // 判断选中条目是否为空
                var flag = false;
                var cbs = document.getElementsByName("checkbox_id");
                // 遍历cbs，看是否有被选中的条目(为了防止空指针异常)
                for (var i = 0; i < cbs.length; i++) {
                    if (cbs[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    // 实现表单的提交功能
                    document.getElementById("form").submit();
                }

            }
        }

        window.onload = function () {
            // 实现全选功能
            // 获取全选按钮
            var firstCb = document.getElementById("firstCb");
            firstCb.onclick = function () {
                // 获取列表中所有的checkbox
                var cbs = document.getElementsByName("checkbox_id");
                // 遍历cbs，设置checked属性
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }


            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress2">籍贯</label>
                <input type="text" class="form-control" id="exampleInputAddress2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:deleteSelected()">删除选中</a>
    </div>
<%--    将整个用户列表用一个表单进行封装，以方便实现删除选中功能.
        当选中checkbox后，提交该表单，会自动将id信息提交到action路径,提交功能通过“删除选中”按钮来实现。
--%>
    <form action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post" id="form">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="checkbox_id" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div style="float: left">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">
                            ${i}
                        </a>
                    </li>
                </c:forEach>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">共${pb.totalCount}条记录，共${pb.totalPage}页</span>

            </ul>
        </nav>
    </div>
</div>
</body>
</html>

