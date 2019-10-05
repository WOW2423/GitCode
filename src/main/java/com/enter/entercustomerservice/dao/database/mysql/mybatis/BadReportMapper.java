package com.enter.entercustomerservice.dao.database.mysql.mybatis;

import com.enter.entercustomerservice.pojo.entity.BadReport;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 插入举报数据
     * @param badReport 用户举报内容
     * @return 受影响的行数
     */
    int insert(BadReport badReport);

    /**
     * 更新举报信息
     * @param id 举报id
     * @param projectType 举报所属项目
     * @param imgPaths 举报图片列表
     * @param wechatNumber 举报人微信号
     * @param content 举报内容
     * @return 受影响的行数
     */
    Integer updateBadReport(
            @Param("id") Integer id,
            @Param("projectType") Integer projectType,
            @Param("imgPaths") String imgPaths,
            @Param("wechatNumber") String wechatNumber,
            @Param("content") String content);

    /**
     * 查询举报数据
     * @param id 举报ID
     * @return 受影响的行数
     */
    int getBadReportById(Integer id);

    /**
     * 查询举报数据
     * @param wechatNumber 举报者微信号
     * @return 受影响的行数
     */
    int getBadReportByWechatNumber(String wechatNumber);

    /**
     * 删除举报数据
     * @param id 举报ID
     * @return 受影响的行数
     */
    //int deleteBadReport(Integer id);


}