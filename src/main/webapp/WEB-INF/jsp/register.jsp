<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
  <body>
	<div class="container">
		<shiro:guest>
			<!-- validation -->
            <div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">Form Validation</div>
					</div>
					<div class="block-content collapse in">
						<div class="span12">
							<!-- BEGIN FORM-->
							<form  id="form_sample_1" class="form-horizontal" action="<c:url value="/register"/>" method="post">
								<fieldset>
									<c:if test="${requestScope['exception'] == 'RegisterException'}">
								   		<div class="alert">
											<button class="close" data-dismiss="alert">&times;</button>
											<strong>Warning!</strong> 注册失败：用户已存在！
										</div>
								    </c:if>
								    <div class="error"></div>
		 							<div class="control-group">
		 								<label class="control-label">User Name<span class="required">*</span></label>
		 								<div class="controls">
		 									<input type="text" name="username" data-required="1" class="span6 m-wrap" placeholder="Username">
		 								</div>
		 							</div>
		 							<div class="control-group">
		 								<label class="control-label">Password<span class="required">*</span></label>
		 								<div class="controls">
		 									<input type="password" name="password" class="span6 m-wrap" placeholder="Password">
		 								</div>
		 							</div>
		 							<div class="control-group">
		 								<label class="control-label">Confirm Password<span class="required">*</span></label>
		 								<div class="controls">
		 									<input type="password" name="confirm_password" class="span6 m-wrap" placeholder="Confirm Password">
		 								</div>
		 							</div>
		 							<div class="control-group">
		 								<label class="control-label">Role<span class="required">*</span></label>
		 								<div class="controls">
		 									<form:select class="span6 m-wrap" path="roleList">
												<form:option value="NONE" label="--- Select ---" />
												<form:options items="${roleList}" />
     										</form:select>
		 								</div>
		 							</div>
		 							<div class="form-actions">
		 								<button type="submit" class="btn btn-primary">Validate</button>
		 								<button type="button" class="btn">Cancel</button>
		 							</div>
								</fieldset>
							</form><!-- END FORM-->
						</div>
			    	</div>
				</div><!-- /block -->
		    </div><!-- /validation -->
		</shiro:guest>

		<shiro:user>
		    <c:redirect url="/space"/>
		</shiro:user>
    </div><!-- /container -->
	
    <script src="<c:url value='/resources/vendors/jquery-1.9.1.min.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/resources/vendors/jquery-validation/dist/jquery.validate.min.js'/>"></script>
	<script>
	$().ready(function() {
		 $("#form_sample_1").validate({
			    rules: {
			    	username: {
		                required: true,
		                rangelength: [5,10]
		            },
		            password: {
		                required: true,
		                minlength: 5
		            },
		            confirm_password: {
		                required: true,
		                minlength: 5,
		                equalTo: "#password"
		            }
		        },
		        messages: {
		        	username: {
			            required: "没有填写用户名",
			            rangelength: jQuery.format("用户名长度范围在{0}到{1}个字符之间")
			        },
		            password: {
		                required: "没有填写密码",
		                minlength: jQuery.format("密码不能小于{0}个字符")
		            },
		            confirm_password: {
		                required: "没有确认密码",
		                minlength: "确认密码不能小于{0}个字符",
		                equalTo: "两次输入密码不一致嘛"
		            }
		        },
		        submitHandler:function(form){
		            form.submit();
		        }    
		    });
		});
	</script>
  </body>
</html>