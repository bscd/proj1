package bs.netty.http;

import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpMethod.*;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;

final class HttpServerHandler extends ChannelInboundHandlerAdapter
{
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {

        HttpRequest request = null;
        HttpContent content = null;

        // ��������http headers
        if (msg instanceof HttpRequest)
        {
            request = (HttpRequest) msg;
            
            System.out.println("http rcv a [" + request.getMethod() + "] request.");
            
            // �����������favicon.ico����(����еĻ�)
            if (request.getUri().equals("/favicon.ico"))
                return;
            // �ϴ��ļ�
            if (request.getMethod().equals(POST))
            {
                HttpResponse.sendHttpRsp(ctx, OK, HttpResponse.generalSuccessRsp);
            }
            // �����ļ�
            else if (request.getMethod().equals(GET))
            {
                HttpResponse.sendHttpRsp(ctx, OK, HttpResponse.invalidMethodRsp);
            }
            // �����ļ�
            else if (request.getMethod().equals(PUT))
            {
            }
            // ɾ���ļ�
            else if (request.getMethod().equals(DELETE))
            {
            }
            // ����HTTP Methodһ�ɾܾ�
            else
            {
                HttpResponse.sendHttpRsp(ctx, FORBIDDEN, HttpResponse.invalidMethodRsp);
                return;
            }
        }
        // ��������http body
        if (msg instanceof HttpContent)
        {
            content = (HttpContent) msg;
            ByteBuf buf = content.content();
            System.out.println("http rcv message body:" + buf.toString(io.netty.util.CharsetUtil.UTF_8));
            buf.release();
        }
    }

    public void channelReadComplete(ChannelHandlerContext ctx)
    {
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
    {
        System.out.println("ERR: http server handler get exception: " + cause);
    }
}