package com.orderapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderapplication.dto.UserOrderReqDto;
import com.orderapplication.exception.ProductNotFoundException;
import com.orderapplication.service.UserOrderService;

@RestController
//@RequestMapping("/shopping")
public class UserOrderController {

    @Autowired
    UserOrderService userOrderServiceImpl;

    @PostMapping("/order")
    public ResponseEntity<String> orderProduct(@RequestBody UserOrderReqDto userOrderReqDto)
	    throws ProductNotFoundException {

	String mesage = userOrderServiceImpl.orderProduct(userOrderReqDto);

	return new ResponseEntity<>(mesage, HttpStatus.CREATED);
    }

}
