<%-- 
    Document   : test
    Created on : 8 Apr, 2021, 4:49:33 PM
    Author     : 123
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<%
    Class.forName("com.mysql.jdbc.Driver");
                Connection conSt = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "");
                Statement stmt1 = conSt.createStatement();
                Connection conTe = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "");
                Statement stmt2 = conTe.createStatement();
    int row = 0;
    String sql = "";

    String operation = request.getParameter("op");
    String u = request.getParameter("u");
    if (operation != null) {
        if (operation.equals("delete") & u.equals("student")) {
            sql = "delete from student where sid= " + Integer.parseInt(request.getParameter("sid"));
            row = stmt1.executeUpdate(sql);
            out.println("<div class='col-lg-12 d-flex justify-content-center'>");
            out.println("<p id='suc'>Product deleted successfully!</p></div>");
            response.sendRedirect("Admin.jsp");
        }
        if (operation.equals("delete") & u.equals("teacher")) {
            sql = "delete from teacher where tid= " + Integer.parseInt(request.getParameter("tid"));
            row = stmt1.executeUpdate(sql);
            out.println("<div class='col-lg-12 d-flex justify-content-center'>");
            out.println("<p id='suc'>Product deleted successfully!</p></div>");
            response.sendRedirect("Admin.jsp");
        }
    }
%>