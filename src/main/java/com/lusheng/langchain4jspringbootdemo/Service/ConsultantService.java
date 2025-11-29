package com.lusheng.langchain4jspringbootdemo.Service;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

//@AiService(
//		wiringMode = AiServiceWiringMode.EXPLICIT, // 手动装配
//		chatModel = "openAiChatModel" // 制定模型
//)
//@AiService
//public interface ConsultantService {
////	用于聊天的方法 message为用户输入的内容
//	 public String chat(String message);
//}


// 流式调用
@AiService(
		wiringMode = AiServiceWiringMode.EXPLICIT,
		chatModel = "openAiChatModel",
		streamingChatModel = "openAiStreamingChatModel",
//		chatMemory = "chatMemory"  // 配置会话记忆对象
		chatMemoryProvider = "chatMemoryProvider"  //  配置会话记忆提供者对象

)
public interface ConsultantService {
	//	用于聊天的方法 message为用户输入的内容
//	@SystemMessage("你是智能售货机的ai助手 请你基于智能售后机的相关知识回答用户问题")
//	@SystemMessage("你叫小智 你是人类的好朋友")
	@SystemMessage(fromResource = "system01.txt")
	public Flux<String> chat(@MemoryId  String memoryId,@UserMessage String message);
}