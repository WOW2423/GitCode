package com.enter.service.pojo.dto;

/**
 * @className VoConvertible
 * @auther DylanChan
 * @description
 * @date 2019/10/3
 */
public interface VoConvertible <V, T> {
    V convertToVO(T t);

    T convertToDTO(V v);
}