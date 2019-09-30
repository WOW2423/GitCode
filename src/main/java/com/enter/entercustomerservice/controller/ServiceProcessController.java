package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.dto.entity.ServiceProcessDTO;
import com.enter.entercustomerservice.result.ResultBean;
import com.enter.entercustomerservice.service.ServiveProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @className ServiceProcessController
 * @auther DylanChan
 * @description
 * @date 2019/9/29
 */
public class ServiceProcessController {
    @Autowired
    private ServiveProcessService serviveProcessService;

    @GetMapping("/selectAllServiceProcess")
    public ResultBean getAllServiceProcess(){
        return new ResultBean<>(serviveProcessService.selectAll());
    }
    @PostMapping("/insertServiceProcess")
    public void  insert(ServiceProcessDTO serviceProcessDTO) throws Exception {
        serviveProcessService.insert(serviceProcessDTO);
    }
    @GetMapping("/selectServiceProcessByPrimary")
    public ResultBean selectByPrimary(ServiceProcessDTO serviceProcessDTO){
        return new ResultBean(serviveProcessService.selectByPrimary(serviceProcessDTO));
    }
    @PostMapping("/updateServiceProcessByPrimary")
    public ResultBean  updateByPrimary(ServiceProcessDTO serviceProcessDTO){
        serviveProcessService.updateByPrimary(serviceProcessDTO);
        return new ResultBean(serviveProcessService.selectByPrimary(serviceProcessDTO));
    }
    @PostMapping("/deleteServiceProcessByPrimary")
    public void deleteByPrimary(ServiceProcessDTO serviceProcessDTO){
        serviveProcessService.deleteByPrimary(serviceProcessDTO);
    }
}
