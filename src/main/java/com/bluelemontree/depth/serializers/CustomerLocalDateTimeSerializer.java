package com.bluelemontree.depth.serializers;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.format.DateTimeFormatter;

/**
 * @author duanpeizhou on 2018/7/4 下午3:21.
 */
public class CustomerLocalDateTimeSerializer extends LocalDateTimeSerializer {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public CustomerLocalDateTimeSerializer() {
        super(dateTimeFormatter);
        System.out.println("============="+dateTimeFormatter);
    }
}
