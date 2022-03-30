package com.mc.mcsoul.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    /**
     * 让 MappingJackson2HttpMessageConverter 能处理头部 Content-Type 为 text/plain 类型的 Json 返回值的话，
     * 我们就能让其帮我们把 Json 反序列化成我们要的对象。
     * 继承 MappingJackson2HttpMessageConverter
     * 并在构造过程中设置其支持的 MediaType 类型即可：
     */
    public WxMappingJackson2HttpMessageConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        // 覆盖其默认的 MediaType 设置
        setSupportedMediaTypes(mediaTypes);
    }

    /**
     * SpringCloud可以自动注入RestTemplate，但是分离出来的Springboot无法通过@Autowired实现自动注入
     * 官方说明：
     * Spring Boot <= 1.3; 无需定义,Spring BootBoot自动为您定义了一个.
     * Spring Boot >= 1.4; Spring Boot不再自动定义一个RestTemplate，
     * 而是定义了一个RestTemplateBuilder允许您更好地控制所RestTemplate创建的对象
     * @return restTemplate
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        // 把 WxMappingJackson2HttpMessageConverter 追加到 RestTemplate 的 messageConverters 消息转换链中去：
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }

}
