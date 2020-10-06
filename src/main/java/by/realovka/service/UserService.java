package by.realovka.service;

import by.realovka.dao.UserDaoImpl;
import by.realovka.entity.User;
import by.realovka.service.exception.DuplicateUserException;
import by.realovka.service.exception.NoSuchUserException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void createUser(User user){
       if (userDao.containsByLogin(user.getLogin()).isPresent()){
            throw new DuplicateUserException("Such user is already");
        }
        userDao.createUser(user);
    }

    public boolean authorizeUser(User user){
        if(userDao.containsUser(user).isEmpty()){
            throw new NoSuchUserException("No such user in DB");
        }
        return true;
    }

    public User getUserFromDB(User user){
       return userDao.containsUser(user).get();
    }

    public void updateUserInDB(User oldUser, User newUser){
        userDao.updateUser(oldUser,newUser);
    }

//    public boolean containsSuchUserInDBByLogin(User user) {
//        if (userDao.containsByLogin(user.getLogin()).isPresent()){
//           throw new DuplicateUserException();
//        }
//            return true;
//    }

    public void deleteUserFromDB(User user){
        userDao.deleteUser(user);
    }
}
