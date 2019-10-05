package com.enter.entercustomerservice.context.template;

import com.enter.entercustomerservice.exception.CheckedException;
import com.enter.entercustomerservice.dto.template.BaseTemplateDTO;
/**
 * Created by Administrator on 2019/9/30.
 */
public interface SendTemplator {

    void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException;
}
