package com.enter.service.context.ramdomid.uuid;

import com.enter.service.context.ramdomid.StringRandomizer;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.UUID;

/**
 * @author Liquid
 * @类名： UuidRandomizer
 * @描述：
 * @date 2019/4/14
 */
@Component("uuid")
public class UuidRandomizer implements StringRandomizer {

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    @Override
    public String getRandom() {
        return UUID.randomUUID().toString().replace("-", "") + Calendar.getInstance().getTimeInMillis();
    }

    @Override
    public String getRandomStringWithBit(int bit) {
        StringBuilder id = new StringBuilder(getRandomUUID());
        while (id.length()<bit){
            id.append(getRandomUUID());
        }
        return id.substring(0, bit);
    }

    private String getRandomUUID(){
        return  UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
