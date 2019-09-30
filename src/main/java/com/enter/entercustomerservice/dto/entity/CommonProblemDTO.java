package com.enter.entercustomerservice.dto.entity;

import com.enter.entercustomerservice.dto.Convertible;
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

    private static CommonProblemConvert commonProblemConvert;

    static {
        commonProblemConvert = new CommonProblemConvert();
    }

    public CommonProblem convertToDo() {

        return commonProblemConvert.convertToDO(this);
    }

    public CommonProblemDTO convertToDto(CommonProblem commonProblem) {
        return commonProblemConvert.convertToDTO(commonProblem);
    }

    public static class CommonProblemConvert implements Convertible<CommonProblem, CommonProblemDTO> {

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
}
