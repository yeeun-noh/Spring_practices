<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-07-12
  Time: 오후 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">Board Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <div class="form-group">
          <label>Bno</label>
          <input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label>
          <input class="form-control" name="title" value="${board.title}">
        </div>

        <div class="form-group">
          <label>Content</label>
          <input class="form-control" name="content" value="${board.content}">
        </div>

        <button data-oper="modify" class="btn btn-default"
                onclick="location.href='/board/modify?bno=${board.bno}'">Modify</button> &nbsp;&nbsp;&nbsp;
        <button data-oper="list" class="btn btn-info"
                onclick="location.href='/board/list'">List</button>

      </div>
      <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

