package bs.msg.codec;

import bs.GDef;

/**
 * LOGIN��Ϣ�Ĵ�����
 * ��ʵ�������뵥ʵ��ȫ�ֵ�handlerMap��
 */
class MsgHandlerLogin extends MsgHandler
{
    // ��ʵ�������뵥ʵ��ȫ�ֵ�handlerMap��
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