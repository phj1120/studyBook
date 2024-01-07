package com.parkh.cleancode.ch09.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Spring 을 띄우고 테스트 함.
 * 통합 테스트에 적합
 * */
@SpringBootTest
class ProductServiceTestByMockBean {

    @MockBean
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @Test
    void getProductsTest() {
        // given
        List<Product> mockProducts = List.of(
                new Product("1", "MOCK 상품", 1000)
        );
        given(productMapper.getProducts()).willReturn(mockProducts);


        // when
        List<Product> products = productService.getProducts();

        // then
        Assertions.assertThat(products).isEqualTo(mockProducts);
    }

    @Test
    void getProductsTest_Empty() {
        // given
        // 어떤 값이 반환 될 지 지정해주지 않으면, 빈 객체가 반환된다.

        // when
        List<Product> products = productService.getProducts();

        // then
        Assertions.assertThat(products).isEmpty();
    }

}