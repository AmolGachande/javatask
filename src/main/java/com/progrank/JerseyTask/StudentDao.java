package com.progrank.JerseyTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.json.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;
public class StudentDao {

	public static JSONArray getStudentArray() {
		JSONArray jsonarray = new JSONArray();
		ResultSet rs;	
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student-project","root","root");
				System.out.println("hello");
				String sql = "SELECT * FROM student";
				PreparedStatement st = conn.prepareStatement(sql);
				rs = st.executeQuery();
				while(rs.next()) {
					JSONObject object = new JSONObject();
					object.put("studentid", rs.getString("StudentNumber"));
					object.put("studentname", rs.getString("studentName"));
					object.put("studentdob", rs.getString("studentDOB"));
					object.put("studentdoj", rs.getString("studentDOJ"));
					jsonarray.put(object);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println(jsonarray);
		return jsonarray;
	}
	
	
	
}
