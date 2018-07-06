package com.bluelemontree.depth.deserializers;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.format.DateTimeFormatter;

/**
 * @author duanpeizhou on 2018/7/4 下午4:49.
 */
public class CustomerLocalDateTimeDeserializer extends LocalDateTimeDeserializer{

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public CustomerLocalDateTimeDeserializer() {
        super(dateTimeFormatter);
    }
}
