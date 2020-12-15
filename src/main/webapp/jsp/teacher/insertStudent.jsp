<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>导入学生信息</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/teacher/head.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/teacher/insertStudent.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <link rel="icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>
    <link rel="apple-touch-icon"  sizes="32x32" href="${pageContext.request.contextPath}/img/systemIcon.png"/>

    <script>
        function deleteStudent(sno, username) {
            alert("this is deleteStudent!")
            if (confirm("是否确定删除？")) {
                location.href = "${pageContext.request.contextPath}/deleteStudentServlet?username=" + username + "&sno=" + sno;
            }
        }
    </script>
</head>
<body style="background:url('${pageContext.request.contextPath}/img/background0.jpg') no-repeat;background-size: 100% 100%;">

<div class="container2">
    <div class="display_addStudent">
        <div class="div_addStudent">
            <label>添加单个学生</label>
            <form class="form-inline" action="${pageContext.request.contextPath}/addStudentServlet" method="post">
                <input type="hidden" name="username" value="${username}">
                <div class="form-group">
                    <label class="sr-only" for="sno">学号</label>
                    <input type="text" class="form-control" id="sno" name="sno" placeholder="学号">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="studentName" placeholder="姓名">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="class">班级</label>
                    <input type="text" class="form-control" id="class" name="className" placeholder="班级">
                </div>
                <button type="submit" class="btn btn-default">添加</button>
            </form>
        </div>
    </div>

    <div class="display_studentList">
        <div class="div_studentList">
            <table class="table table-bordered table-hover" style="color: white">
                <tr class="tableHead">
                    <td>学号</td>
                    <td>姓名</td>
                    <td>班级</td>
                    <td>操作</td>
                </tr>

                <c:forEach items="${pb.list}" var="student" varStatus="s">
                    <tr>
                        <td>${student.sno}</td>
                        <td>${student.studentName}</td>
                        <td>${student.className}</td>
                        <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteStudentServlet?username=${username}&sno=${student.sno}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="other">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <c:if test="${pb.currentPage == 1}">
                                <a href="${pageContext.request.contextPath}/studentManagerServlet?username=${username}&currentPage=1&rows=5" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </c:if>
                            <c:if test="${pb.currentPage != 1}">
                                <a href="${pageContext.request.contextPath}/studentManagerServlet?username=${username}&currentPage=${pb.currentPage - 1}&rows=5" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </c:if>
                        </li>
                        <c:forEach begin="1" end="${pb.totalPage}" var="i">
                            <li><a href="${pageContext.request.contextPath}/studentManagerServlet?username=${username}&currentPage=${i}&rows=5">${i}</a></li>
                        </c:forEach>
                        <li>
                            <c:if test="${pb.currentPage == pb.totalPage}">
                                <a href="${pageContext.request.contextPath}/studentManagerServlet?username=${username}&currentPage=${pb.currentPage}&rows=5" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </c:if>
                            <c:if test="${pb.currentPage != pb.totalPage}">
                                <a href="${pageContext.request.contextPath}/studentManagerServlet?username=${username}&currentPage=${pb.currentPage + 1}&rows=5" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </c:if>
                        </li>
                        <span style="font-size: 30px; margin-left: 8px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

    <div class="display_uploadStudent">
        <div class="div_uploadStudent">
            <label>批量导入学生名单</label>
            <div>
                <input class="btn btn-default" type="button" value="选择文件">
                <label class="textLabel1">未上传文件</label>
                <input class="btn btn-default" type="button" value="上传">
            </div>
        </div>
    </div>
</div>

</body>
</html>
