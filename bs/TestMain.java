package bs;

import bs.msg.codec.*;
import bs.netty.http.HttpServer;

class TestMain
{
    public static void main(String[] args)
    {
        System.out.println("Hello");
        
        // ��ʼ����Ϣ����map
        GDef.codecEventManager.init();
        
        // ����codec�����߳�
        MsgCodecThread t = new MsgCodecThread();
        t.start();
        
        // ����netty��http�����߳�
        HttpServer httpServer = HttpServer.getInstance(GConf.getConfMap());
        httpServer.run();
        
        /*
        // ģ����Ϣ�����
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