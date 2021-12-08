package com.gl.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.gl.beans.Student;  

public class StudentDao {
	
	JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}   
	
	public int save(Student s){    
	    String sql="insert into STUDENTS(name,department,country) values('"+s.getName()+"','"+s.getDepartment()+"','"+s.getCountry()+"')";    
	    return template.update(sql);    
	}    
	
	public int update(Student s){    
	    String sql = "update STUDENTS set name='"+s.getName()+"', department='"+s.getDepartment()+"',country='"+s.getCountry()+"' where STUDENT_ID="+s.getStudentID()+"";    
	    return template.update(sql);    
	}    
	
	public int delete(int id){    
	    String sql="delete from STUDENTS where STUDENT_ID="+id+"";    
	    return template.update(sql);    
	}    
	
	public Student getStudentById(int id){    
	    String sql="select * from STUDENTS where STUDENT_ID=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));    
	}    
	
	public List<Student> getStudents(){    
	    return template.query("select * from STUDENTS",new RowMapper<Student>(){    
	        public Student mapRow(ResultSet rs, int row) throws SQLException {    
	        	Student e = new Student();    
	            e.setStudentID(rs.getInt(1));
	            e.setName(rs.getString(2));    
	            e.setDepartment(rs.getString(3));    
	            e.setCountry(rs.getString(4));    
	            return e;    
	        }    
	    });    
	}    

}
