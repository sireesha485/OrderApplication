package com.orderapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderapplication.dto.UserOrderReqDto;
import com.orderapplication.exception.ProductNotFoundException;
import com.orderapplication.model.Product;
import com.orderapplication.model.UserOrder;
import com.orderapplication.repository.CategoryRepository;
import com.orderapplication.repository.ProductRepository;
import com.orderapplication.repository.UserOrderRepository;

@Service
public class UserOrderService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserOrderRepository userOrderRepository;

    public String orderProduct(UserOrderReqDto userOrderReqDto) throws ProductNotFoundException {
	UserOrder userOrder = new UserOrder();

	Product product = productRepository.findByProductId(userOrderReqDto.getProductId());
	if (product == null) {

	    throw new ProductNotFoundException("product not available");
	}
	double totalPrice = product.getPrice() * userOrderReqDto.getQuantity();
	userOrder.setTotalPrice(totalPrice);
	userOrder.setProductId(userOrderReqDto.getProductId());
	userOrder.setUserId(userOrderReqDto.getUserId());
	userOrder.setQuantity(userOrderReqDto.getQuantity());
	userOrderRepository.save(userOrder);
	return "UserOrder placed succesfully,total price is:" + totalPrice;
    }
}
