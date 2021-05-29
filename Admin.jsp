<%-- 
    Document   : Admin
    Created on : 11 Apr, 2021, 2:24:56 PM
    Author     : 123
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        .w3-theme {color:#fff !important;background-color:#0099ff !important}
        .w3-btn {background-color:#4CAF50;margin-bottom:4px}
        .w3-code{border-left:4px solid #4CAF50}
        .myMenu {margin-bottom:150px}

        .grid-container {
            display: grid;
            grid-template-columns: auto auto auto auto;
            padding: 10px;
            margin-left: 20px;
            margin-right: 20px;
            margin-top: 20px;
        }

        .grid-item {
            background-color: #99003d;
            border: none;
            padding: 30px;
            font-size: 30px;
            text-align: center;
            color: white;
            margin: 20px;
            width: 300px;
            heigth: 300px;
        }

        .container{
            margin-left: 40px;
            margin-top: 40px;
            padding: 20px;
        }

        .tble{
            cell-spacing: 20px;
        }

        .tb {
            width: 70%;
            border-collapse: collapse;
            align: center;
            top: 50px;
            padding: 30px;
            cell-spacing: 20px;
            margin-left:40px;
        }

        th {border: 2px solid #0099ff;
            text-align: center;
            background-color: #0099ff;
            color: white;
            height: 45px;
        }

        .td1{
            text-align: center;
            padding: 30px;
            cell-spacing: 20px;
            bottom-border: 1px dotted black; 
        }
        
        #del{
                background-color: #0099ff;
                padding: 5px;
                color:white;
                border-radius: 2px;
                text-decoration: none;
            }
            
            .box{
                background-color: white;
                padding: 5px;
                color:white;
                border: none;
                border-radius: 2px;
                text-decoration: none;
                margin-left: 250px;
                margin-right: 250px;
                height: 300px;  
            }
    </style>
    <body>

        <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="margin-top:50px;  background-color: black; color: white; display:none" id="mySidebar">
            <button class="w3-bar-item w3-button w3-large"
                    onclick="w3_close()">Close &times;</button>
            <a class="w3-bar-item w3-button" href="#">Class 1</a>
            <a class="w3-bar-item w3-button" href="#">Class 2</a>
            <a class="w3-bar-item w3-button" href="#">Class 3</a>
            <a class="w3-bar-item w3-button" href="#">Class 4</a>
            <a class="w3-bar-item w3-button" href="#">Class 5</a>
        </div>

        <div id="main">
            <div class="w3-bar w3-theme w3-large">
                <div class="w3-center  w3-padding" style="background-color: black; color: white;">
                    <div class=" w3-margin-top w3-wide w3-hide-medium w3-hide-small"><div class="w3-center">Digi<b>Sight</b></div></div>
                </div>

                <button class="w3-bar-item w3-button w3-xlarge" onclick="w3_open()" id="openNav">&#9776;</button>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16" href="teacher.html">Home</a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16" href="javascript:void(0)">Posts</a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right"><%
                    String admin = (String) session.getAttribute("user1");
                    out.println(admin);
                %></a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right" href="loginedit.html">Logout</a>
            </div>

            <div class='container'>
                <h2>Add user</h2>
                <table class="tble" >
                    <form method="post" action="Admin.jsp">
                        <tr><td><br>Name: </td><td><br><input type="text" name="name"></td></tr>
                        <tr><td><br>Email: </td><td><br><input type="text" name="email"></td></tr>
                        <tr><td><br>Password: </td><td><br><input type="password" name="psw"></td></tr>
                        <tr><td><br>Class: </td><td><br><input type="text" name="cls"></td></tr>
                        <tr><td><br>Subject: </td><td><br><input type="text" name="sub"></td></tr>
                        <tr><td><br>User: </td><td><br><input type="radio" name="usr" value="teacher">&nbsp;Teacher&nbsp;&nbsp;<input type="radio" name="usr" value="student">&nbsp;Student</td>
                        </tr>
                        
                        <tr><td><br><input type="submit" style="background-color:#0099ff; border-style: none; height: 30px; color: white;"  value="Add User "></td>
                        </tr>
                    </form>
                </table>
            </div>
            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection conSt = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "");
                Statement stmt1 = conSt.createStatement();
                Connection conTe = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "");
                Statement stmt2 = conTe.createStatement();
                int row = 0;
                String sql = "";
                String usr = request.getParameter("usr");
                if (request.getParameter("name") != null) {

                    String name = request.getParameter("name");
                    String psw = request.getParameter("psw");
                    String cls = request.getParameter("cls");
                    
                    String sub = request.getParameter("sub");
                    String email = request.getParameter("email");
                    
                    if(usr.equals("student")){
                        sql = "INSERT INTO student"
                            + "(sid, sname, class, password, email, admin, subject, user) "
                           + "VALUES (NULL, '" + name + "', '" + cls + "', '" + psw + "', '" + email + "', '" + admin + "', '" + sub + "', 'student')";

                    row = stmt1.executeUpdate(sql);
                    }
                    
                    if(usr.equals("teacher")){
                        sql = "INSERT INTO teacher"
                            + "(tid, tname, subject, password, email, admin, class, user) "
                           + "VALUES (NULL, '" + name + "', '" + sub + "', '" + psw + "', '" + email + "', '" + admin + "', '" + cls + "', 'teacher')";

                    row = stmt2.executeUpdate(sql);
                    }
                }

                if (admin != null) {
                    sql = "select * from student where admin='" + admin + "'" ;
                    String sql2 = "select * from teacher where admin='" + admin + "'" ;
                    ResultSet rs = stmt1.executeQuery(sql);
                    ResultSet rs1 = stmt2.executeQuery(sql2);

                    out.println("<div style='margin-left:40px'>");
                    out.println("<h1>Users</h1><br></div><br>");
                    out.println("<div class='col-lg-12 d-flex justify-content-center'><br>");
                    out.println("<table style='align: center;' class='tb'>");

                    out.println("<tr>");
                    out.println("<th>");
                    out.println("Name");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Email");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Password");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Class");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Subject");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("User");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Delete user");
                    out.println("</th>");
                    out.println("</tr>");

                    while (rs.next()) {
                        out.println("<tr class='td1'><td class='td1'>" + rs.getString("sname") + "</td>");
                        out.println("<td class='td1'>" + rs.getString("email") + "</td>");
                        out.println("<td class='td1'>" + rs.getString("password") + "</td>");
                        out.println("<td class='td1'>" + rs.getString("class") + "</td>");
                        out.println("<td class='td1'>" + rs.getString("subject") + "</td>");
                        out.println("<td class='td1'>" + rs.getString("user") + "</td>");
                        out.println("<td class='td1'><a id='del' href='delete.jsp?op=delete&u=student&sid=" + rs.getInt("sid") + "'>delete</a></td></tr>");
                    }
                    
                    while (rs1.next()) {
                        
                        out.println("<tr class='td1'><td class='td1'>" + rs1.getString("tname") + "</td>");
                        out.println("<td class='td1'>" + rs1.getString("email") + "</td>");
                        out.println("<td class='td1'>" + rs1.getString("password") + "</td>");
                        out.println("<td class='td1'>" + rs1.getString("class") + "</td>");
                        out.println("<td class='td1'>" + rs1.getString("subject") + "</td>");
                        out.println("<td class='td1'>" + rs1.getString("user") + "</td>");
                        out.println("<td class='td1'><a id='del' href='delete.jsp?op=delete&u=teacher&tid=" + rs1.getInt("tid") + "'>delete</a></td></tr>");
                    }
                    out.println("</table></div>");
                    
                }


            %>
        </div>

        <script>
            function w3_open() {
                document.getElementById("main").style.marginLeft = "25%";
                document.getElementById("mySidebar").style.width = "25%";
                document.getElementById("mySidebar").style.display = "block";
                document.getElementById("openNav").style.display = 'none';
            }
            function w3_close() {
                document.getElementById("main").style.marginLeft = "0%";
                document.getElementById("mySidebar").style.display = "none";
                document.getElementById("openNav").style.display = "inline-block";
            }
        </script>



        <div id="main">
            <!-- Sidebar -->

            <!-- Overlay effect when opening sidebar on small screens -->
            <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

            <!-- Main content: shift it to the right by 270 pixels when the sidebar is visible -->
            <div class="w3-main w3-container" style="margin-left:300px;margin-top:50px;margin-right:300px;">


                <!-- END MAIN -->
            </div>

            <script>
                // Script to open and close the sidebar
                function w3_open() {
                    document.getElementById("mySidebar").style.display = "block";
                    document.getElementById("myOverlay").style.display = "block";
                }

                function w3_close() {
                    document.getElementById("mySidebar").style.display = "none";
                    document.getElementById("myOverlay").style.display = "none";
                }

                function w3_show_nav(name) {
                    document.getElementById("menuTut").style.display = "none";
                    document.getElementById("menuRef").style.display = "none";
                    document.getElementById(name).style.display = "block";
                    w3 - open();
                }
            </script>

            <script src="https://www.w3schools.com/lib/w3codecolor.js"></script>

            <script>
                w3CodeColor();
            </script>

    </body>
</html>

