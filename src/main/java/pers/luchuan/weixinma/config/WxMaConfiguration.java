package pers.luchuan.weixinma.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaKefuMessage;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateData;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import cn.binarywang.wx.miniapp.config.impl.WxMaRedisConfigImpl;
import cn.binarywang.wx.miniapp.message.WxMaMessageHandler;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import com.google.common.collect.Lists;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

import java.io.File;

/**
 * 微信小程序服务配置
 * Created by luchuan on 2019/12/13
 */
@Configuration
@EnableConfigurationProperties({WxMaProperties.class,RedisProperties.class})
public class WxMaConfiguration {
    private WxMaProperties wxMaProperties;
    private RedisProperties redisProperties;
    @Autowired
    public WxMaConfiguration(WxMaProperties wxMaProperties, RedisProperties redisProperties) {
        this.wxMaProperties = wxMaProperties;
        this.redisProperties = redisProperties;
    }
    @Bean
    public WxMaService wxMaService() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//        poolConfig.setMaxTotal(redisProperties.getPoolMaxActive());
        JedisPool pool = new JedisPool(poolConfig,redisProperties.getHost(),
                redisProperties.getPort(),redisProperties.getTimeout(),redisProperties.getPassword());
        WxMaRedisConfigImpl  config = new WxMaRedisConfigImpl();
        config.setJedisPool(pool);
        config.setAppid(wxMaProperties.getAppid());
        config.setSecret(wxMaProperties.getSecret());
//        config.setToken(wxMaProperties.getToken());
//        config.setAesKey(wxMaProperties.getAesKey());
//        config.setMsgDataFormat(wxMaProperties.getMsgDataFormat());

        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return service;
    }


}
