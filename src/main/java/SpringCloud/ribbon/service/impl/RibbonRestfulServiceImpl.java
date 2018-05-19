package SpringCloud.ribbon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import SpringCloud.modle.ServiceInfo;

@Service("restfulSerivce")
public class RibbonRestfulServiceImpl implements RibbonRestfulService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "serviceFallback")
	public String getRestData(String name) {
		return restTemplate.getForObject("http://spring-cloud-config-client/say?message=" + name, String.class);
	}

	@Override
	public ServiceInfo getMyTestInfoRestData(String name) {
		return restTemplate.getForObject("http://spring-cloud-config-client/info?message=" + name, ServiceInfo.class);
	}

	@Override
	public String serviceFallback(String name) {
		return "hi,sorry,error!";
	}
}