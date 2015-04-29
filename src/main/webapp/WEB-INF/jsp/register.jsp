<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Shiro Register</title>
    <!-- Bootstrap -->
    <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" media="screen">
    <link href="<c:url value='/resources/bootstrap/css/bootstrap-responsive.min.css'/>" rel="stylesheet" media="screen">
    <link href="<c:url value='/resources/assets/styles.css'/>" rel="stylesheet" media="screen">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="<c:url value='/resources/vendor/modernizr-2.6.2-respond-1.1.0.min.js'/>"></script>
  </head>
  <body id="login">
	<div class="container">
		<shiro:guest>
		<form class="form-signin" action="<c:url value="/register"/>" method="post">
			<h2 class="form-signin-heading">Please Register</h2>
			<input type="text" name="username" class="input-block-level" placeholder="Username">
			<input type="password" name="password" class="input-block-level" placeholder="Password">
			<input type="password" name="password" class="input-block-level" placeholder="Again Password">
	        <button class="btn btn-large btn-primary" type="submit">Register</button>
		</form>
	    <c:if test="${requestScope['exception'] == 'RegisterException'}">
	        <p>注册失败：用户已存在！</p>
	    </c:if>
		</shiro:guest>

		<shiro:user>
		    <c:redirect url="/space"/>
		</shiro:user>
    </div><!-- /container -->
	
    <script src="<c:url value='/resources/vendors/jquery-1.9.1.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
  </body>
</html>