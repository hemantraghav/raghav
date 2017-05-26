/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static oracle.jdbc.driver.OracleLog.info;

/**
 *
 * @author sumit
 */
public class database {
           Connection con;
        
        PreparedStatement ps;
    public int insert(String name,String password) throws ClassNotFoundException, SQLException{
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
 
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","3394");
       
        ps=con.prepareStatement("insert into sql1(name,password) values(?,?)");
        ps.setString(1, name);
        ps.setString(2,password);
        int i=ps.executeUpdate();
        if(i>0){
            return 1;
        }
        else{
            return 0;
        }
        } catch (SQLException e) {
		}
  return 0;  
}

}