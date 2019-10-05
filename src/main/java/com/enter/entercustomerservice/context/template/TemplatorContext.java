package com.enter.entercustomerservice.context.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.enter.entercustomerservice.dto.template.BaseTemplateDTO;
/**
 * Created by Administrator on 2019/9/30.
 */
@Component("templatorContext")
public class TemplatorContext<T> {

    @Autowired
    private static SendTemplatorFactory sendTemplatorFactory;

    public static void sendTemplate(BaseTemplateDTO baseTemplateDTO, String beanName) throws Exception {

        SendTemplator sendTemplator = sendTemplatorFactory.createSendTemplator(beanName);
        sendTemplator.sendTemplate(baseTemplateDTO);
    }

}