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
        <input type="text" name="${cid}" value="${cid}" >
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
                <a class="space-content" href="Schedule">View schedule  </a>
                <a  class="space-content" href="Mark">Mark report   </a>
                <a class="space-content" href="Attandance">Attandance   </a>
                <text>Group </text>
            </div>
            <div class="space-right">
                <a class="space-content-right" href="mssv"><div class="btn btn-default">Sonnt5</div> </a>
                <a class="space-content-right" href="LogoutController"><div class="btn btn-default">Logout </div></a>
                <a class="space-content-right" href="Logout"><div class="btn btn-default">CAMPUS:HOA LAC</div></a>
            </div>
        </div>
        <div class="content">

            <h2>Select a course,then a group...</h2>
            <table  class="table" border="1">
                <thead class="first-child-tr">
                    <tr>
                        <th>CAMPUS</th>
                        <th>COURSE</th>
                        <th>GROUP</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Dòng 1 -->
                <td rowspan="${total+1}">FU-HL</td>
                
                <c:forEach items="${courselist}" var="item">
                    <tr>
                        <td><a href="groupInCourse?cid=${item.getCid()}">${item.getCid()}</a></td>


                    </tr>
                </c:forEach>
                   <td rowspan="${total+1}"></td>
                     <td rowspan="${total+1}"></td>
                
               
                <c:forEach items="${listGroup}" var="var">
                    <tr > 
                        <td class="table-row-fix"><a href="listStudentInGroupInCourse?gid=${var.getGid()}&cid=${cid}&iid=${iid}">${var.getGid()}</a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </body>
</html>
