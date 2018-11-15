<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <%@ page isELIgnored="false" %>
    </head>
    <body>
        <h3>Welcome, Algalactical</h3>
		<table>
			<tr>
			<td><c:forEach var="entry" items="${map}">
				<tr>
					<td>${entry.key}</td>
					<c:forEach var="info" items="${entry.value}">
					<td>${info}</td>
					</c:forEach>
				</tr>
			</c:forEach>						
			</td>
			<td>
			<c:forEach var="spre" items="${prec}">
				<tr>
					<td>${spre.key}</td>
					<c:forEach var="data" items="${spre.value}">
					<td>${data}</td>
					</c:forEach>
				</tr>
			</c:forEach>
			</td>
			<tr>
			<tr>
				<td>
					 <form method="POST"   action="reset">
							 <input type="submit" value="reset"/>
					 </form>
				</td>
			</tr>
		</table>
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