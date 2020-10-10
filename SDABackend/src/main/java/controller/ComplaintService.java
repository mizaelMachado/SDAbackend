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
import dao.ComplaintDAO;
import model.Complaint;


@WebServlet("/api/complaint/*")
public class ComplaintService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
	   
    public ComplaintService() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// GET BY ID
		 String pathInfo = request.getPathInfo();
		 
	        if (pathInfo != null) {
	            String[] params = pathInfo.split("/");
	 
	            if (params.length > 0) {
	                Complaint com = ComplaintDAO.getComplaint(Integer.parseInt(params[1]));
	 
	                if (com != null) {
	                    JSONObject jsonObject = new JSONObject();
	 
	                    jsonObject.put("id", com.getId());
	                    jsonObject.put("offender", com.getOffender());
	                    jsonObject.put("infringement", com.getInfringement());
	                    jsonObject.put("smuggled_product", com.getSmuggled_Product());
	                    jsonObject.put("offense_description", com.getOffense_Description());
	                    jsonObject.put("url_document", com.getURL_Document());
	                    jsonObject.put("image_url", com.getImage_URL());
	                    
	 
	                    response.setContentType("application/json");
	                    response.setCharacterEncoding("UTF-8");
	                    response.getWriter().print(jsonObject.toString());
	                    response.getWriter().flush();
	                } 
	                return;
	            }
	        }
	        // GET ALL
	        List<Complaint> list = ComplaintDAO.getAllComplaint();
	 
	        try {
	            JSONArray jArray = new JSONArray();
	 
	            for (Complaint com : list) {
	                JSONObject jsonObject = new JSONObject();
	               
	 
	                jsonObject.put("id", com.getId());
                    jsonObject.put("offender", com.getOffender());
                    jsonObject.put("infringement", com.getInfringement());
                    jsonObject.put("smuggled_product", com.getSmuggled_Product());
                    jsonObject.put("offense_description", com.getOffense_Description());
                    jsonObject.put("url_document", com.getURL_Document());
                    jsonObject.put("image_url", com.getImage_URL());
 
	 
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
 
        Complaint com = null;
        JSONObject jsonObject = null;
 
        try {
            // Request
            jsonObject = new JSONObject(jb.toString());
            com = ComplaintDAO.addComplaint(jsonObject.getInt("id"), jsonObject.getString("offender"),jsonObject.getString("infringement"),jsonObject.getString("smuggledProduct"),jsonObject.getString("offenseDescription"),jsonObject.getString("URLDocument"),jsonObject.getString("imageURL"));
                       
            // Response
            jsonObject = new JSONObject();
            jsonObject.put("id", com.getId());
            jsonObject.put("offender", com.getOffender());
            jsonObject.put("infringement", com.getInfringement());
            jsonObject.put("smuggled_product", com.getSmuggled_Product());
            jsonObject.put("offense_description", com.getOffense_Description());
            jsonObject.put("url_document", com.getURL_Document());
            jsonObject.put("image_url", com.getImage_URL());
           
           
 
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
 
                Complaint com = null;
                JSONObject jsonObject = null;
 
                try {
                    // Request
                    jsonObject = new JSONObject(jb.toString());
                    com = ComplaintDAO.updateComplaint(jsonObject.getInt("id"), jsonObject.getString("offender"),jsonObject.getString("infringement"),jsonObject.getString("smuggledProduct"),jsonObject.getString("offenseDescription"),jsonObject.getString("URLDocument"),jsonObject.getString("imageURL"));
 
                    // Response
                    jsonObject = new JSONObject();
                    jsonObject.put("id", com.getId());
                    jsonObject.put("offender", com.getOffender());
                    jsonObject.put("infringement", com.getInfringement());
                    jsonObject.put("smuggled_product", com.getSmuggled_Product());
                    jsonObject.put("offense_description", com.getOffense_Description());
                    jsonObject.put("url_document", com.getURL_Document());
                    jsonObject.put("image_url", com.getImage_URL());
         
 
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
	                ComplaintDAO.deleteComplaint(Integer.parseInt(params[1]));
	 
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().flush();
	            }
	        }
	    }


}
