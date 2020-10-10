package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Complaint;


public class ComplaintDAO {
	

	  private static final Map<Integer, Complaint> complaintMap = new HashMap<Integer, Complaint>();
	  
	  
	    static {
	        initUsers();
	    }
	 
	    private static void initUsers() {
	    	
	        Complaint com1 = new Complaint(1,"Jorge Amado de Sousa","venda de drogas ilícitas","cocaína","Encontrado com alta carga vendendo no bairro do Saral","","https://www.google.com/imgres?imgurl=http%3A%2F%2Fdocplayer.com.br%2Fdocs-images%2F64%2F51472368%2Fimages%2F13-0.jpg&imgrefurl=http%3A%2F%2Fdocplayer.com.br%2F51472368-1-uso-do-medicamento-9-2-perigos-da-automedicacao-venda-ilicita-de-medicamentos-medicamentos-genericos-17-indice.html&tbnid=99NEy3ojdyK_GM&vet=12ahUKEwjQw9OdmaTsAhVHNLkGHYOyCgUQMygFegUIARCcAQ..i&docid=LV5bjYpV3iMjpM&w=870&h=623&itg=1&q=venda%20ilicita%20de%20medicamentos&client=firefox-b-d&ved=2ahUKEwjQw9OdmaTsAhVHNLkGHYOyCgUQMygFegUIARCcAQ");
	        
	        Complaint com2 = new Complaint(2,"Maria Érika Rodrigues","venda de armas","fuzis","encontrada com carro cheio de fuzis para vender aos traficantes de Pakatu","","https://s2.glbimg.com/n4o02p0b8sdY5r81Hi7N_39NjiA=/0x0:960x1280/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2018/K/H/dNM6HKR2C21uDc93ROMA/whatsapp-image-2018-10-23-at-20.53.28-2-.jpeg");
	        
	        
	        
	 
	        
	        complaintMap.put(com1.getId(), com1);
	        complaintMap.put(com2.getId(), com2);
	    }
	 
	    public static Complaint getComplaint(int id) {
	        return complaintMap.get(id);
	    }
	 
	    public static Complaint getComplaintById(int id) {
	        List<Complaint> list = getAllComplaint();
	 
	        for (Complaint complaint : list) {
	            if (complaint.getId()==id) {
	                return complaint;
	            }
	        }
	 
	        return null;
	    }
	 
	    public static Complaint addComplaint(int id,String offender,String infringement,String smuggledProduct,String offenseDescription,String URLDocument,String imageURL) {
	    	Complaint com = new Complaint( id , offender , infringement , smuggledProduct ,  offenseDescription , URLDocument ,  imageURL );
	        complaintMap.put(com.getId(), com);
	        return com;
	    }
	    
	    public static Complaint updateComplaint(int id,String offender,String infringement,String smuggledProduct,String offenseDescription,String URLDocument,String imageURL) {
	        Complaint com = new Complaint( id , offender , infringement , smuggledProduct ,  offenseDescription , URLDocument ,  imageURL );
	        complaintMap.put(com.getId(), com);
	        return com;
	    }
	 
	    public static void deleteComplaint(int identifier) {
	        if (complaintMap.containsKey(identifier)) {
	        	complaintMap.remove(identifier);
	        }
	    }
	 
	    public static List<Complaint> getAllComplaint() {
	        return new ArrayList<Complaint>(complaintMap.values());
	    }
	


}
