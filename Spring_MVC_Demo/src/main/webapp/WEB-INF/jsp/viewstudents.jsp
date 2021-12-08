    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Students List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Department</th><th>Country</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="student" items="${list}"> 
    <tr>
    <td>${student.studentID}</td>
    <td>${student.name}</td>
    <td>${student.department}</td>
    <td>${student.country}</td>
    <td><a href="studeditform/${student.studentID}">Edit</a></td>
    <td><a href="deleteemp/${student.studentID}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="studentform">Add New Student</a>