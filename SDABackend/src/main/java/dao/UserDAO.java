package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import model.User;
 
public class UserDAO {
 
    private static final Map<Integer, User> userMap = new HashMap<Integer, User>();
  
 
    static {
        initUsers();
    }
 
    private static void initUsers() {
        User user1 = new User(165454654, "almada", "jhon@gmail","1234");
        User user2 = new User(25454, "anderson", "mizael.info@gmail","1234");
        User user3 = new User(365465, "alex", "ines@gmail","1234");
 
        userMap.put(user1.getCpf(), user1);
        userMap.put(user2.getCpf(), user2);
        userMap.put(user3.getCpf(), user3);
    }
 
    public static User getUser(int cpf) {
        return userMap.get(cpf);
    }
 
    public static User getUserBylogin(String email) {
        List<User> list = getAllUsers();
 
        for (User user : list) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
 
        return null;
    }
 
    public static User addUser(int cpf,String name,String email, String password) {
        User user = new User(cpf, name, email, password);
        userMap.put(user.getCpf(), user);
        return user;
    }
 
    public static User updateUser(int cpf, String name,String email, String password) {
        User user = new User(cpf, name, email, password);
        userMap.put(user.getCpf(), user);
        return user;
    }
 
    public static void deleteUser(int cpf) {
        if (userMap.containsKey(cpf)) {
            userMap.remove(cpf);
        }
    }
 
    public static List<User> getAllUsers() {
        return new ArrayList<User>(userMap.values());
    }
}
