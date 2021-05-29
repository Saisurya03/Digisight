/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 123
 */
public class login1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String uname = request.getParameter("uname");
            String ut = request.getParameter("ut");
            String psw = request.getParameter("password");
            String page = "login.html";
            String name = null;
            HttpSession session = request.getSession();
            String[] user1 = null;

            Class.forName("com.mysql.jdbc.Driver");
            Connection conSt = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "");
            Statement stmt1 = conSt.createStatement();

            if (ut.equals("student")) {

                ResultSet rs = stmt1.executeQuery("select * from student");

                while (rs.next()) {
                    user1 = new String[5];
                    String username = rs.getString("sname");
                    String pswd = rs.getString("password");
                    String cls = rs.getString("class");
                    String sub = rs.getString("subject");
                    String u = rs.getString("user");

                    if (username.equals(uname) & pswd.equals(psw)) {
                        user1[0] = username;
                        user1[1] = pswd;
                        user1[2] = cls;
                        user1[3] = sub;
                        user1[4] = u;
                        name = username;
                        page = "student";
                        session.setAttribute("user1", user1);
                    }
                }
            }

            if (ut.equals("teacher")) {
                ResultSet rs = stmt1.executeQuery("select * from teacher");

                while (rs.next()) {
                    user1 = new String[5];
                    String cls = rs.getString("class");
                    String sub = rs.getString("subject");
                    String u = rs.getString("user");
                    String username = rs.getString("tname");
                    String pswd = rs.getString("password");

                    if (username.equals(uname) & pswd.equals(psw)) {
                        user1[0] = username;
                        user1[1] = pswd;
                        user1[2] = cls;
                        user1[3] = sub;
                        user1[4] = u;
                        name = username;
                        page = "teacher";
                        for (String i : user1) {
                            out.println(i);
                        }
                        
                        session.setAttribute("user1", user1);
                    }
                    
                }
            }

            response.sendRedirect(page);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
