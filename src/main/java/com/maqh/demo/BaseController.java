package com.maqh.demo;

/**
 * web层通用数据处理
 * 
 * @author ruoyi
 */
public class BaseController
{


    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected ResultBean toAjax(int rows)
    {
        return rows > 0 ? ResultBean.success() : ResultBean.error();
    }
}
