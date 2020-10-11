package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.User;
import util.DbUtil;
 
public class UserDAO {
 
    private static Connection connection = DbUtil.getConnection();
 
    public static User addUser(int cpf, String name, String email, String password, int id_localization, int id_complaint) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("insert into users(cpf,name,email, password, id_localization, id_complaint) values (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, cpf);
            pStmt.setString(2, name);
            pStmt.setString(3, email);
            pStmt.setString(4, password);
            pStmt.setInt(5, id_localization);
            pStmt.setInt(6, id_complaint);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new User(rs.getInt("cpf"), rs.getString("name"),rs.getString("email"), rs.getString("password"), rs.getInt("id_localization"), rs.getInt("id_complaint"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
}

public static User updateUser(int cpf, String name, String email, String password,int id_localization, int id_complaint) {
try {
    PreparedStatement pStmt = connection.prepareStatement("update users set cpf=?, name=?, email=?, password=?,id_localization=?,id_complaint=?  where cpf=?",
            Statement.RETURN_GENERATED_KEYS);
    pStmt.setString(2, name);
    pStmt.setString(4, password);
    pStmt.setString(3, email);
    pStmt.setInt(1, cpf);
    pStmt.setInt(5, id_localization);
    pStmt.setInt(6, id_complaint);
    pStmt.executeUpdate();
    ResultSet rs = pStmt.getGeneratedKeys();
    if (rs.next()) {
        return new User(rs.getInt("cpf"), rs.getString("name"),rs.getString("email"), rs.getString("password"), rs.getInt("id_localization"), rs.getInt("id_complaint"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static void deleteUser(int cpf) {
try {
    PreparedStatement pStmt = connection.prepareStatement("delete from users where cpf=?");
    pStmt.setInt(1, cpf);
    pStmt.executeUpdate();
} catch (SQLException e) {
    e.printStackTrace();
}
}

public static List<User> getAllUsers() {
List<User> users = new ArrayList<User>();
try {
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery("select * from users order by name");
    while (rs.next()) {
        User user = new User(rs.getInt("cpf"), rs.getString("name"),rs.getString("email"), rs.getString("password"), rs.getInt("id_localization"), rs.getInt("id_complaint"));
        users.add(user);
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return users;
}

public static User getUser(int cpf) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from users where cpf=?");
    pStmt.setInt(1, cpf);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new User(rs.getInt("cpf"), rs.getString("name"),rs.getString("email"), rs.getString("password"), rs.getInt("id_localization"), rs.getInt("id_complaint"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}

public static User getUserByName(String name) {
try {
    PreparedStatement pStmt = connection.prepareStatement("select * from users where name=?");
    pStmt.setString(1, name);
    ResultSet rs = pStmt.executeQuery();
    if (rs.next()) {
        return new User(rs.getInt("cpf"), rs.getString("name"),rs.getString("email"), rs.getString("password"), rs.getInt("id_localization"), rs.getInt("id_complaint"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return null;
}
}