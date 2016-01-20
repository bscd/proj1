package bs.msg.codec;

import bs.GDef;

/**
 * LOGIN消息的处理类
 * 单实例，存入单实例全局的handlerMap里
 */
class MsgHandlerLogin extends MsgHandler
{
    // 单实例，存入单实例全局的handlerMap里
    private static MsgHandlerLogin instance;
    private MsgHandlerLogin(){};
    public static MsgHandlerLogin getInstance()
    {
        if (null == instance)
        {
            instance = new MsgHandlerLogin();
        }
        return instance;
    }

    protected int decode(CodecEvent event)
    {
        // TODO
        System.out.println("decode Login msg. JSON=" + event.getMsgJSON());
        return GDef.RET_OK;
    };
    protected int encode(CodecEvent event)
    {
        // TODO
        System.out.println("encode Login msg. JSON=" + event.getMsgJSON());
        return GDef.RET_OK;
    };
    
}