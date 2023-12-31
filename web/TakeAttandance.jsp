<%-- 
    Document   : Group
    Created on : Sep 27, 2023, 12:46:25 AM
    Author     : myths
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/css_3.css">
    </head>
    <body>
        <div class="header">
            <div class="header-left">
                <h1 >FPT University Academic Portal</h1>
            </div>
            <div class="header-right">
                <label>FPT mobile app(myFAP) is ready at</label>
                <div class="mobile-button">
                    <a href="https://apps.apple.com/app/id1527723314">
                        <img src="https://fap.fpt.edu.vn/images/app-store.png" style="width: 120px; height: 40px" alt="apple store"></a>
                    <a href="https://play.google.com/store/apps/details?id=com.fuct">
                        <img src="https://fap.fpt.edu.vn/images/play-store.png" style="width: 120px; height: 40px" alt="google store"></a>
                </div>
            </div>
        </div>
        <div class="space">
            <div class="space-left">
                <a class="space-content" href="group">Check Attandance   </a>

                <text>Group </text>
            </div>
            <div class="space-right">
                <a class="space-content-right" href="mssv"><div class="btn btn-default">Sonnt5</div> </a>
                <a class="space-content-right" href="LogoutController"><div class="btn btn-default">Logout </div></a>
                <a class="space-content-right" href="Logout"><div class="btn btn-default">CAMPUS:HOA LAC</div></a>
            </div>
        </div>

        <div class="content">
            <form action="AttandanceCheck" method="post">
                <input type="hidden" name="scheduleid" value="${scheduleid}">

                <div class="header-card">
                    <div class="header-line">
                        <div class="header-text">INDEX</div>
                        <div class="header-text">IMAGE</div>
                        <div class="header-text">MEMBER</div>
                        <div class="header-text">CODE</div>
                        <div class="header-text">NAME</div>
                        <div class="header-text">STATUS</div>
                    </div>
                    <c:forEach items="${listStudent}" varStatus="loop" var="var">
                        <div class="header-line">
                            <div class="header-content counter">${loop.count}</div>
                            <div class="header-content"><img src="css/albert_einstein.jpg" alt="alt"/></div>
                            <div class="header-content">MEMBER</div>
                            <div class="header-content">${var.getSid()}</div>
                            <div class="header-content">${var.getSname()}</div>
                            <div class="header-content" style="display:flex">
                                Absent <input type="radio" name="status_${var.getSid()}" value="Absent" required>
                                Attend <input type="radio" name="status_${var.getSid()}" value="Present" required>

                            </div>
                        </div>

                    </c:forEach>   
                    <button style="margin-left: 90%; padding:30px" type="submit" class="btn btn-default">Apply</button>
                </div>     
            </form>
        </div>
    </body>
</html>
