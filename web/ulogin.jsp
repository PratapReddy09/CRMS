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
          //  out.println("Email="+email);
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CRMSNEW","root","12345");
                    Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select u_name,password from users where u_name='" + username +"' and password='" + password +"'");
                if (rs.next()) {
                    //out.println("Hello");
                    session.setAttribute("username",username);
                    response.sendRedirect("booking.jsp");
                }
                else {
                    response.sendRedirect("userlogin.html");
                    
                }
            %> 
        </body>
    </html>