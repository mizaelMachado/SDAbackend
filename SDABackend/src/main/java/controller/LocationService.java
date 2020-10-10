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
import dao.LocationDAO;
import model.Location;

@WebServlet("/api/location/*")
public class LocationService extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
	   
    public LocationService() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// GET BY ID
		 String pathInfo = request.getPathInfo();
		 
	        if (pathInfo != null) {
	            String[] params = pathInfo.split("/");
	 
	            if (params.length > 0) {
	                Location loc = LocationDAO.getLocation(Integer.parseInt(params[1]));
	 
	                if (loc != null) {
	                    JSONObject jsonObject = new JSONObject();
	 
	                    jsonObject.put("id", loc.getId());
	                    jsonObject.put("zip_code", loc.getZip_code());
	                    jsonObject.put("city", loc.getCity());
	                    jsonObject.put("state", loc.getState());
	                    jsonObject.put("neighborhood", loc.getNeighborhood());
	                    jsonObject.put("number", loc.getNumber());
	                    jsonObject.put("reference", loc.getReference());
	                   
	 
	                    response.setContentType("application/json");
	                    response.setCharacterEncoding("UTF-8");
	                    response.getWriter().print(jsonObject.toString());
	                    response.getWriter().flush();
	                } 
	                return;
	            }
	        }
	        // GET ALL
	        List<Location> list = LocationDAO.getAllLocation();
	 
	        try {
	            JSONArray jArray = new JSONArray();
	 
	            for (Location loc : list) {
	                JSONObject jsonObject = new JSONObject();
	                //Gson jsonObject = new Gson();
	 
	                jsonObject.put("id", loc.getId());
                    jsonObject.put("zip_code", loc.getZip_code());
                    jsonObject.put("city", loc.getCity());
                    jsonObject.put("state", loc.getState());
                    jsonObject.put("neighborhood", loc.getNeighborhood());
                    jsonObject.put("number", loc.getNumber());
                    jsonObject.put("reference", loc.getReference());
	 
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
 
        Location loc = null;
        JSONObject jsonObject = null;
 
        try {
            // Request
            jsonObject = new JSONObject(jb.toString());
            loc = LocationDAO.addLocation(jsonObject.getInt("id"), jsonObject.getInt("zip_code"),jsonObject.getString("city"),jsonObject.getString("state"),jsonObject.getString("neighborhood"),jsonObject.getString("number"),jsonObject.getString("reference"));
      //int id,int zip_code,String city,String state,String neighborhood,String number,String reference
            // Response
            jsonObject.put("id", loc.getId());
            jsonObject.put("zip_code", loc.getZip_code());
            jsonObject.put("city", loc.getCity());
            jsonObject.put("state", loc.getState());
            jsonObject.put("neighborhood", loc.getNeighborhood());
            jsonObject.put("number", loc.getNumber());
            jsonObject.put("reference", loc.getReference());
           
           
 
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
 
                Location loc = null;
                JSONObject jsonObject = null;
 
                try {
                    // Request
                    jsonObject = new JSONObject(jb.toString());
                    loc = LocationDAO.updateLocation(jsonObject.getInt("id"), jsonObject.getInt("zip_code"),jsonObject.getString("city"),jsonObject.getString("state"),jsonObject.getString("neighborhood"),jsonObject.getString("number"),jsonObject.getString("reference"));
 
                    // Response
                    jsonObject = new JSONObject();
                    jsonObject.put("id", loc.getId());
                    jsonObject.put("zip_code", loc.getZip_code());
                    jsonObject.put("city", loc.getCity());
                    jsonObject.put("state", loc.getState());
                    jsonObject.put("neighborhood", loc.getNeighborhood());
                    jsonObject.put("number", loc.getNumber());
                    jsonObject.put("reference", loc.getReference());
         
 
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
	                LocationDAO.deleteLocation(Integer.parseInt(params[1]));
	 
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().flush();
	            }
	        }
	    }




}
