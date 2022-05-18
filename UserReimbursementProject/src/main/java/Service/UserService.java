package Service;

import Model.User;

import java.util.ArrayList;

public class UserService {

    ArrayList<User> userArrayList;
    public UserService(){
        userArrayList = new ArrayList<>();
    }
    public void addUser(User user){
        userArrayList.add(user);
    }
    public ArrayList<User> getAllUsers(){
        return userArrayList;
    }
}
