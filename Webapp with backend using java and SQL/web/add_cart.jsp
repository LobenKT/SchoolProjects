<%-- 
    Document   : add_cart
    Created on : 12 17, 21, 11:29:29 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add to Cart</title>
    </head>
    
        <h1>Adding the product into the Cart</h1>
        <jsp:useBean id="salesBean" class="demoModule4.sales" scope="session" />
        <% String pcode  = request.getParameter("products");                     %>
        <% String qty    = request.getParameter("qty");                          %>
        <% String price  = request.getParameter("price");                        %>
        <% int v_pcode   = Integer.parseInt(pcode);                              %>
        <% int v_qty     = Integer.parseInt(qty);                                %>
        <% float v_price = Float.valueOf(price);                                 %>
        <% salesBean.add_cart(v_pcode, v_qty, v_price);                          %>
        <a href="sales_select.jsp">Click here to add more products</a>
</html>
