package bs.msg.codec;

import java.util.HashMap;

import bs.GDef;

/**
 * CodecEventManager主要提供msgType与处理对象之间的映射
 * 包括初始化映射关系，以及根据类型调用处理函数
 */
public class CodecEventManager
{
    // 单实例
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
    
    // 由于是单实例，如下方法和变量其实都只有一份
    private HashMap<String, MsgHandler> handlerMap = new HashMap<String, MsgHandler>();
    
    public void init()
    {
        handlerMap.put(GDef.MSG_TYPE_LOGIN, MsgHandlerLogin.getInstance());
        handlerMap.put(GDef.MSG_TYPE_LOGOUT, MsgHandlerLogout.getInstance());
        // TODO: 添加其他的消息处理映射
    }
    
    public int proc(CodecEvent event)
    {
        MsgHandler msgHandler = handlerMap.get(event.getMsgType());
        msgHandler.codec(event);
        
        return GDef.RET_OK;
    }
}