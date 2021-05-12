package com.smbms.controller;

import com.smbms.Service.ProviderService;
import com.smbms.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    ProviderService providerService;
    @RequestMapping("/getProvider.do")
    public String getProvider(Model model){
        List<Provider> provider = providerService.getAllProvider();
        model.addAttribute("provider",provider);
        return "../getProvider";
    }
    @RequestMapping("/getProviderByid.do")
    public String getProviderByid(Model model,Integer id){
        List<Provider> provider = providerService.getProviderById(id);
        model.addAttribute("provider",provider);
        return "../getProviderByid";
    }
    @RequestMapping("/addProvider.do")
    public String addProvider(Model model,Provider provider){
        int add = providerService.add(provider);
        if(add>0){
            model.addAttribute("add","添加成功！");
            return "../addProvider";
        }else {
            model.addAttribute("add","添加失败！");
            return "../addProvider";
        }

    }
    @RequestMapping("/proCodeBlur.do")
    @ResponseBody
    public String proCodeBlur(String proCode){
        Provider provideByCode = providerService.getProvideByCode(proCode);
        if (provideByCode!=null){
            return "true";
        }else {
            return "false";
        }

    }
}
