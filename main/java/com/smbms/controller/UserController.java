package com.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.smbms.Service.RoleService;
import com.smbms.Service.UserService;
import com.smbms.entity.Role;
import com.smbms.entity.User;
import com.smbms.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping("/login.do")
    public String login(String userCode, String userPassword, HttpSession session, Model model){
        User user = userService.getUser(userCode, userPassword);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:frame.do";
        }else {
            model.addAttribute("error","用户名或密码错误");
            return "../login";
        }

    }
    @RequestMapping("/frame.do")
    public String frame(){
        return "jsp/frame";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "../login";
    }
    @RequestMapping("/tj.do")
    public String tj(){
        return "jsp/useradd";
    }
    @RequestMapping("user.do")
    public String user(String queryUserName,
                           @RequestParam(defaultValue = "0") Integer queryUserRole,
                           @RequestParam(defaultValue = "1") Integer currentPageNo,
                           @RequestParam(defaultValue = "5") Integer pageSize,
                           Model model){
        int count = userService.getUserCount(queryUserName, queryUserRole);
        Integer startIndex=0;
        startIndex=(currentPageNo-1)*pageSize;
        PageSupport pageSupport = new PageSupport(currentPageNo,count,pageSize);
        List<User> userList = userService.getUserByPage(queryUserName, queryUserRole, startIndex, pageSize);
        List<Role> roleList = roleService.getRole();
        model.addAttribute("queryUserName",queryUserName);
        model.addAttribute("queryUserRole",queryUserRole);
        model.addAttribute("userList",userList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("pageSupport",pageSupport);
        return "jsp/userlist";
    }
    @RequestMapping("/checkUserCode.do")
    @ResponseBody
    public String checkUserCode(String userCode){

            return JSON.toJSONString(userService.checkUserCode(userCode));
    }
    @RequestMapping("/getrolelist.do")
    @ResponseBody
    public String getrolelist(){
        List<Role> role = roleService.getRole();
        return JSON.toJSONString(role);
    }
    @RequestMapping("/addUser.do")
    public  @ResponseBody String add(User user, HttpSession session, @RequestParam(value = "idpicpath_1",required = false)MultipartFile file,
                                     HttpServletRequest request) throws Exception {
        String realPath = request.getServletContext().getRealPath("/images/");
        file.transferTo(new File(realPath+File.separator+file.getOriginalFilename()));
        user.setIdpicpath("images/"+file.getOriginalFilename());
        User user1 = (User)session.getAttribute("user");
        user.setCreationDate(new Date());
        user.setCreatedBy(user1.getId());
        return JSON.toJSONString(userService.add(user));
    }
    @RequestMapping("/updateUser.do")
    public String updateUser(Integer id,Model model){
        User userById = userService.getUserById(id);
        model.addAttribute("userById",userById);
        return "jsp/usermodify";
    }
    @RequestMapping("/view.do")
    public String view(Integer id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "jsp/userview";
    }
}

