package bs.msg.codec;

/**
 * ˵����
 * ��������ȡ��URI����msgType����ͬJSON��bodyһ���װ��CodecEvent����decode����
 * ServiceHandler��Ҫ���͵����ݣ���װ��CodecEvent����encode����
 * CodecEventManager�ṩ��ͬmsgType�Ĵ������
 */
public class CodecEvent
{
    public CodecEvent(){};
    
    // ���ݣ�msgType��codecType��msgJSON��msgRaw���ṹ����Ϣ����
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