package com.enter.service.pojo.dto.entity;

import com.enter.service.pojo.dto.DoConvertible;
import com.enter.service.pojo.dto.VoConvertible;
import com.enter.service.pojo.entity.ServiceProcess;
import com.enter.service.pojo.vo.ServiceProcessVO;
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
    private String projectType;

    /**
     * 顺序
     */
    private Integer index;


    private static ServiceProcessDoConvert serviceProcessDoConvert;
    private static ServiceProcessVoConvert serviceProcessVoConvert;

    static {
        serviceProcessDoConvert = new ServiceProcessDoConvert();
        serviceProcessVoConvert=new ServiceProcessVoConvert();
    }

    public ServiceProcess convertToDo() {

        return serviceProcessDoConvert.convertToDO(this);
    }

    public ServiceProcessDTO convertToDTO(ServiceProcess serviceProcess) {
        return serviceProcessDoConvert.convertToDTO(serviceProcess);
    }
    public ServiceProcessVO convertToVo() {
        return serviceProcessVoConvert.convertToVO(this);
    }

    public ServiceProcessDTO serviceProcessToDTO(ServiceProcessVO serviceProcessVO) {
        return serviceProcessVoConvert.convertToDTO(serviceProcessVO);
    }

    public static class ServiceProcessDoConvert implements DoConvertible<ServiceProcess, ServiceProcessDTO> {

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
    public static class ServiceProcessVoConvert implements VoConvertible<ServiceProcessVO, ServiceProcessDTO> {
        @Override
        public ServiceProcessVO convertToVO(ServiceProcessDTO serviceProcessDTO) {
            ServiceProcessVO servicePorcessVO = new ServiceProcessVO();
            BeanUtils.copyProperties(serviceProcessDTO, servicePorcessVO);
            return servicePorcessVO;
        }

        @Override
        public ServiceProcessDTO convertToDTO(ServiceProcessVO serviceProcessVO) {
            ServiceProcessDTO serviceProcessDTO = new ServiceProcessDTO();
            BeanUtils.copyProperties(serviceProcessVO, serviceProcessDTO);
            return serviceProcessDTO;
        }
    }
}
