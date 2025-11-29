package com.lusheng.langchain4jspringbootdemo.controller;


import com.lusheng.langchain4jspringbootdemo.Service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
//	@Autowired
//	private OpenAiChatModel model;
	@Autowired
	private ConsultantService consultantService;

//	@RequestMapping("/chat") // 指定访问路径
//	public String chat(String message) {  // 浏览器传递的用户问题
////		String result = model.chat(message);
////		return result;
//		String result = consultantService.chat(message);
//		return result;
//	}

	// 流式调用
	@RequestMapping(value = "/chat",produces = "text/html;charset=utf-8") // 指定访问路径
	public Flux<String> chat(String memoryId, String message) {  // 浏览器传递的用户问题
		Flux<String> result = consultantService.chat(memoryId,message);
		return result;
	}
}
