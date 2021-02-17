package com.progrank.JerseyTask;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
@Path("students")
public class StudentResource {
	StudentDao dao = new StudentDao();
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("getStudent")
	public String getStudent(){
		JSONArray jsonarray = new JSONArray();
		jsonarray = StudentDao.getStudentArray();
		String jsonData = jsonarray.toString();
		return jsonData;
}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("addStudent")
	public String insertStudent(){
		JSONArray jsonarray = new JSONArray();
		jsonarray = StudentDao.getStudentArray();
		String jsonData = jsonarray.toString();
		return jsonData;
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("addStudent")
	public String deleteStudent(){
		JSONArray jsonarray = new JSONArray();
		jsonarray = StudentDao.getStudentArray();
		String jsonData = jsonarray.toString();
		return jsonData;
	}
	
}
