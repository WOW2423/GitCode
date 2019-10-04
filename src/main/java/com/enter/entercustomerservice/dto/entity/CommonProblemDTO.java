package com.enter.entercustomerservice.dto.entity;

import com.enter.entercustomerservice.dto.DoConvertible;
import com.enter.entercustomerservice.dto.VoConvertible;
import com.enter.entercustomerservice.entity.CommonProblem;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： CommonProblemDTO
 * @描述：
 * @date 2019/9/28
 */
@Data
public class CommonProblemDTO implements Serializable {
    private static final long serialVersionUID = -8461444496781317319L;

    /**
     * 常见问题id
     */
    private Integer id;

    /**
     * 归属的项目类型
     */
    private String projectType;

    /**
     * 问题标题
     */
    private String item;

    /**
     * 问题回答
     */
    private String content;

    private static CommonProblemDoConvert commonProblemDoConvert;
    private static CommonProblemVoConvert commonProblemVoConvert;

    static {
        commonProblemDoConvert = new CommonProblemDoConvert();
        commonProblemVoConvert = new CommonProblemVoConvert();
    }

    public CommonProblem convertToDo() {

        return commonProblemDoConvert.convertToDO(this);
    }

    public CommonProblemDTO convertToDTO(CommonProblem commonProblem) {
        return commonProblemDoConvert.convertToDTO(commonProblem);
    }

    public CommonProblemVO convertToVo() {
        return commonProblemVoConvert.convertToVO(this);
    }

    public CommonProblemDTO commonProblemToDTO(CommonProblemVO commonProblemVO) {
        return commonProblemVoConvert.convertToDTO(commonProblemVO);
    }

    public static class CommonProblemDoConvert implements DoConvertible<CommonProblem, CommonProblemDTO> {

        @Override
        public CommonProblem convertToDO(CommonProblemDTO commonProblemDTO) {
            CommonProblem commonProblem = new CommonProblem();
            BeanUtils.copyProperties(commonProblemDTO, commonProblem);
            return commonProblem;
        }

        @Override
        public CommonProblemDTO convertToDTO(CommonProblem commonProblem) {
            CommonProblemDTO commonProblemDTO = new CommonProblemDTO();
            BeanUtils.copyProperties(commonProblem, commonProblemDTO);
            return commonProblemDTO;
        }
    }

    public static class CommonProblemVoConvert implements VoConvertible<CommonProblemVO, CommonProblemDTO> {
        @Override
        public CommonProblemVO convertToVO(CommonProblemDTO commonProblemDTO) {
            CommonProblemVO commonProblemVO = new CommonProblemVO();
            BeanUtils.copyProperties(commonProblemDTO, commonProblemVO);
            return commonProblemVO;
        }

        @Override
        public CommonProblemDTO convertToDTO(CommonProblemVO commonProblemVO) {
            CommonProblemDTO commonProblemDTO = new CommonProblemDTO();
            BeanUtils.copyProperties(commonProblemVO, commonProblemDTO);
            return commonProblemDTO;
        }
    }
}


