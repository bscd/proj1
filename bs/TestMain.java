package bs;

import bs.msg.codec.*;
import bs.netty.http.HttpServer;

class TestMain
{
    public static void main(String[] args)
    {
        System.out.println("Hello");
        
        // 初始化消息处理map
        GDef.codecEventManager.init();
        
        // 启动codec处理线程
        MsgCodecThread t = new MsgCodecThread();
        t.start();
        
        // 启动netty的http监听线程
        HttpServer httpServer = HttpServer.getInstance(GConf.getConfMap());
        httpServer.run();
        
        /*
        // 模拟消息入队列
        CodecEvent e = new CodecEvent();
        e.setEncode(false);
        e.setMsgType(GDef.MSG_TYPE_LOGIN);
        e.setMsgJSON("{\"Name\":\"Jack\"}");
        GDef.codecQueue.add(e);
        
        CodecEvent e1 = new CodecEvent();
        e1.setEncode(true);
        e1.setMsgType(GDef.MSG_TYPE_LOGOUT);
        e1.setMsgJSON("{\"Name\":\"Jack.111\"}");
        GDef.codecQueue.add(e1);
        */
        
        while (true)
        try
        {
            Thread.sleep(10000);
            System.out.println("[main thread] still alive.");
        } catch (InterruptedException ee)
        {
            ee.printStackTrace();
        }
        
        /*
        System.out.println("[main thread] will exit.");
        t.stopRunning();
        */
    }
}