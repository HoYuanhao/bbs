package com.bbs.service.impl;

import com.bbs.bean.BaseInfo;
import com.bbs.bean.Signature;
import com.bbs.bean.Skills;
import com.bbs.bean.Work;
import com.bbs.dao.BaseInfoDao;
import com.bbs.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {
    @Autowired
    private BaseInfoDao baseInfoDao;

    @Override
    public List<Work> getAllWorkList() {
        return baseInfoDao.selectAllWorkDetials();
    }

    @Override
    public BaseInfo getBaseInfoNearNow() {
        return baseInfoDao.getBaseInfoNearNow();
    }

    @Override
    public List<Skills> getAllSkills() {
        return baseInfoDao.selectAllSkills();
    }

    @Override
    public Signature getSignatureNearNow() {
        return baseInfoDao.getSignatureNearNow();
    }
}
