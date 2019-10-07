package com.enter.service.impl;

import com.enter.service.database.mysql.mybatis.CommonProblemMapper;
import com.enter.service.pojo.dto.entity.CommonProblemDTO;
import com.enter.service.pojo.entity.CommonProblem;
import com.enter.service.service.CommonProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： CommonProblemServiceImpl
 * @描述：  服务问题
 * @date 2019/9/29
 */

@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("commonProblemService")
public class CommonProblemServiceImpl implements CommonProblemService {

    @Autowired
    private CommonProblemMapper commonProblemMapper;


    @Override
    public void insert(CommonProblemDTO commonProblemDTO) throws Exception {
        CommonProblem commonProblem = commonProblemDTO.convertToDo();
        commonProblem.setAllTime();
        commonProblemMapper.insertSelective(commonProblem);
        System.out.println("插入成功");
    }


    @Override
    public List<CommonProblemDTO> selectAll() {
        List<CommonProblem> commonProblems = commonProblemMapper.selectAll();
        List<CommonProblemDTO> commonProblemDTOList=new ArrayList<>();
        for (CommonProblem commonProblem : commonProblems) {
            CommonProblemDTO commonProblemDTO = new CommonProblemDTO().convertToDTO(commonProblem);
            commonProblemDTOList.add(commonProblemDTO);
        }
        //return commonProblemDTOList;
        return null;
    }

    @Override
    public CommonProblemDTO selectByPrimary(CommonProblemDTO commonProblemDTO) {
        CommonProblem commonProblem = commonProblemDTO.convertToDo();
        commonProblem.setAllTime();
        CommonProblem c = commonProblemMapper.selectByPrimaryKey(commonProblem.getId());
        return new CommonProblemDTO().convertToDTO(c);
    }

    @Override
    public void updateByPrimary(CommonProblemDTO commonProblemDTO) {
        CommonProblem commonProblem = commonProblemDTO.convertToDo();
        commonProblem.setAllTime();
        commonProblemMapper.updateByPrimaryKey(commonProblem);
    }

    @Override
    public void deleteByPrimary(CommonProblemDTO commonProblemDTO) {
        CommonProblem commonProblem = commonProblemDTO.convertToDo();
        commonProblem.setAllTime();
        commonProblemMapper.deleteByPrimaryKey(commonProblem.getId());
        System.out.println("删除成功");
    }
}

