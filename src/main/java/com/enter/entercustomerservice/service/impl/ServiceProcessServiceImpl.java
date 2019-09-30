package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.ServiceProcessMapper;
import com.enter.entercustomerservice.dto.entity.ServiceProcessDTO;
import com.enter.entercustomerservice.entity.ServiceProcess;
import com.enter.entercustomerservice.service.ServiveProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        ServiceProcess serviceProcess = serviceProcessDTO.convertToDo();
        serviceProcess.setAllTime();
        serviceProcessMapper.insert(serviceProcess);
        System.out.println("插入成功");
    }

    @Override
    public List<ServiceProcessDTO> selectAll() {
        List<ServiceProcess> serviceProcesses = serviceProcessMapper.selectAll();
        List<ServiceProcessDTO> serviceProcessDTOList=new ArrayList<>();
        for (ServiceProcess serviceProcess : serviceProcesses) {
            ServiceProcessDTO serviceProcessDTO = new ServiceProcessDTO().convertToDto(serviceProcess);
            serviceProcessDTOList.add(serviceProcessDTO);
        }
        return serviceProcessDTOList;
    }

    @Override
    public ServiceProcessDTO selectByPrimary(ServiceProcessDTO serviceProcessDTO) {
        ServiceProcess serviceProcess = serviceProcessDTO.convertToDo();
        serviceProcess.setAllTime();
        ServiceProcess s = serviceProcessMapper.selectByPrimaryKey(serviceProcess.getId());
        return new ServiceProcessDTO().convertToDto(s);
    }

    @Override
    public void updateByPrimary(ServiceProcessDTO serviceProcessDTO) {
        ServiceProcess serviceProcess = serviceProcessDTO.convertToDo();
        serviceProcess.setAllTime();
        serviceProcessMapper.updateByPrimaryKey(serviceProcess);
    }

    @Override
    public void deleteByPrimary(ServiceProcessDTO serviceProcessDTO) {
        ServiceProcess serviceProcess = serviceProcessDTO.convertToDo();
        serviceProcess.setAllTime();
        serviceProcessMapper.deleteByPrimaryKey(serviceProcess.getId());
        System.out.println("删除成功");
    }
}
