/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class assignments extends HttpServlet {

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
            String[] user1 = (String[]) session.getAttribute("user1");
            String name = user1[0];
            String cls = user1[2];
            String sub = user1[3];
            String u = user1[4];
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from assignments");

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <title>Home</title>\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
                    + "    <style>\n"
                    + "        .w3-theme {color:#fff !important;background-color:#e65c00 !important}\n"
                    + "        .w3-btn {background-color:#4CAF50;margin-bottom:4px}\n"
                    + "        .w3-code{border-left:4px solid #4CAF50}\n"
                    + "        .myMenu {margin-bottom:150px}\n"
                    + "         .grid-container {\n"
                    + "                 display: grid;\n"
                    + "                 position:relative;\n"
                    + "                 grid-column-gap: 0px;\n"
                    + "                 grid-template-columns: auto auto auto auto;\n"
                    + "                 grid-row-gap: 10px;\n"
                    + "                 }\n"
                    + "         .grid-item {\n"
                    + "                 font-size: 30px;\n"
                    + "                 text-align: center;\n"
                    + "                 }"
                    + "    </style>\n"
                    + "    <body>\n"
                    + "\n"
                    + "        <div class=\"w3-sidebar w3-bar-block w3-card w3-animate-left\" style=\"margin-top:50px;  background-color: black; color: white; display:none\" id=\"mySidebar\">\n"
                    + "            <button class=\"w3-bar-item w3-button w3-large\"\n"
                    + "                    onclick=\"w3_close()\">Close &times;</button>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"assignments\">Asignments</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Classes</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Messages</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Calander</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"Stsettings\">Settings</a>\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div id=\"main\">\n"
                    + "\n"
                    + "            <div class=\"w3-bar w3-theme w3-large\">\n"
                    + "                <div class=\"w3-center  w3-padding\" style=\"background-color: black; color: white;\">\n"
                    + "                    <div class=\" w3-margin-top w3-wide w3-hide-medium w3-hide-small\"><div class=\"w3-center\">Digi<b>Sight</b></div></div>\n"
                    + "                </div>\n"
                    + "                <button class=\"w3-bar-item w3-button w3-xlarge\" onclick=\"w3_open()\" id=\"openNav\">&#9776;</button>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16\" href=\"student\">Home</a>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16\" href=\"stPosts\">Posts</a>\n"
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
                    + "                    <div class=\"grid-container\">\n"
                    + "          <div class=\"grid-item\">\n"
                    + "          <a href=\"record\">\n"
                    + "            <img src=\"rec.png\" height=\"150px\" width=\"150px\">\n"
                    + "          </a>\n"
                    + "          </div>\n"
                    + "          <div class=\"grid-item\">\n"
                    + "          <a href=\"book.html\">\n"
                    + "            <img src=\"book.png\" height=\"150px\" width=\"150px\">\n"
                    + "          </a>\n"
                    + "          </div>\n"
                    + "          <div class=\"grid-item\">\n"
                    + "          <a href=\"graph.html\">\n"
                    + "            <img src=\"perf.png\" height=\"150px\" width=\"150px\">\n"
                    + "          </a>\n"
                    + "          </div>  \n"
                    + "          <div class=\"grid-item\">\n"
                    + "          <a href=\"quiz.html\">\n"
                    + "            <img src=\"quiz.png\" height=\"150px\" width=\"150px\">\n"
                    + "          </a>\n"
                    + "          </div><br><br><br>\n"
                    + "      </div>"
                    + "\n");
            while (rs.next()) {
                Blob img = rs.getBlob("asfile");
                out.println("<div class=\"w3-panel w3-padding-16 w3-card-4 w3-light-grey \">"
                        + "<p id='test1'><b>" + rs.getString("name") + "</b></p>"
                        + "<p>" + rs.getString("subject") + "</p>"
                        + "<p>" + rs.getString("date") + "</p>"
                        + "<p><a href='" + img + "'><img src='file.jpg' width=50px height=50px></a></p>"
                        + "</div><br><br>");

            }

            out.println("                        \n"
                    + "\n"
                    + "\n"
                    + "                    <footer class=\"w3-panel w3-padding-32 w3-card-4 w3-light-grey w3-center w3-opacity\">\n"
                    + "                        <p><nav>\n"
                    + "                            <a href=\"/forum/default.asp\" target=\"_blank\">FORUM</a> |\n"
                    + "                            <a href=\"/about/default.asp\" target=\"_top\">ABOUT</a>\n"
                    + "                        </nav></p>\n"
                    + "                    </footer>\n"
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
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
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
