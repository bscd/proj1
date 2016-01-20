package bs.msg.codec;

import bs.GDef;

/**
 * LOGIN��Ϣ�Ĵ�����
 * ��ʵ�������뵥ʵ��ȫ�ֵ�handlerMap��
 */
class MsgHandlerLogout extends MsgHandler
{
    // ��ʵ�������뵥ʵ��ȫ�ֵ�handlerMap��
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