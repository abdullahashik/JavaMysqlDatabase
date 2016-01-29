/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdullahilashik;

/**
 *
 * @author ashik
 */


import java.sql.*;

public class Connect {
    private static final String SQL = 
			"SELECT *from employee";
    public static ResultSet rs = null;
    public static Connection conn = null;
    public static Statement stmt  = null;
    
    Connect() throws Exception{        
		try {
                     conn = DBUtil.getConnection(DBType.MYSQL);                        
				

		} catch (SQLException e) {
			System.err.println(e);
		}
		finally {                    
			if (rs != null) rs.close();
		}
    }    
    
    public static ResultSet getData() throws Exception{
        try{
            stmt= conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(SQL);			
                        return rs;
        }catch(Exception exception){
        return rs;    
        }finally{
            //if(rs!=null) rs.close();
        }
        
    }
    public static boolean insertData(String name,String phone, String email, String address){
        String insertQuery = "insert into employee(name,phone,email,address) values('"+name+"','"+phone+"','"+email+"','"+address+"')";
        
        try{
            stmt = conn.createStatement();
            stmt.execute(insertQuery);
            return true;
        }catch(Exception exception){
            return false;    
        }
        
    }

}

