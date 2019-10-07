package com.enter.service.context.token;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： Token
 * @描述：
 * @date 2019/5/18
 */
@Data
public class Token implements Serializable {
    private static final long serialVersionUID = -7584568284948370500L;

    private String tokenId;

    private String tokenName;

    private Long  expired;
}
