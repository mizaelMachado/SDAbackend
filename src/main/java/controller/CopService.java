package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.CopDAO;
import dao.UserDAO;
import model.Cop;
import model.User;


@WebServlet("/api/cop/*")
public class CopService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
	   
    public CopService() {
    	super();
	   // TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		// GET BY ID
		String pathInfo = request.getPathInfo();
			 
	 	if (pathInfo != null) {
	 		String[] params = pathInfo.split("/");
		 
	 		if (params.length > 0) {
		       Cop cop = CopDAO.getCop(Integer.parseInt(params[1]));
		       User user = UserDAO.getUser(Integer.parseInt(params[1]));
                if (cop != null) {
                    JSONObject jsonObject = new JSONObject();
		
                    
		            jsonObject.put("cpf", cop.getCpf());
			        jsonObject.put("office", cop.getOffice());
			        jsonObject.put("identification", cop.getIdentifier());
			        jsonObject.put("departament", cop.getDepartament());
		            jsonObject.put("email", user.getEmail());
		            jsonObject.put("name", user.getName());
		            
		            response.setContentType("application/json");
		            response.setCharacterEncoding("UTF-8");
		            response.getWriter().print(jsonObject.toString());
		            response.getWriter().flush();
		         } 
	           return;
            }
        }
	 	
		// GET ALL
		List<Cop> list = CopDAO.getAllCops();
	
		try {
			JSONArray jArray = new JSONArray();
		 
		    for (Cop cop : list) {
		    	User user = UserDAO.getUser(cop.getCpf());
		    		
				    	JSONObject jsonObject = new JSONObject();
				        //Gson jsonObject = new Gson();
				 
				        jsonObject.put("cpf", cop.getCpf());
				        jsonObject.put("office", cop.getOffice());
				        jsonObject.put("identification", cop.getIdentifier());
				        jsonObject.put("departament", cop.getDepartament());
				        jsonObject.put("email", user.getEmail());
				        jsonObject.put("name", user.getName());
				 
				        jArray.put(jsonObject);
		    }
		 
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().print(jArray.toString());
		    response.getWriter().flush();
		  } catch (Exception e) {
		 
		  }
		
		}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
        }
 
        Cop cop = null;
        JSONObject jsonObject = null;
 
        try {
            // Request
            jsonObject = new JSONObject(jb.toString());

            cop = CopDAO.addCop( jsonObject.getInt("my_cpf"), jsonObject.getString("office"),jsonObject.getInt("identification"),jsonObject.getString("departament"));
            User user = UserDAO.getUser(jsonObject.getInt("cpf")); 
     
            		// Response
		     jsonObject = new JSONObject();
			 jsonObject.put("cpf", cop.getCpf());
			 jsonObject.put("name", user.getName());
			 jsonObject.put("email", user.getEmail());
			 jsonObject.put("password", user.getPassword());
			 jsonObject.put("office", cop.getOffice());
			 jsonObject.put("identification", cop.getIdentifier());
			 jsonObject.put("departament", cop.getDepartament());
       
 
        } catch (JSONException e) {
        }
 
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jsonObject.toString());
        response.getWriter().flush();
		
		doGet(request, response);
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // UPDATE BY ID
        String pathInfo = request.getPathInfo();
 
        if (pathInfo != null) {
            String[] params = pathInfo.split("/");
 
            if (params.length > 0) {
                StringBuffer jb = new StringBuffer();
                String line = null;
                try {
                    BufferedReader reader = request.getReader();
                    while ((line = reader.readLine()) != null)
                        jb.append(line);
                } catch (Exception e) {
                }
 
                Cop cop = null;
               
                JSONObject jsonObject = null;
 
                try {
                    // Request
                    jsonObject = new JSONObject(jb.toString());
                    cop = CopDAO.addCop( jsonObject.getInt("cpf"), jsonObject.getString("office"),jsonObject.getInt("identification"),jsonObject.getString("departament"));
                    User user = UserDAO.getUser(jsonObject.getInt("cpf")); 
                    
		            		// Response
				     jsonObject = new JSONObject();
					 jsonObject.put("cpf", cop.getCpf());
					 jsonObject.put("name", user.getName());
					 jsonObject.put("email", user.getEmail());
					 jsonObject.put("password", user.getPassword());
					 jsonObject.put("office", cop.getOffice());
					 jsonObject.put("identification", cop.getIdentifier());
					 jsonObject.put("departament", cop.getDepartament());
		                   
         
 
                } catch (JSONException e) {
                }
 
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(jsonObject.toString());
                response.getWriter().flush();
            }
        }
    }
	
	 protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // DELETE BY ID
	        String pathInfo = request.getPathInfo();
	 
	        if (pathInfo != null) {
	            String[] params = pathInfo.split("/");
	 
	            if (params.length > 0) {
	                CopDAO.deleteCop(Integer.parseInt(params[1]));
	                UserDAO.deleteUser(Integer.parseInt(params[1]));
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().flush();
	            }
	        }
	    }
		
}
