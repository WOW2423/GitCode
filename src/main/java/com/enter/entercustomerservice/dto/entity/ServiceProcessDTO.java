package com.enter.entercustomerservice.dto.entity;

import com.enter.entercustomerservice.dto.Convertible;
import com.enter.entercustomerservice.entity.ServiceProcess;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： ServiceProcessDTO
 * @描述：
 * @date 2019/9/28
 */
@Data
public class ServiceProcessDTO implements Serializable {
    private static final long serialVersionUID = -7176565147421791372L;

    /**
     * 服务流程id
     */

    private Integer id;

    /**
     * 流程标题
     */
    private String item;

    /**
     * 流程内容
     */
    private String content;

    /**
     * 归属的项目类型
     */
    private Integer projectType;

    /**
     * 顺序
     */
    private Integer index;


    private static ServiceProcessConvert serviceProcessConvert;

    static {
        serviceProcessConvert = new ServiceProcessConvert();
    }

    public ServiceProcess convertToDo() {

        return serviceProcessConvert.convertToDO(this);
    }

    public ServiceProcessDTO convertToDto(ServiceProcess serviceProcess) {
        return serviceProcessConvert.convertToDTO(serviceProcess);
    }

    public static class ServiceProcessConvert implements Convertible<ServiceProcess, ServiceProcessDTO> {

        @Override
        public ServiceProcess convertToDO(ServiceProcessDTO serviceProcessDTO) {
            ServiceProcess serviceProcess = new ServiceProcess();
            BeanUtils.copyProperties(serviceProcessDTO, serviceProcess);
            return serviceProcess;
        }

        @Override
        public ServiceProcessDTO convertToDTO(ServiceProcess serviceProcess) {
            ServiceProcessDTO serviceProcessDTO = new ServiceProcessDTO();
            BeanUtils.copyProperties(serviceProcess, serviceProcessDTO);
            return serviceProcessDTO;
        }
    }
}
