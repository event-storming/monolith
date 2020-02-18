package com.example.template;

import com.example.template.product.Product;
import com.example.template.product.ProductOption;
import com.example.template.product.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
//@EnableFeignClients
public class Application {

    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class, args);

        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        // 초기 상품 셋팅
        String[] products = {"TV", "MASK", "NOTEBOOK", "TABLE", "CLOCK"};
        int i = 1;
        for(String p : products){
            Product product = new Product();

            product.setImageUrl("https://github.githubassets.com/images/modules/profile/profile-joined-github.png");
            product.setName(p);
            product.setPrice(i*10000);
            product.setStock(i*10);
            product.setImageUrl("/goods/img/"+p+".jpg");

            // 상품 디테일 추가 - 양방향 관계
            ProductOption productOption = new ProductOption();
            productOption.setName(p + "_detail");
            productOption.setDescription(p + "_desc");
            productOption.setProduct(product);

            ProductOption productOption1 = new ProductOption();
            productOption1.setName(p + "구매설명");
            productOption1.setDescription(p + "설명입니다");
            productOption1.setProduct(product);

            product.addProductOptions(productOption);
            product.addProductOptions(productOption1);

            i++;
            productRepository.save(product);
        }
    }

    // spring-data-rest
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}

