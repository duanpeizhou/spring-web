package com.bluelemontree.depth.mapper;

import org.springframework.stereotype.Service;

/**
 * @author duanpeizhou on 2018/4/15 下午7:07.
 */
@Service
public class HelloMapper {
    public String hello() {
        return "Nice to meet you too, Tom";
    }
}
