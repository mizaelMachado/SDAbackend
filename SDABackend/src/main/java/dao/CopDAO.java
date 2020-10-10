package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cop;
import model.User;

public class CopDAO {

	
	  private static final Map<Integer, Cop> copMap = new HashMap<Integer, Cop>();
	  
	  
	    static {
	        initUsers();
	    }
	 
	    private static void initUsers() {
	    	
	        User user1 = new User(165454654, "almada", "jhon@gmail","1234");
	        Cop cop1 = new Cop(user1,"perito",121235,"DT");
	        
	        User user2 = new User(25454, "anderson", "mizael.info@gmail","1234");
	        Cop cop2 = new Cop(user2,"perito",123453,"DT");
	        
	        User user3 = new User(365465, "alex", "ines@gmail","1234");
	        Cop cop3 = new Cop(user3,"perito",125498,"DT");
	 
	        copMap.put(cop1.getIdentifier(), cop1);
	        copMap.put(cop2.getIdentifier(), cop2);
	        copMap.put(cop3.getIdentifier(), cop3);
	    }
	 
	    public static Cop getCop(int identifier) {
	        return copMap.get(identifier);
	    }
	 
	    public static Cop getCopByIdentifier(int Identifier) {
	        List<Cop> list = getAllCops();
	 
	        for (Cop cop : list) {
	            if (cop.getIdentifier()==Identifier) {
	                return cop;
	            }
	        }
	 
	        return null;
	    }
	 
	    public static Cop addCop(User user ,String office,int identifier,String departament) {
	        Cop cop = new Cop( user , office, identifier, departament);
	        copMap.put(cop.getCpf(), cop);
	        return cop;
	    }
	 
	    public static Cop updateCop(User user ,String office,int identifier,String departament) {
	        Cop cop = new Cop( user , office, identifier, departament);
	        copMap.put(cop.getIdentifier(), cop);
	        return cop;
	    }
	 
	    public static void deleteCop(int identifier) {
	        if (copMap.containsKey(identifier)) {
	            copMap.remove(identifier);
	        }
	    }
	 
	    public static List<Cop> getAllCops() {
	        return new ArrayList<Cop>(copMap.values());
	    }
	
	
}
