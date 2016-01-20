package bs.msg.codec;

import bs.GDef;

/**
 * 消息编解码的父类，用于定义消息映射的map
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