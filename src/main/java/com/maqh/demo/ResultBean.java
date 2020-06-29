package com.maqh.demo;

import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author zhougang
 */
public class ResultBean extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 ResultBean 对象，使其表示一个空消息。
     */
    public ResultBean() {
    }

    /**
     * 初始化一个新创建的 ResultBean 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public ResultBean(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 ResultBean 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public ResultBean(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (!StringUtils.isEmpty(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResultBean success() {
        return ResultBean.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResultBean success(Object data) {
        return ResultBean.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResultBean success(String msg) {
        return ResultBean.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResultBean success(String msg, Object data) {
        return new ResultBean(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResultBean error() {
        return ResultBean.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResultBean error(String msg) {
        return ResultBean.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResultBean error(String msg, Object data) {
        return new ResultBean(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static ResultBean error(int code, String msg) {
        return new ResultBean(code, msg, null);
    }

}
