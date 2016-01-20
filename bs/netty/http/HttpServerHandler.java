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

        // 解析请求http headers
        if (msg instanceof HttpRequest)
        {
            request = (HttpRequest) msg;
            
            System.out.println("http rcv a [" + request.getMethod() + "] request.");
            
            // 忽略浏览器的favicon.ico请求(如果有的话)
            if (request.getUri().equals("/favicon.ico"))
                return;
            // 上传文件
            if (request.getMethod().equals(POST))
            {
                HttpResponse.sendHttpRsp(ctx, OK, HttpResponse.generalSuccessRsp);
            }
            // 下载文件
            else if (request.getMethod().equals(GET))
            {
                HttpResponse.sendHttpRsp(ctx, OK, HttpResponse.invalidMethodRsp);
            }
            // 更新文件
            else if (request.getMethod().equals(PUT))
            {
            }
            // 删除文件
            else if (request.getMethod().equals(DELETE))
            {
            }
            // 其他HTTP Method一律拒绝
            else
            {
                HttpResponse.sendHttpRsp(ctx, FORBIDDEN, HttpResponse.invalidMethodRsp);
                return;
            }
        }
        // 解析请求http body
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