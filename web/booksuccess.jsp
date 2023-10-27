<%@ page language="java" import="java.sql.*" %>

 
<% 
    
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CRMSNEW","root","12345");
    try{
        Statement st=con.createStatement();
String bdate=request.getParameter("bdate");
String pickup=request.getParameter("pickup");
String dropup=request.getParameter("dropup");
int userid=Integer.parseInt(request.getParameter("userid"));
String vehicleid=request.getParameter("vehicleid");
int driverid=Integer.parseInt(request.getParameter("driverid"));
int kms=Integer.parseInt(request.getParameter("kms"));
double price=Double.parseDouble(request.getParameter("price"));

 
String sql="insert into bookings(PICKUP,DROPUP,U_ID,V_ID,D_ID,B_DATE,KMS,PRICE) values('"+pickup+"','"+dropup+"',"+userid+",'"+vehicleid+"',"+driverid+",'"+bdate+"',"+kms+","+price+")";

int val=st.executeUpdate(sql);
if(val!=0)
{
    out.println("Booking has been sucssfully done.Our Driver will contact you soon.");
}
con.close();
} 
catch(SQLException e)
{ System.out.print("not found");
}
  
%>