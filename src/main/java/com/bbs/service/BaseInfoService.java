package com.bbs.service;

import com.bbs.bean.BaseInfo;
import com.bbs.bean.Signature;
import com.bbs.bean.Skills;
import com.bbs.bean.Work;

import java.util.List;

public interface BaseInfoService {
    public List<Work> getAllWorkList();
    public BaseInfo getBaseInfoNearNow();
    public List<Skills> getAllSkills();
    public Signature getSignatureNearNow();
}
