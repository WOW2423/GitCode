package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.CommonProblemMapper;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.dto.entity.CommonProblemDTO;
import com.enter.entercustomerservice.entity.CommonProblem;
import com.enter.entercustomerservice.service.CommonProblemService;
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
    public List<BadReportDTO> selectAll() {
        List<CommonProblem> commonProblems = commonProblemMapper.selectAll();
        List<CommonProblemDTO> commonProblemDTOList=new ArrayList<>();
        for (CommonProblem commonProblem : commonProblems) {
            CommonProblemDTO commonProblemDTO = new CommonProblemDTO().convertToDto(commonProblem);
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
        return new CommonProblemDTO().convertToDto(c);
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

