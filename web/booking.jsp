<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.sql.*"%>
<html>
    <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
        $("#vehicleid").change(function(){  
        var b=$('#vehicleid option:selected').text();
        //alert(b);
        $.ajax({type:'post', url: "check.jsp", data: {id: b}, success: function(result){
        //alert(result);
        
         $("#price1").val(result);
       
        
        } 
    });
    });
  });
  
  
  
  
  
  $(document).ready(function(){
        $("#vehicleid").change(function(){  
        var c=$('#vehicleid option:selected').text();
              //alert(c);
              $.ajax({type: 'post', url: "check1.jsp", data: {id: c}, success: function (result) {
                      //alert(result);

                      $("#vname").val(result);


                  }
              });
          });
      });
    </script>
    
    </head>
    <body>
<br/>
<form method="post" action="booksuccess.jsp">
    <table align="center" >
    <tr>
    <td align='center'>Booking date :</td>
    <td><input type='text' name='bdate'></td>
       </tr>
       <tr>
    <td align='center'>Source point :</td>
    <td><input type='text' name='pickup'></td>
       </tr>
       <tr>
    <td align='center'>Destination point :</td>
    <td><input type='text' name='dropup'></td>
       </tr>
        
        <tr><td>User id:</td> <td><select id="userid" name="userid">
    <option>--select user id--</option>
    <%
     
        String user=(String)session.getAttribute("username");

        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CRMSNEW","root","12345");
                    Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select U_ID,U_NAME from USERS where U_NAME='"+user+"'");
                while(rs.next()){
                    %>
                    out.print("<option value=<%=rs.getInt(1)%>><%=rs.getInt(1)%>[<%=rs.getString(2)%>]</option>");
                    <%
                        }
                    %>
                </select></td>        
    </tr>
    <tr><td>vehicle :</td> <td><select id="vehicleid" name="vehicleid">
    <option>--select vehicle--</option>
    <%
        Connection con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/CRMSNEW","root","12345");
                    Statement st1 = con1.createStatement();
                ResultSet rs1 = st1.executeQuery("select V_ID,V_NAME from VEHICLE");
                while(rs1.next()){
                    %>
                    out.print("<option value=<%=rs1.getString(1)%>><%=rs1.getString(1)%></option>");
                    <%
                        }
                    %>
                </select></td>        
    </tr>
    <tr>
    <td>Vehicle Name :</td>
    <td><input type='text' name='vname' id='vname'></td>
    </tr>
    <tr>
    <td>Unit Price :</td>
    <td><input type='text' name='price1' id='price1'></td>
    </tr>
    
    <tr><td>driver id:</td> <td><select id="driverid" name="driverid">
    <option>--select driver id--</option>
    <%
        Connection con2 = DriverManager.getConnection("jdbc:derby://localhost:1527/CRMSNEW","root","12345");
                    Statement st2 = con2.createStatement();
                ResultSet rs2 = st2.executeQuery("select D_ID,D_NAME from DRIVER");
                while(rs2.next()){
                    %>
                    out.print("<option value=<%=rs2.getInt(1)%>><%=rs2.getInt(1)%>[<%=rs2.getString(2)%>]</option>");
                    <%
                        }
                    %>
                </select></td>   
    </tr>
    <tr>
    <td align='center'>Kms :</td>
    <td><input type='text' name='kms' id='kms'></td>
    </tr>
    <tr>
    <td align='center'>Total Price :</td>
    <td><input type='text' name='price' id='price' onfocus='calculateamount()'></td>
    </tr>
    
    <tr>
        <td align="center"><input type="submit" name="BookNow" value="BookNow"></td>
      
    </tr>
  </table>
</form>
                <script>
                    function calculateamount() {
                        var a=document.getElementById('kms').value;
                        var x=document.getElementById('price1').value;
                        document.getElementById('price').value = a * x;
                        
                    }
                    
                                        </script>
    </body>
    
</html>

