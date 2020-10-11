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
import dao.LocationDAO;
import model.Complaint;
import model.Location;



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
	                Location loca = LocationDAO.getLocation(com.getId_location());
	                if (com != null) {
	                    JSONObject jsonObject = new JSONObject();
	 
	                    jsonObject.put("id", com.getId());
	                    jsonObject.put("offender", com.getOffender());
	                    jsonObject.put("infringement", com.getInfringement());
	                    jsonObject.put("smuggledProduct", com.getSmuggled_Product());
	                    jsonObject.put("offenseDescription", com.getOffense_Description());
	                    jsonObject.put("URLDocument", com.getURL_Document());
	                    jsonObject.put("imageURL", com.getImage_URL());
	                    jsonObject.put("cep", loca.getZip_code());
	                    jsonObject.put("city",loca.getCity());
	                    jsonObject.put("estado",loca.getState());
	                    jsonObject.put("bairro", loca.getNeighborhood());
	                    jsonObject.put("numero", loca.getNumber());
	                    jsonObject.put("referencia", loca.getReference());
	                    
	 
	                    response.setContentType("application/json");
	                    response.setCharacterEncoding("UTF-8");
	                    response.getWriter().print(jsonObject.toString());
	                    response.getWriter().flush();
	                } 
	                return;
	            }
	        }
	        // GET ALL
	        List<Complaint> list = ComplaintDAO.getAllComplaints();
	 
	        try {
	            JSONArray jArray = new JSONArray();
	 
	            for (Complaint com : list) {
	                JSONObject jsonObject = new JSONObject();
	                Location loca = LocationDAO.getLocation(com.getId_location());
	 
	                jsonObject.put("id", com.getId());
                    jsonObject.put("offender", com.getOffender());
                    jsonObject.put("infringement", com.getInfringement());
                    jsonObject.put("smuggled_product", com.getSmuggled_Product());
                    jsonObject.put("offense_description", com.getOffense_Description());
                    jsonObject.put("url_document", com.getURL_Document());
                    jsonObject.put("image_url", com.getImage_URL());
                    jsonObject.put("cep", loca.getZip_code());
                    jsonObject.put("city",loca.getCity());
                    jsonObject.put("estado",loca.getState());
                    jsonObject.put("bairro", loca.getNeighborhood());
                    jsonObject.put("numero", loca.getNumber());
                    jsonObject.put("ponto_referencia", loca.getReference());
 
	 
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
 
        Complaint complaint = null;
        JSONObject jsonObject = null;
 
        try {
            // Request
            jsonObject = new JSONObject(jb.toString());
            complaint = ComplaintDAO.addComplaint(jsonObject.getInt("id"), jsonObject.getString("infringement"),jsonObject.getString("offender") ,jsonObject.getString("smuggledProduct"), jsonObject.getString("offenseDescription"), jsonObject.getString("URLDocument"), jsonObject.getString("imageURL"), jsonObject.getInt("cpf_user"), jsonObject.getInt("id_location"));
           
            // Response
            jsonObject = new JSONObject();
            jsonObject.put("id", complaint.getId());
            jsonObject.put("infringement", complaint.getInfringement());
            jsonObject.put("offender", complaint.getOffender());
            jsonObject.put("smuggledProduct", complaint.getSmuggled_Product());
            jsonObject.put("offenseDescription", complaint.getOffense_Description());
            jsonObject.put("URLImage", complaint.getImage_URL());
            jsonObject.put("URLDocument", complaint.getURL_Document());
            jsonObject.put("cpf_user", complaint.getCpf_user());
            jsonObject.put("id_location", complaint.getId_location());

           
 
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
                    com = ComplaintDAO.updateComplaint(jsonObject.getInt("id"), jsonObject.getString("offender"),jsonObject.getString("infringement"),jsonObject.getString("smuggledProduct"),jsonObject.getString("offenseDescription"),jsonObject.getString("URLDocument"),jsonObject.getString("imageURL"),jsonObject.getInt("cpf_user"),jsonObject.getInt("id_location"));
                    Location loca = LocationDAO.getLocation(com.getId_location());   
                    // Response
                    jsonObject = new JSONObject();
                    jsonObject.put("id", com.getId());
                    jsonObject.put("offender", com.getOffender());
                    jsonObject.put("infringement", com.getInfringement());
                    jsonObject.put("smuggled_product", com.getSmuggled_Product());
                    jsonObject.put("offense_description", com.getOffense_Description());
                    jsonObject.put("url_document", com.getURL_Document());
                    jsonObject.put("image_url", com.getImage_URL());
                    jsonObject.put("cep", loca.getZip_code());
                    jsonObject.put("city",loca.getCity());
                    jsonObject.put("estado",loca.getState());
                    jsonObject.put("bairro", loca.getNeighborhood());
                    jsonObject.put("numero", loca.getNumber());
                    jsonObject.put("ponto_referencia", loca.getReference());
                   
 
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
	                LocationDAO.deleteLocation(Integer.parseInt(params[1]));
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().flush();
	            }
	        }
	    }


}
