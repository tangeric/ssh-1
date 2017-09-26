<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script>
    $(function(){
	  $(".delete").click(function(){
		  var lastName=$(this).parent().siblings().first().next().text();
		  var flag=confirm("确定要删除"+lastName+"的信息吗");	
	      if(flag){
	    	  var tr=$(this).parent().parent();
	    	  var url=this.href;
	    	  var args={"time":new Date()};
	    	  $.post(url,args,function(data){
	    		  if(data="1"){
	    			  alert("删除成功");
	    			  tr.remove();
	    		  }else{
	    			  alert("删除失败");
	    		  }
	    	  });
	      }
		  return false;
	  });
    });
</script>
</head>
<body>
 <h2>list page</h2>
 <table border="1" cellpadding="12" cellspacing="0">
   <tr>
   <td>ID</td>
   <td>LastName</td>
   <td>email</td>
   <td>birth</td>
   <td>CreateTime</td>
   <td>dept</td>
   <td>DELETE</td>
   <td>EDIT</td>
   </tr>
   <s:iterator value="#request.employees">
      <tr>
      <td>${id }</td>
      <td>${lastName }</td>
      <td>${email }</td>
      <td>
         <s:date name="birth" format="yyyy-MM-dd"/>
      </td>
      <td>${createTime }</td>
      <td>${department.departmentName}</td>
      <td><a href="emp_input?id=${id}">edit</a></td>
      <td><a href="emp_delete?id=${id}" class="delete">Delete</a></td>
      </tr>
   </s:iterator>
 </table>
 
</body>
</html>