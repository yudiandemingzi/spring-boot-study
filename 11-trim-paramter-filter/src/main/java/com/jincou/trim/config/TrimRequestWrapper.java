package com.jincou.trim.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jincou.trim.util.StringJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 自定义TrimRequestWrapper类
 *
 * @author xub
 * @date 2022/10/24 下午4:39
 */
@Slf4j
public class TrimRequestWrapper extends HttpServletRequestWrapper {

    /**
     * 保存处理后的参数
     */
    private Map<String, String[]> params = new HashMap<String, String[]>();


    public TrimRequestWrapper(HttpServletRequest request) {
        //将request交给父类，以便于调用对应方法的时候，将其输出
        super(request);
        //对于非json请求的参数进行处理
        if (super.getHeader(HttpHeaders.CONTENT_TYPE) == null ||
                (!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE) &&
                        !super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_UTF8_VALUE))) {
            setParams(request);
        }
    }

    private void setParams(HttpServletRequest request) {
        //将请求的的参数转换为map集合
        Map<String, String[]> requestMap = request.getParameterMap();
        log.info("kv转化前参数：" + JSON.toJSONString(requestMap));
        this.params.putAll(requestMap);
        //去空操作
        this.modifyParameterValues();
        log.info("kv转化后参数：" + JSON.toJSONString(params));
    }

    /**
     * 将parameter的值去除空格后重写回去
     */
    public void modifyParameterValues() {
        Set<String> set = params.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String[] values = params.get(key);
            values[0] = values[0].trim();
            params.put(key, values);
            if (StringUtils.isBlank(values[0])) {
                params.put(key, null);
            }
        }

    }

    /**
     * 重写getParameter 参数从当前类中的map获取
     */
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    /**
     * 重写getParameterValues
     */
    @Override
    public String[] getParameterValues(String name) {//同上
        return params.get(name);
    }


    /**
     * 重写getInputStream方法  post类型的请求参数必须通过流才能获取到值
     * 这种获取的参数的方式针对于内容类型为文本类型，比如Content-Type:text/plain,application/json,text/html等
     * 在springmvc中可以使用@RequestBody 来获取 json数据类型
     * 其他文本类型不做处理，重点处理json数据格式
     * getInputStream() ，只有当方法为post请求，且参数为json格式是，会被默认调用
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        //
        if (!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE) &&
                !super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_UTF8_VALUE)) {
            //如果参数不是json格式则直接返回
            return super.getInputStream();
        }
        //为空，直接返回
        String json = IOUtils.toString(super.getInputStream(), "utf-8");
        if (StringUtils.isEmpty(json)) {
            return super.getInputStream();
        }
        log.info("json转化前参数：" + json);
        //json字符串首尾去空格
        JSONObject jsonObject = StringJsonUtils.JsonStrTrim(json);
        log.info("json转化后参数：" + jsonObject.toJSONString());
        ByteArrayInputStream bis = new ByteArrayInputStream(jsonObject.toJSONString().getBytes("utf-8"));
        return new MyServletInputStream(bis);
    }
    
}
