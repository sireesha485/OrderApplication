package com.orderapplication.controller;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.orderapplication.dto.UserOrderReqDto;
import com.orderapplication.exception.ProductNotFoundException;
import com.orderapplication.service.UserOrderService;

@RunWith(MockitoJUnitRunner.class)
public class UserOrderControllerTest {
    @InjectMocks
    private UserOrderController userOrderController;
    @Mock
    private UserOrderService userOrderServiceImpl;

    @Test
    public void testOrder() throws ProductNotFoundException {
	UserOrderReqDto userOrderReqDto = new UserOrderReqDto();

	userOrderReqDto.setProductId(2);
	userOrderReqDto.setQuantity(3);
	userOrderReqDto.setUserId(1);
	userOrderReqDto.setFromAccountNumber(234566684751L);
	when(userOrderServiceImpl.orderProduct(userOrderReqDto))
		.thenReturn("order placed successfully,total price is:3000");
	Assertions.assertTrue(userOrderController.orderProduct(userOrderReqDto).getBody()
		.contains("order placed successfully,total price is:3000"));
    }
}
