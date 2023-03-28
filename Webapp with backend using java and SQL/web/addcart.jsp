<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, simplesales.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Cart Processing</title>
    </head>
    <body>
        <h1>Adding to your cart</h1>
        <jsp:useBean id="salesBean" class="simplesales.sales" scope="session" />
        <%
            String pcode = request.getParameter("products");
            String qty   = request.getParameter("qty");
            String price = request.getParameter("price");
            
            orderdetails od = new orderdetails();
            od.ordernumber  = salesBean.O.ordernumber;
            od.pcode        = Integer.parseInt(pcode);
            od.price        = Integer.parseInt(price);
            od.qty          = Integer.parseInt(qty);
           
            salesBean.OD.add(od);
        %>    
        Listing contents of the cart so far<br>
        <% 
            for (int i=0; i<salesBean.OD.size(); i++) {
                orderdetails odr = new orderdetails();
                odr = salesBean.OD.get(i);  %>
                OrderNumber: <%=odr.ordernumber%><br>
                Product Code: <%=odr.pcode%><br>
                Price: <%=odr.price%><br>
                Qty: <%=odr.qty%><br>
        <%  } %><br>
        click <a href="index.jsp">here to go back to ordering</a><br>
    </body>
</html>
