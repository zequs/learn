package com.zequs.springboot.demo.manager;

import com.zequs.springboot.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zequs
 * @version : springboot-mvc-demo, v0.1 2020 09 30 Exp $
 */
@Service
public class UserMangerImpl implements UserManager{
    static Map<Integer, User> map = new HashMap();
    static  {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        User user1 = new User();
        user1.setName("lisi");
        user1.setAge(20);
        map.put(1,user);
        map.put(2,user1);
    }

    @Override
    public User getUser(Integer id) {
        return map.get(id);
    }
}
