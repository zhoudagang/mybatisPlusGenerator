package com.everyman.springcloud.service;

import com.everyman.springcloud.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 得到的 服务类
 *
 * @author zhougang
 */
public interface IPaymentService extends IService<Payment> {

    /**
     * 查询得到的分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Payment>
     */
     IPage<Payment> selectListByPage(Integer page, Integer pageCount);

    /**
     * 添加得到的
     *
     * @param payment 得到的
     * @return int
     */
     int insertPayment(Payment payment);

    /**
     * 删除得到的
     *
     * @param id 主键
     * @return int
     */
     int deletePaymentById(Long id);

    /**
     * 修改得到的
     *
     * @param payment 得到的
     * @return int
     */
     int updatePayment(Payment payment);

    /**
     * id查询数据
     *
     * @param id id
     * @return Payment
     */
     Payment selectPaymentById(Long id);
}
