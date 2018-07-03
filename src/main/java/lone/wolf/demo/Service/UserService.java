package lone.wolf.demo.Service;

import lone.wolf.demo.Dao.UserDao;
import lone.wolf.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description
 * @Author hechunhui
 * @Date 2018/7/2 22:41
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<Map<String, Object>> userList() {
        return userDao.getAllUser();
    }

    public boolean delUser(String userid) {
        if (userid == null || "".equals(userid.trim())) {
            userid = "";
        }
        return userDao.deleteUser(userid.trim());
    }

    public boolean addUser(User user){
        return userDao.addUser(user);
    }
    public User getUserById(String userid){
        if (userid == null || "".equals(userid.trim())) {
            userid = "";
        }
        return userDao.findUserById(userid);
    }

    public boolean updateUser(User user){
        return userDao.updateUser(user);
    }
}
