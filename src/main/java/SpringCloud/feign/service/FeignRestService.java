package SpringCloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringCloud.feign.service.impl.FeignRestServiceImpl;
import SpringCloud.modle.ServiceInfo;
@FeignClient(name = "spring-cloud-config-client",fallback = FeignRestServiceImpl.class)
public interface FeignRestService {
	@RequestMapping(value = "/info")
	ServiceInfo info(String message);
}