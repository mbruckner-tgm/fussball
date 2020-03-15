<%@page  
 import="java.util.*,javax.naming.*,javax.sql.DataSource,java.sql.*"%>  
<%  
 DataSource ds = null;  
 Connection con = null;  
 Statement stmt = null;  
 InitialContext ic;  
    
 try {  
 ic = new InitialContext();  
 ds = (DataSource) ic.lookup("java:/postgresDS");  
 con = ds.getConnection();  
 stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("select * from players");  
  
 while (rs.next()) {  
 out.println("<br> " + rs.getString("player_id") + " | "  
 + rs.getString("player_name"));  
 }  
 rs.close();  
 stmt.close();  
 } catch (Exception e) {  
 out.println("Exception thrown :/");  
 e.printStackTrace();  
 } finally {  
 if (con != null) {  
 con.close();  
 }  
 }  
    %>  