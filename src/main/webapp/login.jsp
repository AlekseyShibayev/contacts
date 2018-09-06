
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <%@include file="WEB-INF/jspf/css.jspf"%>
</head>
<body>

<input id="saveLogin" type="text" value="test" onclick="">
<br>
<input id="savePassword" type="text" value="123" onclick="">
<br>
<p>Try login/password: test/123</p>
<form>
    <p><input onclick="login()" type="button" value="Login" id="login_button"></p>
</form>
<script type="text/javascript">

    function login() {
        var entry = {login: $('#saveLogin').val(), password: $('#savePassword').val()};
        $.ajax({
            url: '/loginCheck.do',
            data: {entry: JSON.stringify(entry)},
            success: function (response) {
                if (response == "1") {
                    location.reload();
                }
            }
        })
    }

</script>
</body>
</html>
