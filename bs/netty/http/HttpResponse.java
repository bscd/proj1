package bs.netty.http;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import bs.GDef;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.HttpResponseStatus;

public class HttpResponse
{
    public static final String generalSuccessRsp = "{\"resultCode\":\"0\"}";
    public static final String invalidMethodRsp = "{\"resultCode\":" + GDef.RESULT_INVALIDMETHOD
            + ", \"description\":\"invalid http method\"}";

    private HttpResponse()
    {
    }

    public static void sendHttpRsp(ChannelHandlerContext ctx, HttpResponseStatus status, String msg) throws Exception
    {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, status,
                Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
        response.headers().set(CONTENT_TYPE, "application/json");
        response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
        response.headers().set(CONNECTION, Values.CLOSE);
        ctx.write(response);
        ctx.flush();
    }
}