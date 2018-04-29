package SpringCloud.Ribbon;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class RestfulController {
    private static final Logger logger = Logger  
            .getLogger(RestfulController.class.getName());  
    @Autowired private RestfulServiceImpl restfulService ;

    @Value("${server.port}")
    String port ;
    @Value("${spring.application.name}")
    String name ;

    @RequestMapping("/home")
    public String home(@RequestParam String message){
    	logger.info("test========="+message);
        return "my info from port("+port+") from application name("+name+") invoke other service." + "\n"
                +restfulService.getRestData(message);
    }
    
    @RequestMapping("/test")
    public String test(@RequestParam String name){
    	logger.info("test========="+name);
        return name;
    }
}