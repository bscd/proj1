package bs.msg.codec;

import bs.GDef;

/**
 * ��Ϣ�����ĸ��࣬���ڶ�����Ϣӳ���map
 */
public abstract class MsgHandler
{
    abstract protected int encode(CodecEvent event);
    abstract protected int decode(CodecEvent event);
    
    public int codec(CodecEvent event)
    {
        if (false == event.isEncode())
            return decode(event);
        else
            return encode(event);
    }
}