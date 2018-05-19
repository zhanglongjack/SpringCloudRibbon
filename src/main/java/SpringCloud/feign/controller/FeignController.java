package SpringCloud.feign.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringCloud.feign.service.FeignRestService;
import SpringCloud.modle.ServiceInfo;

@RefreshScope
@RestController
@RequestMapping("/feign")
public class FeignController {
	private static final Logger logger = Logger.getLogger(FeignController.class.getName());
	@Autowired
	private FeignRestService restfulService;

	@Value("${server.port}")
	String port;
	@Value("${spring.application.name}")
	String name;

	@RequestMapping("/info")
	public String info(@RequestParam String name) {
		logger.info("/feign/info ========= " + name);
		ServiceInfo info = restfulService.info(name);
		return String.format(
				"I am feign ,My service name is %s,the target service name is %s, and port is %s ,what's the testinfo: %s",
				this.name,info.getName(), info.getPort(), info.getTestInfo());
	}

}