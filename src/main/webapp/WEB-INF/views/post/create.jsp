<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<form  action="<c:url value='/save'/>" method='POST'>
    <div class="card-body">
        <table class="table">
            <tr>
                <td>Тема:</td>
                <td><input type='text' name='name'></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><input type='text' name='description'></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
