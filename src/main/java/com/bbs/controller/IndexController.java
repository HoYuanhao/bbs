package com.bbs.controller;

import com.bbs.security.CustUserDetails;
import com.alibaba.fastjson.JSONObject;
import com.bbs.bean.BaseInfo;
import com.bbs.bean.Signature;
import com.bbs.bean.Work;
import com.bbs.service.BaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    private static final Logger logger= LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private BaseInfoService baseInfoService;
    @RequestMapping("login")
    public String login(){
        return "/login";
    }
    @RequestMapping("/")
public String ok(){
    CustUserDetails userDetails= (CustUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
String username=userDetails.getUsername();
String password=userDetails.getPassword();
Integer id=userDetails.getId();
System.out.println(id+" "+username+" "+password);
        return "/index";
}
    @RequestMapping(value="baseinfo.json",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBaseInfo(){
        JSONObject jsonObject=new JSONObject();
        try {
            BaseInfo baseInfo = baseInfoService.getBaseInfoNearNow();
            Signature signature=baseInfoService.getSignatureNearNow();
            List<Work> workList=baseInfoService.getAllWorkList();
            jsonObject.put("code","1");
            Map<String,Object> data=new HashMap<String,Object>();
            jsonObject.put("data",data);
            data.put("baseinfo",baseInfo);
            data.put("signature",signature);
            data.put("workList",workList);
        }catch (Exception e){
            jsonObject.put("code","0");
e.printStackTrace();
logger.debug("获取基本信息失败!");
        }
return jsonObject.toJSONString();
    }
}
