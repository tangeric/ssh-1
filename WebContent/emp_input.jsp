<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
   $(function(){
	   $("#ee").change(function(){
		   var val=$(this).val();
		   val=$.trim(val);
		   var $text=$(this);
		   if(val !=""){
			   $text.nextAll("font").remove();
			var url="echeckName";
			var args={"lastName":val,"time":new Date()};	
			
			
			$.post(url,args,function(data){
		
				if(data=="1"){
					$text.after("<font color='green'>用户名可用</font>");
				}else if(data=="0"){
					$text.after("<font color='red'>用户名不可用</font>");
				}else{
					alert("服务器错误");
				}
			});
		   }else{
			   alert("lastName不能为空");
			   $(this).val("");
		   }
	   });
   });
</script>
</head>
<body>

<h3>员工录入</h3>
<s:form action="emp_save" method="post">
    <s:textfield name="lastName" label="lastname" id="ee"></s:textfield>
    <s:textfield name="email"  label="Email"></s:textfield>
    <s:textfield name="birth"  label="Birth"></s:textfield>
    <s:select list="#request.departments" listKey="id" listValue="departmentName" name="department.id" label="Department"></s:select>
    <s:submit value="添加"></s:submit>
    <s:reset value="重置" ></s:reset>
</s:form>
</body>
</html>