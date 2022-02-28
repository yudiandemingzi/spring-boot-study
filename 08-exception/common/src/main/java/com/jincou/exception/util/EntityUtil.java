package com.jincou.exception.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 实体转换工具
 *
 * @author xub
 * @date 2020/7/8 下午8:00
 */
@Slf4j
public class EntityUtil {


    /**
     * 实体转换
     */
    public static <T> T changeEntityNew(Class<T> target, Object baseTO) {
        try {
            T obj = target.newInstance();
            if (baseTO == null)
                return null;
            org.springframework.beans.BeanUtils.copyProperties(baseTO, obj);
            return obj;
        } catch (Exception e) {
            //e.printStackTrace();
//			log.info("====调用BeanUtils报错，改用自己方法"+e.getMessage());
            return changeEntity(target, baseTO);
        }
    }

    /**
     * 实体类列表转换
     */
    public static <T> List<T> changeEntityListNew(Class<T> target, List<?> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<T> resultList = new ArrayList<T>();
        for (Object obj : list) {
            resultList.add(changeEntityNew(target, obj));
        }
        return resultList;
    }

    /**
     * @param target 目标对象class
     * @param baseTO 被转换对象
     * @throws
     * @Description: TODO 对象转换（set/get方法、参数一致的会被转换）
     */
    public static <T> T changeEntity(Class<T> target, Object baseTO) {
        T obj = null;
        if (baseTO == null)
            return null;
        try {
            obj = target.newInstance();
            List<Method> targetmethods = Arrays.asList(target.getDeclaredMethods());
            List<String> methodnames = new ArrayList<String>();
            for (Method method : targetmethods)
                methodnames.add(method.getName());
            Method[] methods = baseTO.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.getName().startsWith("get")) {
                    String _tar = "set" + method.getName().substring(method.getName().indexOf("get") + 3);
                    if (methodnames.contains(_tar)) {
                        Method tarMethod = targetmethods.get(methodnames.indexOf(_tar));
                        if (tarMethod.getParameterTypes()[0].equals(method.getReturnType())) {
                            tarMethod.setAccessible(true);
                            tarMethod.invoke(obj, method.invoke(baseTO));
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("解析错误", e);
        }
        return obj;
    }


}
