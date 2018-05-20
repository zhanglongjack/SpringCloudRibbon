package SpringCloud.feign.service.impl;

import org.springframework.stereotype.Component;

import SpringCloud.feign.service.FeignRestService;
import SpringCloud.modle.ServiceInfo;

@Component
public class FeignRestServiceImpl implements FeignRestService {

	@Override
	public ServiceInfo info(String message) {
		return new ServiceInfo("error",message,-1);
	}

}
