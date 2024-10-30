<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ralat 404</title>
        <s:include value="/inc/head.jsp"></s:include>
        <style>
            body
            {
                background-image: url('props/img/chalkboard.jpg');
                background-repeat: repeat;
                
            }
            h4{
                color:white;
            }
            a{
                color: yellow;
            }
            a:hover{
                color:gray;
            }
            .err{
                color:white;
                font-size:120px;                               
                font-weight: 700;
            }
            @-moz-keyframes neonglow {
    20%, 70% {
        color: #000;
        text-shadow: none;
    }
    25%, 50%, 75%, 95% {
        color: #fff;
        text-shadow: 0 0 10px #fff, 0 0 20px #ff0, 0 0 30px #ff0;
    }
    55% {
        color: #222;
        text-shadow: none;
    }
}
@-moz-keyframes ontheblink {
    21%, 39%, 45%, 47%, 53% {
        color: #000;
        text-shadow: none;
    }
    26%, 38%, 40%, 44%, 46%, 48% {
        color: #fff;
        text-shadow: 0 0 10px #fff, 0 0 20px #ff0, 0 0 30px #ff0;
    }
}
@-ms-keyframes neonglow {
    20%, 70% {
        color: #000;
        text-shadow: none;
    }
    25%, 50%, 75%, 95% {
        color: #fff;
        text-shadow: 0 0 10px #fff, 0 0 20px #ff0, 0 0 30px #ff0;
    }
    55% {
        color: #222;
        text-shadow: none;
    }
}
@-ms-keyframes ontheblink {
    21%, 39%, 45%, 47%, 53% {
        color: #000;
        text-shadow: none;
    }
    26%, 38%, 40%, 44%, 46%, 48% {
        color: #fff;
        text-shadow: 0 0 10px #fff, 0 0 20px #ff0, 0 0 30px #ff0;
    }
}
@-webkit-keyframes neonglow {
    20%, 70% {
        color: #000;
        text-shadow: none;
    }
    25%, 50%, 75%, 95% {
        color: white;
        text-shadow: 0 0 10px #fff, 0 0 20px #ff0, 0 0 30px white;
    }
    55% {
        color: white;
        text-shadow: none;
    }
}
@-webkit-keyframes ontheblink {
    21%, 39%, 45%, 47%, 53% {
        color: #000;
        text-shadow: none;
    }
    26%, 38%, 40%, 44%, 46%, 48% {
        color: #fff;
        text-shadow: 0 0 10px #fff, 0 0 20px #ff0, 0 0 30px #ff0;
    }
}
span {
    -moz-animation: neonglow 10s infinite;
    -ms-animation: neonglow 10s infinite;
    -webkit-animation: neonglow 10s infinite;
    color: white;
}
.out {
    -moz-animation: ontheblink 10s infinite;
    -ms-animation: ontheblink 10s infinite;
    -webkit-animation: ontheblink 10s infinite;
}
        </style>
    </head>
    <body>
            <div class="container" style="vertical-align:middle">
                <div class="row" >
                    <div class="col-12">
                        <s:actionerror/>
                        <br/>
                        <h1 class="err text-center"><span>RALAT</span> <span class="out">404</span></h1>
                        <h4 class="text-center">Halaman tidak dapat dijumpai. Sila klik di <a href="<%=request.getContextPath()%>/">sini</a> untuk kembali ke menu utama.</h4>
                        
                    </div>
                    <!-- End unit-75 -->           
                </div>
                <!-- End units-row --> 
            </div>
            <!-- End wrapper -->        
        <s:include value="/inc/footer.jsp"></s:include>
    </body>
</html>
