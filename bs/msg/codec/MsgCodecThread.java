package bs.msg.codec;

import bs.GDef;

public class MsgCodecThread extends Thread
{
    
    private static boolean bRunning = true;
    
    public void stopRunning()
    {
        bRunning = false;
    }
    
    public void run()
    {
        System.out.println("Start thread codec--------------------------");
        
        while (bRunning)
        {
            // 1.��queue��ȡ��event��ûȡ����������sleep
            CodecEvent event = GDef.codecQueue.poll();
            if (null == event)
            {
                // ���п��ˣ���Ϣ500ms
                try
                {
                    Thread.sleep(500);
                    continue;
                } catch (InterruptedException e)
                {
                    System.out.println("Error while try to sleep.");
                    e.printStackTrace();
                }
            }

            // 2.�ж���Ϣ���ͣ��ҵ��������
            GDef.codecEventManager.proc(event);
            System.out.println("thread proc an event.");
        }
        
        System.out.println("Existing thread codec--------------------------");
    }
}