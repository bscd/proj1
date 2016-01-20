package bs.msg.codec;

import bs.GDef;

/**
 * LOGIN消息的处理类
 * 单实例，存入单实例全局的handlerMap里
 */
class MsgHandlerLogout extends MsgHandler
{
    // 单实例，存入单实例全局的handlerMap里
    private static MsgHandlerLogout instance;
    private MsgHandlerLogout(){};
    public static MsgHandlerLogout getInstance()
    {
        if (null == instance)
        {
            instance = new MsgHandlerLogout();
        }
        return instance;
    }

    protected int decode(CodecEvent event)
    {
        // TODO
        System.out.println("decode Logout msg. JSON=" + event.getMsgJSON());
        return GDef.RET_OK;
    };
    protected int encode(CodecEvent event)
    {
        // TODO
        System.out.println("encode Logout msg. JSON=" + event.getMsgJSON());
        return GDef.RET_OK;
    };
    
}