package SpringCloud.ribbon.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringCloud.modle.ServiceInfo;
import SpringCloud.ribbon.service.impl.RibbonRestfulService;

@RefreshScope
@RestController
@RequestMapping("/ribbon")
public class RibbonRestfulController {
	private static final Logger logger = Logger.getLogger(RibbonRestfulController.class.getName());
	@Autowired
	private RibbonRestfulService restfulService;

	@Value("${server.port}")
	String port;
	@Value("${spring.application.name}")
	String name;

	@RequestMapping("/home")
	public String home(@RequestParam String message) {
		logger.info("test=========" + message);
		return "my info from port(" + port + ") from application name(" + name + ") invoke other service." + "\n"
				+ restfulService.getRestData(message);
	}

	@RequestMapping("/test")
	public String test(@RequestParam String name) {
		logger.info("test=========" + name);
		return name;
	}

	@RequestMapping("/info")
	public String info(@RequestParam String name) {
		logger.info("test=========" + name);
		ServiceInfo info = restfulService.getMyTestInfoRestData(name);
		return String.format("I am ribbon, the service name is %s, and port is %s ,what's the testinfo ==%s", info.getName(),
				info.getPort(), info.getTestInfo());
	}
	
}