package com.hy.controller;

import com.hy.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/",description = "这是我的全部方法")
public class DemoController {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "拿到cookies方法",httpMethod = "GET")
    public String getCookies() {
        return "success";
    }

    @RequestMapping(value = "/getParams/{id}/{num}", method = RequestMethod.GET)
    @ApiOperation(value = "restful接口",httpMethod = "GET")
    public Map receiveParams(@PathVariable Long id, @PathVariable Integer num) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", id);
        map.put("key2", num);
        return map;
    }

    @RequestMapping(value = "/getUserlist",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    @ResponseBody
    public User getUserList(User user) {
        User u = new User();
        u.setUsername("张三");
        u.setPassword("1234");
        u.setAge(18);
        u.setSex("不男不女");
        return u;
    }
}
