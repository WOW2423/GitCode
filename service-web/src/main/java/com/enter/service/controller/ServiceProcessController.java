package com.enter.service.controller;

import com.enter.service.pojo.dto.entity.ServiceProcessDTO;
import com.enter.service.result.ResultBean;
import com.enter.service.service.ServiceProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className ServiceProcessController
 * @auther DylanChan
 * @description
 * @date 2019/9/29
 */
@RestController
public class ServiceProcessController {

    @Autowired
    private ServiceProcessService serviceProcessService;

    @GetMapping("/selectAllServiceProcess")
    public ResultBean getAllServiceProcess(){
        return new ResultBean<>(serviceProcessService.selectAll());
    }
    @PostMapping("/insertServiceProcess")
    public void  insert(ServiceProcessDTO serviceProcessDTO) throws Exception {
        serviceProcessService.insert(serviceProcessDTO);
    }
    @GetMapping("/selectServiceProcessByPrimary")
    public ResultBean selectByPrimary(ServiceProcessDTO serviceProcessDTO){
        return new ResultBean<>(serviceProcessService.selectByPrimary(serviceProcessDTO));
    }
    @PostMapping("/updateServiceProcessByPrimary")
    public ResultBean  updateByPrimary(ServiceProcessDTO serviceProcessDTO){
        serviceProcessService.updateByPrimary(serviceProcessDTO);
        return new ResultBean<>(serviceProcessService.selectByPrimary(serviceProcessDTO));
    }
    @PostMapping("/deleteServiceProcessByPrimary")
    public void deleteByPrimary(ServiceProcessDTO serviceProcessDTO){
        serviceProcessService.deleteByPrimary(serviceProcessDTO);
    }
}
