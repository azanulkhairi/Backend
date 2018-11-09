<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <%@ page isELIgnored="false" %>
    </head>
    <body>
        <h3>Welcome, Algalactical</h3>
        <form method="POST"   action="sendRequest">
             <table>
                <tr>
                    <td><label>Input Money</label></td>
                    <td><input name="word" type="text"/><br/> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>
         <table>
            <tr>
         		<td>your money : ${result}</td>
      		</tr>
         </table>
    </body>
</html>