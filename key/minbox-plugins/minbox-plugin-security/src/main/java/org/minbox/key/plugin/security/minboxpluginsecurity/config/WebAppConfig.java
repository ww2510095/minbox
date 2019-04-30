package org.minbox.key.plugin.security.minboxpluginsecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * 注册拦截器
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：
        registry.addInterceptor(new MinboxSecurityHandlerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
