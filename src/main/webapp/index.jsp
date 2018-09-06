<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
  <%@include file="WEB-INF/jspf/css.jspf"%>
  <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
</head>
<body>
<p>Please write something. And push the button.</p>
<input id="saveTelephone" type="text" value="79788615101" onclick="">
<input id="saveName" type="text" value="Aleksey" onclick="">
<p id="statusInsert">Try as in the example: 79788615101 Aleksey</p>

<form>
  <p><input onclick="saveContact()" type="button" value="   Save    "></p>
</form>
<form>
  <p><input onclick="showAllContacts()" type="button" value=" Show all "></p>
</form>
<form>
  <p><input onclick="deleteAllContacts()" type="button" value="Delete all"></p>
</form>
<form>
  <p><input onclick="logout()" type="button" value="Logout"></p>
</form>
<script type="text/javascript">

    function deleteAllContacts() {
        $.ajax({
            url: '/deleteAll.do',
            data: {},
            success: function (response) {
                if (response == "2") {
                    $('#statusInsert').text("Oops, something wrong with database.")
                } else {
                    $('#statusInsert').text("All contacts have been deleted.");
                    $("dir").remove(".select");
                }
            }
        });
    }

    function saveContact() {
        var entry = {telephone: $('#saveTelephone').val(), name: $('#saveName').val()};
        $.ajax({
            url: '/insert.do',
            data: {entry: JSON.stringify(entry)},
            dataType: "json",
            success: function (response) {
                if (response == "0") {
                    $('#statusInsert').text("This contact  already exists.")
                }
                else if (response == "1") {
                    $('#statusInsert').text("Oops. Try as in the example: 79788615101 Aleksey")
                }
                else if (response == "2") {
                    $('#statusInsert').text("Oops, something wrong with database.")
                }
                else {
                    $('#statusInsert').text("Contact " + response.telephone + " " + response.name + " has been created.")
                }
            }
        });
    }

    function showAllContacts() {
        $.ajax({
            url: '/selectAll.do',
            data: {},
            dataType: "json",
            success: function (response) {
                if (response == "1") {
                    $('#statusInsert').text("No contacts yet")
                } else if (response == "2") {
                    $('#statusInsert').text("Oops, something wrong with database.")
                } else {
                    $("dir").remove(".select");
                    $('#statusInsert').text("All contacts: ");
                    for (var i = 0; i < response.length; i++) {
                        $('body').append("<dir class='select'>" + response[i].telephone + " " + response[i].name + "</dir>");
                    }
                }
            }
        });
    }

    function logout() {
        $.ajax({
            url: '/logout.do',
            data: {},
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