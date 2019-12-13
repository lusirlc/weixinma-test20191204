package pers.luchuan.weixinma.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 微信小程序属性配置
 * Created by luchuan on 2019/12/13
 */
@Data
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxMaProperties {

    /**
     * 设置微信小程序的appid
     */
    private String appid;

    /**
     * 设置微信小程序的Secret
     */
    private String secret;

    /**
     * 设置微信小程序消息服务器配置的token
     */
//    private String token;

    /**
     * 设置微信小程序消息服务器配置的EncodingAESKey
     */
//    private String aesKey;

    /**
     * 消息格式，XML或者JSON
     */
//    private String msgDataFormat;

}
