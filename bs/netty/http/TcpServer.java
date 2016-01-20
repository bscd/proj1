package bs.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TcpServer
{
    protected TcpServer()
    {
    }

    protected static void start(int bossGroupNum, int workGroupNum, String ip, int port,
            ChannelInitializer<SocketChannel> chnInit)
    {
        EventLoopGroup bossGroup = new NioEventLoopGroup(bossGroupNum);
        EventLoopGroup workerGroup = new NioEventLoopGroup(workGroupNum);
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup);
        b.channel(NioServerSocketChannel.class);
        b.childHandler(chnInit);
        b.option(ChannelOption.SO_BACKLOG, 1024);
        try
        {
            System.out.println("http start listening at "+ ip +":" + port);
            b.bind(ip, port).channel().closeFuture().sync();
        } catch (Exception e)
        {
            System.out.println("ERR: can not init tcp/http server: " + e);
            System.exit(1);
        } finally
        {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}