package SpringCloud.Ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.model.ServiceInfo;

@Service("restfulSerivce")
public class RestfulServiceImpl {

    @Autowired private RestTemplate restTemplate ;

    public String getRestData(String name){
        return restTemplate.getForObject("http://spring-cloud-config-client/say?message="+name,String.class) ;
    }
    
    public ServiceInfo getMyTestInfoRestData(String name){
    	return restTemplate.getForObject("http://spring-cloud-config-client/info?message="+name,ServiceInfo.class) ;
    }
}