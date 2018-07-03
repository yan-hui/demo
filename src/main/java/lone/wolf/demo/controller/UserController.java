package lone.wolf.demo.controller;

import lone.wolf.demo.Service.UserService;
import lone.wolf.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description
 * @Author hechunhui
 * @Date 2018/7/2 22:55
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private Map<String, Object> result;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public List<Map<String, Object>> userList() {
        return userService.userList();
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Map<String, Object> getUser(@RequestParam(value = "userid") String userid) {
        User user = userService.getUserById(userid);
        result = new HashMap<>();
        if (user != null) {
            result.put("code", "1");
        } else {
            result.put("code", "0");
        }
        result.put("user", user);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestParam(value = "user") User user) {
        System.out.println(user);
        return userService.addUser(user);
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public boolean delUser(String userid) {
        return userService.delUser(userid);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update(User user) {
        return userService.updateUser(user);
    }

}
