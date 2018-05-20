package SpringCloud.ribbon.service.impl;

import SpringCloud.modle.ServiceInfo;

public interface RibbonRestfulService {

	ServiceInfo getMyTestInfoRestData(String name);

	String getRestData(String name);

	String serviceFallback(String name);

}
