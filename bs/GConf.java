package bs;

import java.util.HashMap;
import java.util.Map;

class GConf
{
    public static final String httpSrvIP = "127.0.0.1";
    public static final String httpSrvPort = "8080";
    public static final String httpThreadGroupNum = "1";
    public static final String httpSrvWorkThreadNum = "1";
    
    public static final Map<String, String> getConfMap()
    {
        Map<String, String> confMap = new HashMap<String, String>();
        
        confMap.put("httpSrvIP", httpSrvIP);
        confMap.put("httpSrvPort", httpSrvPort);
        confMap.put("httpThreadGroupNum", httpThreadGroupNum);
        confMap.put("httpSrvWorkThreadNum", httpSrvWorkThreadNum);
        
        return confMap;
    }
}