package com.parkh.cleancode.ch09.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Spring 을 안띄우고 테스트 할 수 있음, 대신 필요한 의존성을 다 주입 해줘야함.
 * 단위 테스트에 적합
 * */
class ProductServiceTestByMock {
    @Mock
    private ProductMapper productMapper;

    private ProductService productService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(productMapper);
    }

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
    void getProductsTest_empty() {
        // given
        // 어떤 값이 반환 될 지 지정해주지 않으면, 빈 객체가 반환된다.

        // when
        List<Product> products = productService.getProducts();

        // then
        Assertions.assertThat(products).isEmpty();
    }

}