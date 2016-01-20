package bs.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

final class HttpChannelInitializer extends ChannelInitializer<SocketChannel>{
	
	protected void initChannel(SocketChannel sockChn) throws Exception {
		ChannelPipeline pipeline = sockChn.pipeline();
		pipeline.addLast(new HttpResponseEncoder());
		pipeline.addLast(new HttpRequestDecoder());
		pipeline.addLast(new HttpContentCompressor());
		pipeline.addLast(new HttpServerHandler());
	}
}