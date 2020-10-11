package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.Location;
import util.DbUtil;
 
public class LocationDAO {
 
    private static Connection connection = DbUtil.getConnection();
 
    public static Location addLocation(int id,int zipCode,String city,String state,String neighborhood,String number,String reference) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("insert into location(id,zip_code,city,state,neighborhood,number,reference) values (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, id);
            pStmt.setInt(2, zipCode);
            pStmt.setString(3, city);
            pStmt.setString(4, state);
            pStmt.setString(5, neighborhood);
            pStmt.setString(6, number);
            pStmt.setString(7, reference);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Location(rs.getInt("id"), rs.getInt("zip_code"), rs.getString("city"),rs.getString("state"), rs.getString("neighborhood"),rs.getString("number"), rs.getString("reference"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
}

public static Location updateLocation(int id,int zipCode,String city,String state,String neighborhood,String number,String reference) {
try {
    PreparedStatement pStmt = connection.prepareStatement("update location set id=?, zip_code=?, city=?, state=?, neighborhood=?, number=?, reference=? where id=?",
            Statement.RETURN_GENERATED_KEYS);
    pStmt.setInt(1, id);
    pStmt.setInt(2, zipCode);
    pStmt.setString(3, city);
    pStmt.setString(4, state);
    pStmt.setString(5, neighborhood);
    pStmt.setString(6, number);
    pStmt.setString(7, reference);
    pStmt.executeUpdate();
    ResultSet rs = pStmt.getGeneratedKeys();
    if (rs.next()) {
        return new Location(rs.getInt("id"),rs.getInt("zip_code"), rs.getString("city"),rs.getString("state"), rs.getString("neighborhood"), rs.getString("number"), rs.getString("reference"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static void deleteLocation(int id) {
try {
    PreparedStatement pStmt = connection.prepareStatement("delete from location where id=?");
    pStmt.setInt(1, id);
    pStmt.executeUpdate();
} catch (SQLException e) {
    e.printStackTrace();
}
}

public static List<Location> getAllLocations() {
List<Location> locations = new ArrayList<Location>();
try {
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery("select * from location order by city");
    while (rs.next()) {
        Location location = new Location(rs.getInt("id"), rs.getInt("zip_code"),rs.getString("city"), rs.getString("state"), rs.getString("neighborhood"), rs.getString("number"), rs.getString("reference"));
        locations.add(location);
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return locations;
}

public static Location getLocation(int id) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from location where id=?");
    pStmt.setInt(1, id);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new Location(rs.getInt("id"), rs.getInt("zip_code"),rs.getString("city"), rs.getString("state"), rs.getString("neighborhood"), rs.getString("number"), rs.getString("reference"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static Location getUserByCity(String city) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from location where city=?");
    pStmt.setString(1, city);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new Location(rs.getInt("id"), rs.getInt("zip_code"),rs.getString("city"), rs.getString("state"), rs.getString("neighborhood"), rs.getString("number"), rs.getString("reference"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}
}