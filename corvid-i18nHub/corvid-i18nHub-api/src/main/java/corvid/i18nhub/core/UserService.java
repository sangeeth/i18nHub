package corvid.i18nhub.core;

import java.util.List;

import corvid.i18nhub.core.bean.User;
import corvid.i18nhub.core.bean.UserProject;

public interface UserService {
    User createUser(User user);
    
    User getUserById(long userId);
    
    void updateUser(User user);
    
    void deleteUserById(long userId);
    
    List<User> getUsers();
    
    List<UserProject> getUserProjects(long userId);
}
