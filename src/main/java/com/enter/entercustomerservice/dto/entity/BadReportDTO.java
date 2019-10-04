package com.enter.entercustomerservice.dto.entity;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.BadReportMapper;
import com.enter.entercustomerservice.dto.Convertible;
import com.enter.entercustomerservice.entity.BadReport;
import com.enter.entercustomerservice.service.BadReportService;
import com.enter.entercustomerservice.service.impl.BadReportServiceImpl;
import io.netty.util.AsciiString;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： BadReportDTO
 * @描述：
 * @date 2019/9/28
 */
@Data
public class BadReportDTO implements Serializable {
    private static final long serialVersionUID = -8918083910984559636L;

    /**
     * 举报id
     */
    private Integer id;

    /**
     * 说明举报所属的项目
     */
    private Integer projectType;

    /**
     * 举报的图片列表
     */
    private String imgPaths;

    /**
     * 举报人微信号
     */
    private String wechatNumber;

    /**
     * 举报内容
     */
    private String content;

    private static BadReportConvert badReportConvert;

    static {
        badReportConvert = new BadReportConvert();
    }

    public BadReport convertToDo() {

        return badReportConvert.convertToDO(this);
    }

    public BadReportDTO convertToDto(BadReport badReport) {
        return badReportConvert.convertToDTO(badReport);
    }

    public Integer getUserId() {
        return id;
    }

    public String getReportContent() {
        return content;
    }

    public String getImgPath() {
        return imgPaths;
    }

    public BadReport convertToBadReport() {
        return badReportConvert.convertToDO(this);
    }

    public BadReportDTO convertToBadReportDTO(BadReport badReport) {
        return badReportConvert.convertToDTO(badReport);
    }

    public void setImgPath(String imgPath) {
        this.imgPaths = imgPath;
    }

    public static class BadReportConvert implements Convertible<BadReport, BadReportDTO> {

        @Override
        public BadReport convertToDO(BadReportDTO badReportDTO) {
            BadReport badReport = new BadReport();
            BeanUtils.copyProperties(badReportDTO, badReport);
            return badReport;
        }

        @Override
        public BadReportDTO convertToDTO(BadReport badReport) {
            BadReportDTO badReportDTO = new BadReportDTO();
            BeanUtils.copyProperties(badReport, badReportDTO);
            return badReportDTO;
        }
    }
}
