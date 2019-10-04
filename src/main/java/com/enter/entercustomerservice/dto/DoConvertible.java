package com.enter.entercustomerservice.dto;

/**
 * @className DTOConvert
 * @auther Liquid
 * @description
 * @date 2018/12/22
 */
public interface DoConvertible<O, T> {
    O convertToDO(T t);

    T convertToDTO(O o);
}
