<%-- 
    Document   : Login
    Created on : Sep 25, 2023, 11:41:00 PM
    Author     : myths
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/css_1.css">
    </head>
    <body>
        <div>
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

            </div>
            <div class="content ">
                <div class="col-md-6">
                    <div style="border: solid 1px #ccc; height: 260px;">
                        <fieldset>
                            <legend><span class="label label-default  btn-warning"><b>Phụ huynh</b></span></legend>
                            <div style="margin-top: -15px">
                                <a href="#">
                                    <h3>
                                        <span class="btn btn-primary"><b>Đăng nhập</b></span></h3>
                                </a>
                            </div>
                        </fieldset>
                    </div>
                </div>
                <div class="col-md-6">
                    <div style="border: solid 1px #ccc; height: 260px;">
                        <fieldset>
                            <legend><span class="label label-default  btn-warning"><b>Sinh viên, Giảng viên, Cán bộ ĐH-FPT</b></span></legend>
                            <br>
                            <div id="loginform" style="vertical-align: central">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <select name="ctl00$mainContent$ddlCampus" onchange="javascript:setTimeout('__doPostBack(\'ctl00$mainContent$ddlCampus\',\'\')', 0)" id="ctl00_mainContent_ddlCampus" class="btn btn-default">
                                            <option value="">Select Campus</option>
                                            <option selected="selected" value="3">FU-Hòa Lạc</option>
                                            <option value="4">FU-Hồ Chí Minh</option>
                                            <option value="5">FU-Đà Nẵng</option>
                                            <option value="6">FU-Cần Thơ</option>
                                            <option value="7">FU-Quy Nhơn</option>
                                        </select>
                                    </div>  
                                        <div class="col-xs-3">
                                        <form action="login" method="post">
                                            <label>Enter username</label> 
                                            <input type="text" name="username">
                                            <br>
                                            <label> password</label>
                                            <input type="password" name="password">
                                            <input style="margin-top: 10px" class="btn btn-warning"type="submit"> 
                                        </form>
                                    </div>
                                </div>
                                <div class="row">
                                    <span style="margin-left: 20px;">
                                        <b>Với sinh viên từ K19 đăng nhập với FEID</b>
                                    </span>
                                    <br>
                                    <span style="margin-left: 20px; color: red;padding:5px;" >
                                        <b>${fail}</b>
                                    </span>
                                </div>
                                
                            
                                <br>
                            </div>
                        </fieldset>
                    </div>
                </div>
            </div>
            <div class="footer">

            </div>

        </div>
    </body>
</html>
