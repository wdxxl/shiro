<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Shiro Login</title>
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
		<shiro:notAuthenticated>
		<form class="form-signin" action="<c:url value="/login"/>" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" name="username" class="input-block-level" placeholder="Username">
			<input type="password" name="password" class="input-block-level" placeholder="Password">
	        <label class="checkbox">
	          <input type="checkbox" name="rememberMe">Remember me
	        </label>
	        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
		</form>
		<c:if test="${requestScope['exception'] == 'LoginException'}">
			<p>登录失败！</p>
		</c:if>
		</shiro:notAuthenticated>
		
		<shiro:authenticated>
			<c:redirect url="/space"/>	
		</shiro:authenticated>
    </div> <!-- /container -->
	
    <script src="<c:url value='/resources/vendors/jquery-1.9.1.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
  </body>
</html>