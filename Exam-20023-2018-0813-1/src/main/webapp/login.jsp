<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
 <body>
    
     <form action="loginServlet" method="post">
        <table >
            <tr><td colspan="2" style="text-align:center ">用户登录</td></tr>
            <tr>
                <td>用户名</td>
                <td>
                    <input type="text" name="userName"/>
                </td>
            </tr>
            <tr style="text-align: center">
                <td colspan="2">
                    <input type="submit" name="submit" value="登录"/>
                    <input type="reset" name="reset" value="重置"/>
                </td>   
            </tr>
        </table>
    </form>
   <span style="color:red"> ${message }</span>
</body>
</html>