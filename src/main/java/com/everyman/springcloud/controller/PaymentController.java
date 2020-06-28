package com.everyman.springcloud.controller;

import org.springframework.web.bind.annotation.*;
import com.everyman.springcloud.service.IPaymentService;
import com.everyman.springcloud.entity.Payment;

import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

/**
 * 得到的
 *
 * @author zhougang
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @GetMapping("/list")
    public IPage<Payment> list(@RequestParam Integer page, @RequestParam Integer pageCount) {
        return paymentService.selectListByPage(page, pageCount);
    }

    @PostMapping("/add")
    public int add(@RequestBody Payment payment) {
        return paymentService.insertPayment(payment);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return paymentService.deletePaymentById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody Payment payment) {
        return paymentService.updatePayment(payment);
    }

    @GetMapping("/list/{id}")
    public Payment selectPaymentById(@PathVariable Long id) {
        return paymentService.selectPaymentById(id);
    }

}
