<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.sql.*"%>
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP Page</title> 
    </head> 
    <body>
        <% 
            String username=request.getParameter("username"); 
        String password=request.getParameter("password"); 
    if((username.equals("pratap") && password.equals("70954"))) 
{ 
    session.setAttribute("username",username); 
response.sendRedirect("faces/index.xhtml"); 
} 
else
        response.sendRedirect("alogin.html");
    %> 
    </body>
</html>

