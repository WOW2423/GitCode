package com.enter.entercustomerservice.dao.database.mysql.mybatis;

import com.enter.entercustomerservice.entity.BadReport;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/25
 */
@CacheNamespace
@org.apache.ibatis.annotations.Mapper
@Repository
public interface BadReportMapper extends Mapper<BadReport> {
}