package com.slipper.config;

import com.slipper.modules.shiro.filter.OAuth2Filter;
import com.slipper.modules.shiro.realm.OAuth2Realm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gumingchen
 */
@Configuration
public class ShiroConfig {

    /**
     * 注入自定义 Realm
     * @return
     */
    @Bean
    public OAuth2Realm oAuth2Realm() {
        OAuth2Realm oAuth2Realm = new OAuth2Realm();
        return oAuth2Realm;
    }

    /**
     * 配置Realm权限管理认证
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(oAuth2Realm());
        securityManager.setRememberMeManager(null);
        return securityManager;
    }

    /**
     * 配置过滤
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        Map<String, Filter> filterMap = new HashMap<>(1);
        filterMap.put("oAuth2", new OAuth2Filter());
        shiroFilter.setFilters(filterMap);

        Map<String, String> mappingMap = new HashMap<>(4);
        mappingMap.put("/client/**", "anon");
        mappingMap.put("/druid/**", "anon");
        mappingMap.put("/static/api/**", "anon");
        mappingMap.put("/console/**", "oAuth2");
        shiroFilter.setFilterChainDefinitionMap(mappingMap);

        return shiroFilter;
    }

    /**
     * 管理 Shiro 生命周期
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
