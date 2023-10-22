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
        <input type="hidden" name="iid" value="${iid}">
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
                <a class="space-content" href="TimeableforInstructorController">Timeable</a>
                <text>Attandance </text>
            
            </div>
            <div class="space-right">
                <a class="space-content-right" href="mssv"><div class="btn btn-default">Sonnt5</div> </a>
                <a class="space-content-right" href="LogoutController"><div class="btn btn-default">Logout </div></a>
                <a class="space-content-right" href="#"><div class="btn btn-default">CAMPUS:HOA LAC</div></a>
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
                <td rowspan="${total+3}"></td>
                <td rowspan="${total+3}"></td>


                <c:forEach items="${listGroup}" var="var">
                    <tr > 
                        <td class="table-row-fix"><a href="listStudentInGroupInCourse?gid=${var.getGid()}&cid=${cid}">${var.getGid()}</a></td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>





            <h1>Attendance Table</h1>
            <span>Chú thích:
                <span>Chưa vắng buổi nào <div class="square-0"> </div> 
                    <br></span>Vắng 1 buổi <div class="square-1"></div></span>
            <span>Vắng 2 buổi <div class="square-2"> </div></span>
            <span>Vắng 3 buổi <div class="square-3"> </div></span>
            <span>Vắng 4 buổi<div class="square-4"> </div> </span>
            <span>Cook <div class="square-5"> </div> </span>
            <table>
                <tr>
                    <th class="header-text" >Mã SV</th>
                    <th class="header-text">Tên SV</th>
                    <th class="header-text">% Vắng</th>       
                        <c:forEach var="record" items="${listTime}">
                        <th class="header-text" style="text-align: center;">${record.getFormattedClassDate()}</th>
                        </c:forEach>



                </tr>
                <c:forEach var="record" items="${studentAndStatusList}">
                    <tr>
                        <c:choose>
                            <c:when test="${record.getAttendancePercentage()==0}">
                                <td class="square-0">${record.getStudentID()}</td>
                                <td class="square-0">${record.getStudentName()}</td>
                                <td class="square-0">${record.getAttendancePercentage()}</td>   
                            </c:when>
                            <c:when test="${record.getAttendancePercentage()==5}">
                                <td class="square-1">${record.getStudentID()}</td>
                                <td class="square-1" >${record.getStudentName()}</td>
                                <td class="square-1">${record.getAttendancePercentage()}</td>   
                            </c:when>
                            <c:when test="${record.getAttendancePercentage()==10}">
                                <td class="square-2">${record.getStudentID()}</td>
                                <td class="square-2">${record.getStudentName()}</td>
                                <td class="square-2">${record.getAttendancePercentage()}</td>   
                            </c:when>
                            <c:when test="${record.getAttendancePercentage()==15}">
                                <td class="square-3">${record.getStudentID()}</td>
                                <td class="square-3">${record.getStudentName()}</td>
                                <td class="square-3">${record.getAttendancePercentage()}</td>   
                            </c:when>
                            <c:when test="${record.getAttendancePercentage()==20}">
                                <td class="square-4">${record.getStudentID()}</td>
                                <td class="square-4">${record.getStudentName()}</td>
                                <td class="square-4">${record.getAttendancePercentage()}</td>   
                            </c:when>
                            <c:when test="${record.getAttendancePercentage()>20}">
                                <td class="square-5">${record.getStudentID()}</td>
                                <td class="square-5">${record.getStudentName()}</td>
                                <td class="square-5">${record.getAttendancePercentage()}</td>   
                            </c:when>
                        </c:choose> 
                        <c:forEach items="${attendanceData}" var="item">
                            <c:choose>
                                <c:when test="${item.getStudentID() == record.getStudentID()}">
                                    <c:choose>
                                        <c:when test="${item.getAttandanceStatus() eq 'Absent'}">
                                            <td style="color:red;text-align: center;">A</td>
                                        </c:when>
                                        <c:when test="${item.getAttandanceStatus() eq 'Present'}">
                                            <td style="color:green;text-align: center;">P</td>
                                        </c:when>
                                        <c:when test="${item.getAttandanceStatus() eq 'Present'}">
                                            <td style="color:black;text-align: center;">-</td>
                                        </c:when>
                                    </c:choose>

                                </c:when>
                                <c:otherwise>
                                    <!--  <td>...</td> <!-- Giá trị mặc định nếu không tìm thấy comment --> 
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                    </tr>
                </c:forEach>

            </table>

        </div>
    </body>
</html>
