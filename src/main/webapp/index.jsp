<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Information</title>
</head>
<body>
		<table>
			<tr>
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Student DOB</th>
				<th>Student DOJ</th>
			</tr>
			<%
				URL obj = new URL("http://localhost:8080/JerseyTask/webapi/students");
				HttpURLConnection conn = (HttpURLConnection)obj.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("User-Agent", "Mozilaa/5.0");
				
				int responseCode = conn.getResponseCode();
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuilder jsonResponse = new StringBuilder();
				while((inputLine = in.readLine()) !=null){
					jsonResponse.append(inputLine);
				}
				JSONArray array = new JSONArray(jsonResponse.toString());	
				for(int i = 0;i<array.length();i++){
					JSONObject object = array.getJSONObject(i);
					%>
					<tr>
					<td><%=object.getString("studentid") %></td>
					<td><%=object.getString("studentname")%></td>
					<td><%=object.getString("studentdob")%></td>
					<td><%=object.getString("studentdoj")%></td>
					</tr>
				<%}
			%>
		</table>
	
</body>
</html>