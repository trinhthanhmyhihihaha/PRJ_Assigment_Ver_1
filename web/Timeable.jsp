<%-- 
    Document   : Timeable
    Created on : Sep 26, 2023, 2:12:51 PM
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
        <script>
            function submitForm() {
// Lấy giá trị được chọn trong select box
                var selectedYear = document.querySelector('select[name="selectedYear"]').value;

// Gán giá trị vào một input ẩn trong form (nếu cần)
// document.querySelector('input[name="selectedYear"]').value = selectedYear;

// Gửi form
                document.forms["selectYear"].submit(); // Thay "yourFormName" bằng tên thực sự của form
            }
        </script>
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
                <a class="space-content" href="Attandance">Attandance   </a>
                <text>View schedule </text>
            </div>
            <div class="space-right">
                <a class="space-content-right" href="mssv"><div class="btn btn-default">1234${mssv}</div> </a>
                <a class="space-content-right" href="Logout"><div class="btn btn-default">Logout </div></a>
                <a class="space-content-right" href="Logout"><div class="btn btn-default">CAMPUS:HOA LAC</div></a>
            </div>
        </div>

        <table>
            <thead>
                <tr>
                    <th rowspan="2">
                        <span class="auto-style1"><strong>Year</strong></span>
                        <select name="selectedYear"id="selectedYear"  ">
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                            <option value="2025">2025</option>
                        </select>
                        <br>
                        <form name="selectYear" action="selectYear" method="get">
                            <select name="selectWeek" id="weekSelector "onchange="submitForm()">
                                <c:forEach items="${weekList}" var="week">
                                    <option value ="${week.startWeek}--${week.endWeek}">${week.startWeek} -> ${week.endWeek}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" style="display: none">
                        </form>

                    </th>
                    <th align="center">Mon</th>
                    <th align="center">Tue</th>
                    <th align="center">Wed</th>
                    <th align="center">Thu</th>
                    <th align="center">Fri</th>
                    <th align="center">Sat</th>
                    <th align="center">Sun</th>
                </tr>
                <tr>
               
                    <c:forEach items="${daylist}" var="var">
                        <th align="center">${var.day}/${var.month}</th>
                        </c:forEach>                
                </tr>
            </thead>
            <tbody>
                <!-- Slot 0 -->
                <tr>
                    <td>Slot 0</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <!-- Slot 1 -->
                <tr>
                    <td>Slot 1</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <!-- Add more slot rows as needed -->
                <tr>
                    <td>Slot 2</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 3</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 4</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 5</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 6</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 7</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 8</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 9</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 10</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 11</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
                <tr>
                    <td>Slot 12</td>
                    <td><!-- Add your content here for Slot 1 on Monday --></td>
                    <td><!-- Add your content here for Slot 1 on Tuesday --></td>
                    <td><!-- Add your content here for Slot 1 on Wednesday --></td>
                    <td><!-- Add your content here for Slot 1 on Thursday --></td>
                    <td><!-- Add your content here for Slot 1 on Friday --></td>
                    <td><!-- Add your content here for Slot 1 on Saturday --></td>
                    <td><!-- Add your content here for Slot 1 on Sunday --></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
