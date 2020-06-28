package com.everyman.springcloud.service.impl;

import com.everyman.springcloud.entity.Payment;
import com.everyman.springcloud.mapper.PaymentMapper;
import com.everyman.springcloud.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 得到的 服务实现类
 *
 * @author zhougang
 */
@Service
@Slf4j
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {

    @Override
    public IPage<Payment> selectListByPage(Integer page, Integer pageCount) {
        IPage<Payment> wherePage = new Page<>(page, pageCount);
        Payment where = new Payment();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int insertPayment(Payment payment) {
        return baseMapper.insert(payment);
    }

    @Override
    public int deletePaymentById(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updatePayment(Payment payment) {
        return baseMapper.updateById(payment);
    }

    @Override
    public Payment selectPaymentById(Long id) {
        return baseMapper.selectById(id);
    }
}
