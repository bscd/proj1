package bs;

import bs.msg.codec.*;

class TestMain
{
    public static void main(String[] args)
    {
        System.out.println("Hello");
        
        // ��ʼ����Ϣ����map
        GDef.codecEventManager.init();
        
        // ���������߳�
        MsgCodecThread t = new MsgCodecThread();
        t.start();
        
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
        
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException ee)
        {
            // TODO Auto-generated catch block
            ee.printStackTrace();
        }
        
        t.stopRunning();
    }
}