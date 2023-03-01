package com.jsh.erp.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2023/3/1 17:10
 */
@Configuration
public class TomcatConfig {

    @Bean
    public ServletWebServerFactory webServerFactory() {
        // 解决 由于 升级到高版本tomcat后url传参带有[], 报400错误
        TomcatServletWebServerFactory fa = new TomcatServletWebServerFactory();
        fa.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "[]{}"));
        return fa;
    }

}
