package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser) {

        String pwd = newUser.getPassword();

        String pattern1 = "[a-z]";
        String pattern2 = "[A-Z]";
        String pattern3 = "[0-9]";
        String pattern4 = "[^a-zA-Z0-9]";
            // Create a Pattern object
        Pattern r1 = Pattern.compile(pattern1);
        Pattern r2 = Pattern.compile(pattern2);
        Pattern r3 = Pattern.compile(pattern3);
        Pattern r4 = Pattern.compile(pattern4);
            // Now create matcher object.
        Matcher m1 = r1.matcher(pwd);
        Matcher m2 = r2.matcher(pwd);
        Matcher m3 = r3.matcher(pwd);
        Matcher m4 = r4.matcher(pwd);
        if (m1.find( ) && m2.find( ) && m3.find( ) && m4.find( )) {
            userRepository.registerUser(newUser);
        } else {
            int data = 50 / 0;
        }
      }

    //Since we did not have any user in the database, therefore the user with username 'upgrad' and password 'password' was hard-coded
    //This method returned true if the username was 'upgrad' and password is 'password'
    //But now let us change the implementation of this method
    //This method receives the User type object
    //Calls the checkUser() method in the Repository passing the username and password which checks the username and password in the database
    //The Repository returns User type object if user with entered username and password exists in the database
    //Else returns null
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }

}
