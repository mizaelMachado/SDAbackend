package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import model.Location;


public class LocationDAO {


	
	  private static final Map<Integer, Location> locationMap = new HashMap<Integer, Location>();
	  
	  
	    static {
	        initUsers();
	    }
	 
	    private static void initUsers() {
	    	
	    	
	    	Location loc1 = new Location(1,63700970,"Crateús","CE","Venâncios","123","perto do ladim");
	        
	        Location loc2 = new Location(2,103819330,"São Paulo","SP","Parque Císper","123","perto da loja do Pitú");
	        
	        
	        	 
	        locationMap.put(loc1.getId(), loc1);
	        locationMap.put(loc2.getId(), loc2);
	        
	    }
	 
	    public static Location getLocation(int id) {
	        return locationMap.get(id);
	    }
	 
	    public static Location getLocationById(int id) {
	        List<Location> list = getAllLocation();
	 
	        for (Location loc : list) {
	            if (loc.getId()==id) {
	                return loc;
	            }
	        }
	 
	        return null;
	    }
	 
	    public static Location addLocation(int id,int zip_code,String city,String state,String neighborhood,String number,String reference) {
	        Location loc = new Location( id,zip_code,city,state,neighborhood,number,reference );
	        locationMap.put(loc.getId(), loc);
	        return loc;
	    }
	 
	    public static Location updateLocation(int id,int zip_code,String city,String state,String neighborhood,String number,String reference) {
	    	Location loc = new Location( id,zip_code,city,state,neighborhood,number,reference );
	        locationMap.put(loc.getId(), loc);
	        return loc;
	    }
	 
	    public static void deleteLocation(int identifier) {
	        if (locationMap.containsKey(identifier)) {
	        	locationMap.remove(identifier);
	        }
	    }
	 
	    public static List<Location> getAllLocation() {
	        return new ArrayList<Location>(locationMap.values());
	    }
	

}
