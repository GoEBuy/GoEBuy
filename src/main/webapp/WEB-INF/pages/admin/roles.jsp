<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 角色管理</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>SpringMVC 博客系统-角色管理</h1>
    <hr/>

    <h3>所有角色<a href="/admin/roles/add" type="button" class="btn btn-primary btn-sm">添加</a></h3>

    <!-- 如果用户列表为空 -->
    <c:if test="${empty roleList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Role表为空，请<a href="/admin/roles/add" type="button" class="btn btn-primary btn-sm">添加</a>
        </div>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty roleList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>角色名称</th>
                <th>描述</th>		
                <
            </tr>

            <c:forEach items="${roleList}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.role}</td>
                     <td>${role.desc}</td>
                    <td>
                        <a href="/admin/roles/show/${role.id}" type="button" class="btn btn-sm btn-success">详情</a>
                        <a href="/admin/roles/update/${role.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                        <a href="/admin/roles/delete/${role.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </c:if>

  <%--       
     <span>共有<em>${userCnt}</em>条记录</span>

		<div class="page cf">
			<!-- <div class="pg">
				<a class="first" href="javascript:void(0);"><i
					class="i_pg_f ico"></i></a><a class="prev" href="javascript:void(0);"><i
					class="i_pg_l ico"></i></a><a href="javascript:void(0);">3</a><a
					href="javascript:void(0);">4</a><strong class="current"
					href="javascript:void(0);">5</strong><a href="javascript:void(0);">6</a><a
					href="javascript:void(0);">7</a><span class="dot">...</span><a
					href="javascript:void(0);">145</a><a class="next"
					href="javascript:void(0);"><i class="i_pg_n ico"></i></a><a
					class="end" href="javascript:void(0);"><i class="i_pg_e ico"></i></a>
			</div> -->
			<div class="show">
				共<em id="em_count">${userCnt}</em>条记录，每页显示<span
					class="gri_datatable_pg_rowcount">
					<select class="gri_datatable_rownum ipt_show "><option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="50">50</option>
						<option value="80">80</option>
						<option value="100">100</option>
						<option value="200">200</option>
						</select> 条</span>
			</div>
		</div>
		  time:${requestScope.time}
    <span>${userCnt}</span>
     <span><% userCnt%>条记录</span> --%>

     
 <!--     
     <div>
  <form method="post" action="/admin/doUpload" enctype="multipart/form-data">
<input type="file" name="file"/>
<input type="submit" value="上传文件"/>

</form>
</div>     
 -->
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>