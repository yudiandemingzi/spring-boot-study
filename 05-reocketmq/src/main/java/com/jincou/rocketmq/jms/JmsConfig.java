package com.jincou.rocketmq.jms;


/**
 * @Description: 安装实际开发这里的信息 都是应该写在配置里，来读取，这里为了方便所以写成常量
 * @author xub
 * @date 2019/6/29 下午6:44
 */
public class JmsConfig {

    /**
     * Name Server 地址，因为是集群部署 所以有多个用 分号 隔开
     */
    public static final String NAME_SERVER = "47.99.203.55:9876;47.99.203.55:9877";

    /**
     * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
     */
    public static final String TOPIC = "topic_family";

}
