package pers.luchuan.weixinma.controller;

import cn.binarywang.wx.miniapp.api.WxMaMsgService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeData;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.luchuan.weixinma.config.WxMaConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By Lu Chuan On 2019/12/3
 */
@RestController
@RequestMapping("/wx/msg")
public class WxMaMsgController {
	@Autowired
	private WxMaService wxMaService;
	@PostMapping("/sendSubscribeMsg")
	public void sendSubscribeMsg() {
		WxMaSubscribeData subscribeData1 = new WxMaSubscribeData();
		subscribeData1.setName("name1");
		subscribeData1.setValue("小书包");
		WxMaSubscribeData subscribeData2 = new WxMaSubscribeData();
		subscribeData2.setName("number2");
		subscribeData2.setValue("2");
		WxMaSubscribeData subscribeData3 = new WxMaSubscribeData();
		subscribeData3.setName("date3");
		subscribeData3.setValue("2019年10月11日 08:20");
		List<WxMaSubscribeData> data = Arrays.asList(subscribeData1, subscribeData2,subscribeData3);
		WxMaSubscribeMessage subscribeMessage = new WxMaSubscribeMessage();
		subscribeMessage.setData(data);
		subscribeMessage.setPage("1");
		subscribeMessage.setTemplateId("Yn2r0PHbi1hqJax1op-d05UCbYYjuRnXS73AaEtN2xk");
		
		subscribeMessage.setToUser("oVnKv4pUwx7Dr9A4lGqkFQmOtCUI");
		WxMaMsgService msgService = wxMaService.getMsgService();
		try {
			msgService.sendSubscribeMsg(subscribeMessage);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
}
