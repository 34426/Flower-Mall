package com.mall.common.config;

import com.mall.common.result.ConstantsFields;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/*图片资源路径映射*/
@Configuration
public class ImgConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO 判断是否已经注册
        if(!registry.hasMappingForPattern("/schoolMall/**")){//file:E://I//
            registry.addResourceHandler("/schoolMall/**").addResourceLocations("file:"+ ConstantsFields.BASEPIC + File.separator + "schoolMall" + File.separator);
        }
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
