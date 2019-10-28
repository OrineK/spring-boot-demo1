package com.example.springbootdemo1.util;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo1.constant.ResultCode;
import com.example.springbootdemo1.constant.ResultMsg;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;

/**
 * @aythor: Orine
 * @date: 2019/8/8
 */
public class ResultUtil extends HashMap<String, Object> {

    /**
     * layui 数据表格必须格式
     * @param count 查询数据总量
     * @param data  数据列表
     * @return
     */
    public static ResultUtil data(Long count, List<?> data) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", 0);
        resultUtil.put("msg", ResultMsg.OPERATE_SUCCESS);
        resultUtil.put("count", count);
        resultUtil.put("data", data);
        return resultUtil;
    }

    /**
     * app端需要的分页数据
     * @param data
     * @return
     */
    public static ResultUtil data(Page data) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", ResultCode.SUCCESS);
        resultUtil.put("data", data);
        return resultUtil;
    }

    /**
     * 成功 返回信息
     * @param msg
     * @return
     */
    public static ResultUtil ok(String msg) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", ResultCode.SUCCESS);
        resultUtil.put("msg", msg);
        return resultUtil;
    }

    /**
     * 成功 返回数据
     * @param data
     * @return
     */
    public static ResultUtil ok (JSONObject data) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", ResultCode.SUCCESS);
        resultUtil.put("msg", ResultMsg.OPERATE_SUCCESS);
        resultUtil.put("data", data);
        return resultUtil;
    }

    /**
     * 返回错误提示
     * @param code
     * @param msg
     * @return
     */
    public static ResultUtil error(String code, String msg) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", code);
        resultUtil.put("msg", msg);
        return resultUtil;
    }
}
