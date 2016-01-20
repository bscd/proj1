package bs.msg.codec;

/**
 * 说明：
 * 从网络层获取到URI生成msgType，连同JSON的body一起封装进CodecEvent进行decode处理
 * ServiceHandler将要发送的内容，封装到CodecEvent进行encode处理
 * CodecEventManager提供不同msgType的处理对象
 */
public class CodecEvent
{
    public CodecEvent(){};
    
    // 数据：msgType，codecType，msgJSON，msgRaw（结构化消息对象）
    private String msgType = "";
    private String msgJSON = "";
    private boolean isEncode;
    private Object msgRaw;
    
    public String getMsgType()
    {
        return msgType;
    }
    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }
    public String getMsgJSON()
    {
        return msgJSON;
    }
    public void setMsgJSON(String msgJSON)
    {
        this.msgJSON = msgJSON;
    }
    public boolean isEncode()
    {
        return isEncode;
    }
    public void setEncode(boolean isEncode)
    {
        this.isEncode = isEncode;
    }
    public Object getMsgRaw()
    {
        return msgRaw;
    }
    public void setMsgRaw(Object msgRaw)
    {
        this.msgRaw = msgRaw;
    }
    

}