<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="/css/core.css" type="text/css" />
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.js"></script>
 
    <script type="text/javascript">
        $(function(){
            $("#pagination").twbsPagination({
                totalPages:${result.totalPage},
                visiblePages:${result.pageSize},
                startPage:${qo.currentPage},
                first:"首页",
                prev:"上一页",
                next:"下一页",
                last:"尾页",
                onPageClick:function(event,page){
                    $("#currentPage").val(page);
                    $("#searchForm").submit();
                }
            });

            $("#query").click(function(){
                $("#currentPage").val(1);
                $("#searchForm").submit();
            });

            $("#cancel").click(function () {
                $("#dept").val("-1");
                $("#keyword").val("");
                $("#currentPage").val(1);
                $("#searchForm").submit();
            });
        });
    </script>
</head>
<body>


                    <h1 class="page-head-line">员工管理</h1>
    

            <!--高级查询--->
            <form class="form-inline" id="searchForm" action="/employee/list.do" method="post">
                <input type="hidden" name="currentPage" id="currentPage" value="${qo.currentPage}">
                <input type="hidden" name="pageSize" id="pageSize" value="${qo.pageSize}">
                <div class="form-group">
                    <label for="keyword">关键字:</label>
                    <input type="text" class="form-control" id="keyword" name="keyword"  placeholder="请输入姓名/邮箱" value="${qo.keyword}">
                </div>
                <div class="form-group">
                    <label for="dept">部门:</label>
                    <select class="form-control" id="dept" name="deptId">
                        <option value="-1">全部</option>
                        <c:forEach items="${depts}" var="d">
                            <option value="${d.id}" ${qo.deptId == d.id? 'selected':''}>${d.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="button" id="query" class="btn btn-default">查询</button>
                <button type="button" id="cancel" class="btn btn-default" >重置</button>


            </form>

            <table class="table table-striped table-hover" >
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>名称</th>
                        <th>email</th>
                        <th>年龄</th>
                        <th>部门</th>
                 
                    </tr>
                </thead>
               <c:forEach items="${result.list}" var="e" varStatus="vs">
                   <tr>
                       <td>${vs.count}</td>
                       <td>${e.name}</td>
                       <td>${e.email}</td>
                       <td>${e.age}</td>
                       <td>${e.dept.name}</td>
    
                   </tr>
               </c:forEach>
            </table>
            <div style="text-align: center;">
                <ul id="pagination" class="pagination"></ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
