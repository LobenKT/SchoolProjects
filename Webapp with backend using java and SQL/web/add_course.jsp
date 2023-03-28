<%-- 
    Document   : add_course
    Created on : 02 1, 22, 5:18:09 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, module4.* "  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add course</title>
    </head>
    <body>
        <h1>Add a course. </h1>
        <jsp:useBean id="courseBean" class="module4.courses" scope="session" />
        <%
            
            String courseid = request.getParameter("courseid");
            String coursename = request.getParameter("coursename");
            String department = request.getParameter("department");
            
            courseBean.courseid = courseid;
            courseBean.coursename = coursename;
            courseBean.department = department;
            
            courseBean.addRecord();
            

        %>    
        Course added<br>
        click <a href="index.html">here to go back to main menu</a><br>
    </body>
</html>