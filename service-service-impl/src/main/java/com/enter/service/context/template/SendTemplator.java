package com.enter.service.context.template;

import com.enter.service.pojo.dto.template.BaseTemplateDTO;
import com.enter.util.exception.CheckedException;

/**
 * Created by Administrator on 2019/9/30.
 */
public interface SendTemplator {

    void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException;
}
