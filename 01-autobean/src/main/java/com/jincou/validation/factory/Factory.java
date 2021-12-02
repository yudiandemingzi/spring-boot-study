package com.jincou.validation.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: 创建实例的工厂
 */
public class Factory implements FactoryBean<FacBean> {

    public FacBean getObject() throws Exception {
        return new FacBean();
    }
    public Class<?> getObjectType() {
        return FacBean.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
