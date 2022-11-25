package com.lmy.controller;

import com.lmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description 用户登录
 * @Date 2022/11/24 17:15
 * @Author by Soleil
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录, 使用SpringSecurity 无需自己编写登录接口
     */
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.POST,value = "/user/login")
//    public R login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if (StrUtil.isNotBlank(username)&&StrUtil.isNotBlank(password)) {
//            Users users = userService. login(username, password);
//            if (users!=null) {
//                request.getSession().setAttribute("username",username);
//                return R.success(CodeEnum.SUCCESS);
//            }
//        }
//
//        return R.fail(CodeEnum.NAME_OR_PASS_ERROR);
//    }
    
}
