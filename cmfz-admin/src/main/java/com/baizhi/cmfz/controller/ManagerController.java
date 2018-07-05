package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.NewValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.modelmbean.ModelMBean;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @program: cmfz
 * @description: manager的controller类
 * @author: Yuyiwei
 * @create: 2018-07-04 17:18
 **/

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public @ResponseBody String login(String code, Manager manager,
                   HttpSession session,HttpServletResponse resquest, String check) throws Exception{

        if(code.equalsIgnoreCase((String)session.getAttribute("code"))){
            if(managerService.login(manager.getManagerName(),manager.getManagerPassword()) != null){

                if(check!=null){
                    String managerName = URLEncoder.encode(manager.getManagerName(), "UTF-8");
                    Cookie cookie = new Cookie("managerName",managerName);
                    cookie.setMaxAge(60*60*24*7);
                    resquest.addCookie(cookie);
                }

                session.setAttribute("managerName",manager.getManagerName());

                return "true";
            }else {
                return "managerFalse";
            }

        }else {
            return "codeFalse";
        }

    }

    @RequestMapping("/getCode")
    public void code(HttpServletResponse response, HttpSession session) throws Exception{
        NewValidateCodeUtils utils = new NewValidateCodeUtils(100,30);

        //将数据存入Context中的session键值对中
        session.setAttribute("code",utils.getCode());
        utils.write(response.getOutputStream());
    }

//    @RequestMapping("/getCookie")
//    public String getCookie(HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException {
//        Cookie[] cookies = request.getCookies();
//
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("managerName")){
//                String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
//                map.addAttribute("managerName",value);
//                return "login";
//            }
//        }
//        return "redirect:/login.jsp";
//
//    }


}