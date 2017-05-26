/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sumit
 */
public class myregister extends HttpServlet {


    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       String name,password;
       name=request.getParameter("name");
       password=request.getParameter("password");
       
       
       database db=new database();
       int j=0;
       try{
           j=db.insert(name, password);
       }
      
        
        
        
     catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(myregister.class.getName()).log(Level.SEVERE, null, ex);
        }
if(j>0){
 RequestDispatcher   rd=request.getRequestDispatcher("out.jsp");
    rd.forward(request, response);
}
else{
    RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
    rd.forward(request, response);
}
    
    }
}
