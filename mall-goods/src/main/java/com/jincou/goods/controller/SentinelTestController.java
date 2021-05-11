package com.jincou.goods.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试sentinel
 *
 * @author xub
 * @date 2021/3/30 下午3:31
 */
@RestController
@RequestMapping("api/v1/sentinel")
public class SentinelTestController {

    private volatile int total = 0;

    @RequestMapping("test-sentinel")
    public Object findByGoodsId() {
        return JSONObject.toJSONString(String.valueOf(total++));
    }


    @RequestMapping("test-sentinel-exception")
    public Object testSentinelException() {
        int i = (int) (Math.random() * 100);
        if(i>50){
            throw new NullPointerException("随机错误");
        }
        return "成功";
    }


}
