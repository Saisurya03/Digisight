/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class tePosts extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            //ArrayList<String> teach = (ArrayList<String>) session.getAttribute("user1");

            String[] user1 = (String []) session.getAttribute("user1");
            String name = user1[0];
           /* String sub = teach[1];
            String pswd = teach[2];
            String cls = teach[3];
            String usr = teach[4];
*/
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <title>Home</title>\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
                    + "    <style>\n"
                    + "        .w3-theme {color:#fff !important;background-color:#4CAF50 !important}\n"
                    + "        .w3-btn {background-color:#4CAF50;margin-bottom:4px}\n"
                    + "        .w3-code{border-left:4px solid #4CAF50}\n"
                    + "        .myMenu {margin-bottom:150px}\n"
                    + "         .box{\n"
                    + "                background-color: white;\n"
                    + "                padding: 30px;\n"
                    + "                border: 1px  solid grey;\n"
                    + "                border-radius: 2px;\n"
                    + "                text-decoration: none;\n"
                    + "                height: 100px;  \n"
                    + "                width: 100%;"
                    + "            }"
                    + "             #test1{"
                    + "                 color: black;"
                    + "             }"
                    + "    </style>\n"
                    + "    <body>\n"
                    + "\n"
                    + "        <div class=\"w3-sidebar w3-bar-block w3-card w3-animate-left\" style=\"margin-top:50px;  background-color: black; color: white; display:none\" id=\"mySidebar\">\n"
                    + "            <button class=\"w3-bar-item w3-button w3-large\"\n"
                    + "                    onclick=\"w3_close()\">Close &times;</button>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"class1\">Class 1</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Class 2</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Class 3</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Class 4</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Class 5</a>\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div id=\"main\">\n"
                    + "\n"
                    + "            <div class=\"w3-bar w3-theme w3-large\">\n"
                    + "                <div class=\"w3-center  w3-padding\" style=\"background-color: black; color: white;\">\n"
                    + "                    <div class=\" w3-margin-top w3-wide w3-hide-medium w3-hide-small\"><div class=\"w3-center\">Digi<b>Sight</b></div></div>\n"
                    + "                </div>\n"
                    + "                <button class=\"w3-bar-item w3-button w3-xlarge\" onclick=\"w3_open()\" id=\"openNav\">&#9776;</button>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16\" href=\"teacher.html\">Home</a>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16\" href=\"javascript:void(0)\">Posts</a>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right\"><b>" + name + "</b></a>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right\" href=\"logout\">Logout</a>\n"
                    + "            </div>\n"
                    + "\n"
                    + "\n"
                    + "            <script>\n"
                    + "                function w3_open() {\n"
                    + "                    document.getElementById(\"main\").style.marginLeft = \"25%\";\n"
                    + "                    document.getElementById(\"mySidebar\").style.width = \"25%\";\n"
                    + "                    document.getElementById(\"mySidebar\").style.display = \"block\";\n"
                    + "                    document.getElementById(\"openNav\").style.display = 'none';\n"
                    + "                }\n"
                    + "                function w3_close() {\n"
                    + "                    document.getElementById(\"main\").style.marginLeft = \"0%\";\n"
                    + "                    document.getElementById(\"mySidebar\").style.display = \"none\";\n"
                    + "                    document.getElementById(\"openNav\").style.display = \"inline-block\";\n"
                    + "                }\n"
                    + "            </script>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "            <div id=\"main\">\n"
                    + "                <!-- Sidebar -->\n"
                    + "\n"
                    + "                <!-- Overlay effect when opening sidebar on small screens -->\n"
                    + "                <div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n"
                    + "\n"
                    + "                <!-- Main content: shift it to the right by 270 pixels when the sidebar is visible -->\n"
                    + "                <div class=\"w3-main w3-container\" style=\"margin-left:300px;margin-top:50px;margin-right:300px;\">\n"
                    + "\n"
                    + "                    <div class=\"w3-panel w3-padding-large w3-card-4 w3-light-grey\">\n"
                    + "                        <h1 class=\"w3-xlarge\">Posts Message</h1>\n"
                    + "                    <form action=\"posts\"><input type=\"text\" name=\"msg\" placeholder=\"Place your text here...\" style=\"align:center; height:120px; width:530px;\"><br><br>"
                    + "                  \n"
                    + "                        <input type=\"submit\" class=\"w3-button w3-theme w3-hover-white\" value=\"Post\"></form>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "\n"
                    + "                    \n"
                    + "                        \n");
            for (int i = 0; i < 5; i++) {
                out.println("<div class=\"w3-panel w3-padding-16 w3-card-4 w3-light-grey \">"
                        + "<p id='test1'><b>'name'</b></p>"
                        + "<p color='grey'>'sub'</p>"
                        + "<p class='box'>dfvhdbgijdgidgdfjgdj</p>"
                        + "</div><br><br>");
            }

            out.println("                        \n"
                    + "                    \n"
                    + "\n"
                    + "                    <!-- END MAIN -->\n"
                    + "                </div>\n"
                    + "\n"
                    + "                <script>\n"
                    + "                    // Script to open and close the sidebar\n"
                    + "                    function w3_open() {\n"
                    + "                        document.getElementById(\"mySidebar\").style.display = \"block\";\n"
                    + "                        document.getElementById(\"myOverlay\").style.display = \"block\";\n"
                    + "                    }\n"
                    + "\n"
                    + "                    function w3_close() {\n"
                    + "                        document.getElementById(\"mySidebar\").style.display = \"none\";\n"
                    + "                        document.getElementById(\"myOverlay\").style.display = \"none\";\n"
                    + "                    }\n"
                    + "\n"
                    + "                    function w3_show_nav(name) {\n"
                    + "                        document.getElementById(\"menuTut\").style.display = \"none\";\n"
                    + "                        document.getElementById(\"menuRef\").style.display = \"none\";\n"
                    + "                        document.getElementById(name).style.display = \"block\";\n"
                    + "                        w3 - open();\n"
                    + "                    }\n"
                    + "                </script>\n"
                    + "\n"
                    + "                <script src=\"https://www.w3schools.com/lib/w3codecolor.js\"></script>\n"
                    + "\n"
                    + "                <script>\n"
                    + "                    w3CodeColor();\n"
                    + "                </script>\n"
                    + "\n"
                    + "                </body>\n"
                    + "                </html>\n"
                    + "");

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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
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
