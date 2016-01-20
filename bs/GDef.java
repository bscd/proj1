package bs;

import java.util.concurrent.LinkedBlockingQueue;

import bs.msg.codec.CodecEvent;
import bs.msg.codec.CodecEventManager;

public class GDef
{
    // ��Ϣ����
    public final static String MSG_TYPE_LOGIN = "MSG_TYPE_LOGIN";
    public final static String MSG_TYPE_LOGOUT = "MSG_TYPE_LOGOUT";
    
    
    // ��������
    public final static int RET_OK = 0;
    public final static int RET_ERR = -1;
    
    public final static String RESULT_INVALIDMETHOD = "90001";
    
    // ȫ�ֱ���
    // ��Ϣ�������
    public static LinkedBlockingQueue<CodecEvent> codecQueue = new LinkedBlockingQueue<CodecEvent>();
    
    // ����������
    public static CodecEventManager codecEventManager = CodecEventManager.getInstance();      
};

