package SpringCloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringCloud.modle.ServiceInfo;
@FeignClient("spring-cloud-config-client")
public interface RestService {
	@RequestMapping(value = "/info")
	ServiceInfo info(String message);
}