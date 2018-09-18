package com.bbs.dao;

import com.bbs.bean.BaseInfo;
import com.bbs.bean.Signature;
import com.bbs.bean.Skills;
import com.bbs.bean.Work;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseInfoDao {
    public List<Work> selectAllWorkDetials();
    public void insertWork(Work work);
    public void insertSignature(Signature signature);
    public List<Skills> selectAllSkills();
    public void insertBaseInfo(BaseInfo baseInfo);

    public BaseInfo getBaseInfoNearNow();

    public Signature getSignatureNearNow();
}
