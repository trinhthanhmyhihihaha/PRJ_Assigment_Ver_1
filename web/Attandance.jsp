<%-- 
    Document   : Attandance
    Created on : Sep 30, 2023, 4:38:23 PM
    Author     : myths
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/css_2.css">
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            th {
                background-color: #f2f2f2;
            }

            .day-label {
                font-weight: bold;
            }
        </style>
        A
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
                <a class="space-content" href="Group">Group  </a>
                <a  class="space-content" href="Mark">Mark report   </a>
                <a class="space-content" href="Attandance">View schedule  </a>
                <text>Attandance  </text>
            </div>
            <div class="space-right">
                <a class="space-content-right" href="mssv"><div class="btn btn-default">1234${mssv}</div> </a>
                <a class="space-content-right" href="Logout"><div class="btn btn-default">Logout </div></a>
                <a class="space-content-right" href="Logout"><div class="btn btn-default">CAMPUS:HOA LAC</div></a>
            </div>
        </div>
        <div>

            <table>
                <table>
                    <tbody>
                        <tr>
                            <td valign="top">
                                <h3>Select a campus/program, term, course ...</h3>
                                <table summary="Select a course">
                                    <thead>
                                        <tr>
                                            <th scope="col">Campus/program</th>
                                            <th scope="col">Term</th>
                                            <th scope="col">Course</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td valign="top">
                                                <div id="ctl00_mainContent_divCampus">
                                                    <table>
                                                        <tbody>
                                                            <tr>
                                                                <td><b>FU-HL</b></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </td>
                                            <td valign="top">
                                                <div id="ctl00_mainContent_divTerm">
                                                    <table>
                                                        <tbody>
                                                            <tr>
                                                            </tr>
                                                            <!-- Các dòng term khác ở đây -->
                                                            <tr>
                                                                <td><b>Fall2023</b></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </td>
                                            <td valign="top">
                                                <div id="ctl00_mainContent_divCourse">
                                                    <table>
                                                        <tbody>
                                                        <c:forEach items="${courselist}" var="var">
    <tr>
        <td><b><a href="coursedetail?MaKhoaHoc=${var.MaKhoaHoc}&MaLichHoc=${var.MaLichHoc}">${var.MaKhoaHoc} start (${var.NgayHoc})</a></b></td>
    </tr>
                                                        </c:forEach>

                                                        <!-- Các dòng course khác ở đây -->
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td valign="top">
                                <h3>... then see report<br><br></h3>
                                <table class="table table-bordered table1">
                                    <tbody>
                                        <tr></tr>
                                    </tbody>
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Date</th>
                                            <th>Slot</th>
                                            <th>Room</th>
                                            <th>Lecturer</th>
                                            <th>Group Name</th>
                                            <th>Attedance status</th>
                                            <th>Lecturer's comment</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- Các hàng dữ liệu ở đây -->
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td colspan="7"><b>Absent</b>: 5% absent so far (1 absent on 20 total).</td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>

        </div>

    </body>
</html>
