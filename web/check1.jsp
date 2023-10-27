<%@ page import="java.sql.*"  contentType="text/html"%>
<%
   
   String vid =request.getParameter("id");
   System.out.println(vid);
   
 Connection  con = DriverManager.getConnection ("jdbc:derby://localhost:1527/CRMSNEW","root","12345");
Statement st = con.createStatement();
 ResultSet  rs = st.executeQuery("select v_name from vehicle where v_id='"+vid+"'");
 
 if( rs.next()) { 
     //System.out.println(rs.getDouble("price"));
     out.println(rs.getString(1));
     
 }
 %>
