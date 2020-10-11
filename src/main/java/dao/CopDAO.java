package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.Cop;
//import model.User;
import util.DbUtil;
 
public class CopDAO {
 
    private static Connection connection = DbUtil.getConnection();
    //UserDAO userDao = new UserDAO();
    public static Cop addCop(int cpf ,String office,int identification,String departament) {
    	 
    	
        try {
            PreparedStatement pStmt = connection.prepareStatement("insert into cops(my_cpf, office, identification, departament) values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, cpf);
            pStmt.setString(2, office);
            pStmt.setInt(3, identification);
            pStmt.setString(4, departament);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Cop(rs.getInt("my_cpf"), rs.getString("office"),rs.getInt("identification"),rs.getString("departament"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
}

public static Cop updateCop(int cpf ,String office,int identification,String departament) {
try {
    PreparedStatement pStmt = connection.prepareStatement("update cops set cpf=?, office=?, identification=?, departament=? where cpf=?",
            Statement.RETURN_GENERATED_KEYS);
    pStmt.setInt(1, cpf);
    pStmt.setString(2, office);
    pStmt.setInt(3, identification);
    pStmt.setString(3, departament);
    pStmt.executeUpdate();
    ResultSet rs = pStmt.getGeneratedKeys();
    if (rs.next()) {
        return new Cop(rs.getInt("cpf"),rs.getString("office"),rs.getInt("identification"),rs.getString("departament"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static void deleteCop(int cpf) {
try {
    PreparedStatement pStmt = connection.prepareStatement("delete from location where my_cpf=?");
    PreparedStatement pStmt2 = connection.prepareStatement("delete from users where cpf=?");
    pStmt.setInt(1, cpf);
    pStmt.setInt(1, cpf);
    pStmt2.executeUpdate();
    pStmt.executeUpdate();
} catch (SQLException e) {
    e.printStackTrace();
}
}

public static List<Cop> getAllCops() {
List<Cop> cops = new ArrayList<Cop>();
try {
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery("select * from cops order by office");
    while (rs.next()) {
        Cop cop = new Cop(rs.getInt("my_cpf"), rs.getString("office"),rs.getInt("identification"),rs.getString("departament"));
        cops.add(cop);
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return cops;
}

public static Cop getCop(int cpf) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from cops where my_cpf=?");
    pStmt.setInt(1, cpf);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new Cop(rs.getInt("my_cpf"), rs.getString("office"),rs.getInt("identification"),rs.getString("departament"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static Cop getUserByOffice(String office) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from cops where office=?");
    pStmt.setString(1, office);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new Cop(rs.getInt("my_cpf"), rs.getString("office"),rs.getInt("identification"),rs.getString("departament"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}
}