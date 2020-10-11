package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Complaint;

import util.DbUtil;
 
public class ComplaintDAO {
 
    private static Connection connection = DbUtil.getConnection();
 

    public static Complaint addComplaint(int id,String infringement,String offender,String smuggledProduct,String offenseDescription,String URLDocument,String imageURL, int cpf_user, int id_location) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("insert into users(id,infringement,offender, smuggledProduct, offenseDescription, URLDocument,imageURL, cpf_user,id_location ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, id);
            pStmt.setString(2, infringement);
            pStmt.setString(3, offender);
            pStmt.setString(4, smuggledProduct);
            pStmt.setString(5, offenseDescription);
            pStmt.setString(6, URLDocument);
            pStmt.setString(7, imageURL);
            pStmt.setInt(8, cpf_user);
            pStmt.setInt(9, id_location);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Complaint(rs.getInt("id"), rs.getString("infringement"),rs.getString("offender"), rs.getString("smuggledProduct"),rs.getString("offenseDescription"), rs.getString("URLDocument"),rs.getString("imageURL"), rs.getInt("cpf_user"),rs.getInt("id_location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
}

public static Complaint updateComplaint(int id,String offender,String infringement,String smuggledProduct,String offenseDescription,String URLDocument,String imageURL, int cpf_user, int id_location) {
try {
    PreparedStatement pStmt = connection.prepareStatement("update complaint set id=?, infringement=?,offender=?, smuggledProduct=?, offenseDescription=?, URLDocument=?,imageURL=?  where id=?",
            Statement.RETURN_GENERATED_KEYS);
    pStmt.setInt(1, id);
    pStmt.setString(2, offender);
    pStmt.setString(3, infringement);
    pStmt.setString(4, smuggledProduct);
    pStmt.setString(5, offenseDescription);
    pStmt.setString(6, URLDocument);
    pStmt.setString(7, imageURL);
    pStmt.setInt(8, cpf_user);
    pStmt.setInt(9, id_location);
    pStmt.executeUpdate();
    ResultSet rs = pStmt.getGeneratedKeys();
    if (rs.next()) {
        return new  Complaint(rs.getInt("id"), rs.getString("infringement"),rs.getString("offender"), rs.getString("smuggledProduct"),rs.getString("offenseDescription"), rs.getString("URLDocument"),rs.getString("imageURL"), rs.getInt("cpf_user"),rs.getInt("id_location"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static void deleteComplaint(int id) {
try {
    PreparedStatement pStmt = connection.prepareStatement("delete from complaint where id=?");
    pStmt.setInt(1, id);
    pStmt.executeUpdate();
} catch (SQLException e) {
    e.printStackTrace();
}
}

public static List<Complaint> getAllComplaints() {
List<Complaint> complaints = new ArrayList<Complaint>();
try {
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery("select * from complaint order by offender");
    while (rs.next()) {
        Complaint complaint = new  Complaint(rs.getInt("id"), rs.getString("infringement"),rs.getString("offender"), rs.getString("smuggledProduct"),rs.getString("offenseDescription"), rs.getString("URLDocument"),rs.getString("imageURL"), rs.getInt("cpf_user"),rs.getInt("id_location"));
        complaints.add(complaint);
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return complaints;
}

public static Complaint getComplaint(int id) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from complaint where id=?");
    pStmt.setInt(1, id);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new   Complaint(rs.getInt("id"), rs.getString("infringement"),rs.getString("offender"), rs.getString("smuggledProduct"),rs.getString("offenseDescription"), rs.getString("URLDocument"),rs.getString("imageURL"), rs.getInt("cpf_user"),rs.getInt("id_location"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static Complaint getComplaintByNameOffender(String name) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from complaint where offender=?");
    pStmt.setString(1, name);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new Complaint(rs.getInt("id"), rs.getString("infringement"),rs.getString("offender"), rs.getString("smuggledProduct"),rs.getString("offenseDescription"), rs.getString("URLDocument"),rs.getString("imageURL"), rs.getInt("cpf_user"),rs.getInt("id_location"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}
}