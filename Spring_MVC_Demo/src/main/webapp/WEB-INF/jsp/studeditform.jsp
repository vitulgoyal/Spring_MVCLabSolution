<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Student</h1>
       <form:form method="POST" action="/Spring_MVC_Demo/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="studentID" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Department :</td>  
          <td><form:input path="department" /></td>
         </tr> 
         <tr>  
          <td>Country :</td>  
          <td><form:input path="country" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
