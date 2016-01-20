package bs.netty.http;

import java.util.Map;

public final class HttpServer extends TcpServer implements Runnable
{

    private static String httpSrvIp;
    private static int httpSrvPort;
    private static int threadGroupNum;
    private static int workingThreadNum;

    private HttpServer()
    {
    }

    private static class HttpServerGetInstance
    {
        private static final HttpServer instance = new HttpServer();
    }

    public static final HttpServer getInstance(Map<String, String> confMap)
    {
        httpSrvIp = confMap.get("httpSrvIP");
        httpSrvPort = Integer.valueOf(confMap.get("httpSrvPort"));
        threadGroupNum = Integer.valueOf(confMap.get("httpThreadGroupNum"));
        workingThreadNum = Integer.valueOf(confMap.get("httpSrvWorkThreadNum"));
        return HttpServerGetInstance.instance;
    }

    public void run()
    {
        TcpServer.start(threadGroupNum, workingThreadNum, httpSrvIp, httpSrvPort, new HttpChannelInitializer());
    }
}