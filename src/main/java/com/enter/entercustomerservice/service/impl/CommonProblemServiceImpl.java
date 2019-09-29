package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.CommonProblemMapper;
import com.enter.entercustomerservice.dto.entity.CommonProblemDTO;
import com.enter.entercustomerservice.service.CommonProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liquid
 * @类名： CommonProblemServiceImpl
 * @描述：
 * @date 2019/9/29
 */
@Service("commonProblemService")
public class CommonProblemServiceImpl implements CommonProblemService {

    @Autowired
    private CommonProblemMapper commonProblemMapper;


    @Override
    public void insert(CommonProblemDTO commonProblemDTO) throws Exception {

    }

    @Override
    public List<CommonProblemDTO> selectAll() {
        return null;
    }

    @Override
    public CommonProblemDTO selectByPrimary(CommonProblemDTO commonProblemDTO) {
        return null;
    }

    @Override
    public void updateByPrimary(CommonProblemDTO commonProblemDTO) {

    }

    @Override
    public void deleteByPrimary(CommonProblemDTO commonProblemDTO) {

    }
}
