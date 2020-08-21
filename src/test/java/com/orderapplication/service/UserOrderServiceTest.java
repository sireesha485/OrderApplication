package com.orderapplication.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.orderapplication.dto.UserOrderReqDto;
import com.orderapplication.exception.ProductNotFoundException;
import com.orderapplication.model.Product;
import com.orderapplication.repository.CategoryRepository;
import com.orderapplication.repository.ProductRepository;
import com.orderapplication.repository.UserOrderRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserOrderServiceTest {
    @InjectMocks
    private UserOrderService userOrderServiceImpl;

    @Mock
    private UserOrderRepository userOrderRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    private Product product = new Product();

    private UserOrderReqDto userOrderReqDto = new UserOrderReqDto();

    @Before
    public void setup() {

	product.setCatagoryId(1);
	product.setProductName("charger");
	product.setPrice(1000);
	product.setProductCode("233");
	product.setProductId(1);

	userOrderReqDto.setProductId(2);
	userOrderReqDto.setQuantity(3);
	userOrderReqDto.setUserId(1);
	userOrderReqDto.setFromAccountNumber(234566684751L);

    }

    @Test
    public void testOrderProduct() throws ProductNotFoundException {

	when(productRepository.findByProductId(2)).thenReturn(product);
	String message = userOrderServiceImpl.orderProduct(userOrderReqDto);
	Assertions.assertTrue(message.contains("3000"));
    }

    // @Test
    public void testOrderProductFail() throws ProductNotFoundException {

	when(productRepository.findByProductId(2)).thenReturn(null);
	String message = userOrderServiceImpl.orderProduct(userOrderReqDto);
	Assertions.assertThrows(ProductNotFoundException.class, () -> {
	    userOrderServiceImpl.orderProduct(userOrderReqDto);
	});
    }

    @Test(expected = ProductNotFoundException.class)
    public void testOrderProductFail3() throws ProductNotFoundException {

	when(productRepository.findByProductId(2)).thenReturn(null);
	String message = userOrderServiceImpl.orderProduct(userOrderReqDto);
	Assertions.assertTrue(message.contains("3000"));
    }

}
