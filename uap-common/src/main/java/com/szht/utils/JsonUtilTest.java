package com.szht.utils;

import com.szht.entity.User;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class JsonUtilTest {
    public static void main(String[] args) {
        val user = new User();
        user.setYgbh("allqy");
        user.setYgmc("allqy");
        user.setYgmm("123456");
        val userJsonStr = JsonUtil.obj2String(user);
        System.out.println("userJsonStr="+userJsonStr);
        val userObj = JsonUtil.string2Obj(userJsonStr, User.class);
        System.out.println("userObj="+userObj);
    }
}
