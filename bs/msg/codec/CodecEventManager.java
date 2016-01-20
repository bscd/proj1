package bs.msg.codec;

import java.util.HashMap;

import bs.GDef;

/**
 * CodecEventManager��Ҫ�ṩmsgType�봦�����֮���ӳ��
 * ������ʼ��ӳ���ϵ���Լ��������͵��ô�����
 */
public class CodecEventManager
{
    // ��ʵ��
    private static CodecEventManager instance;
    private CodecEventManager(){};
    public static CodecEventManager getInstance()
    {
        if (null == instance)
        {
            instance = new CodecEventManager();
        }
        return instance;
    };
    
    // �����ǵ�ʵ�������·����ͱ�����ʵ��ֻ��һ��
    private HashMap<String, MsgHandler> handlerMap = new HashMap<String, MsgHandler>();
    
    public void init()
    {
        handlerMap.put(GDef.MSG_TYPE_LOGIN, MsgHandlerLogin.getInstance());
        handlerMap.put(GDef.MSG_TYPE_LOGOUT, MsgHandlerLogout.getInstance());
        // TODO: �����������Ϣ����ӳ��
    }
    
    public int proc(CodecEvent event)
    {
        MsgHandler msgHandler = handlerMap.get(event.getMsgType());
        msgHandler.codec(event);
        
        return GDef.RET_OK;
    }
}