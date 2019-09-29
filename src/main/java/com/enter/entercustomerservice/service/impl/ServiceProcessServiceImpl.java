package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.ServiceProcessMapper;
import com.enter.entercustomerservice.dto.entity.ServiceProcessDTO;
import com.enter.entercustomerservice.service.ServiveProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liquid
 * @类名： ServiceProcessServiceImpl
 * @描述：
 * @date 2019/9/29
 */
@Service("serviceProcessService")
public class ServiceProcessServiceImpl implements ServiveProcessService {

    @Autowired
    private ServiceProcessMapper serviceProcessMapper;

    @Override
    public void insert(ServiceProcessDTO serviceProcessDTO) throws Exception {

    }

    @Override
    public List<ServiceProcessDTO> selectAll() {
        return null;
    }

    @Override
    public ServiceProcessDTO selectByPrimary(ServiceProcessDTO serviceProcessDTO) {
        return null;
    }

    @Override
    public void updateByPrimary(ServiceProcessDTO serviceProcessDTO) {

    }

    @Override
    public void deleteByPrimary(ServiceProcessDTO serviceProcessDTO) {

    }
}
