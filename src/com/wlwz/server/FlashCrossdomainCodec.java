package com.wlwz.server;

import java.sql.Timestamp;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.SynchronizedProtocolDecoder;
import org.apache.mina.filter.codec.SynchronizedProtocolEncoder;

public class FlashCrossdomainCodec implements ProtocolCodecFactory {
	static int count3 = 0;

	class FlashCrossdomainDecoder extends ProtocolDecoderAdapter {
		// private Charset charset = Charset.forName("UTF-8");
		// IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);
                
		// IoBuffer是对ByteBuffer的封装，提供对字符串的支持，可变长度，都是线程不安全
		public void decode(IoSession session, IoBuffer in,
				ProtocolDecoderOutput out) throws Exception {
			// 超时数据丢包处理
			// ReadFuture future = session.read();
			// IoBuffer receiveBuffer = null;
			// if(future.awaitUninterruptibly(15, TimeUnit.MILLISECONDS)){
			// receiveBuffer = (IoBuffer) future.getMessage();
			// }
			FlashCrossdomainCodec.count3++;
			Timestamp now2 = new Timestamp(System.currentTimeMillis());
			System.out.println("--------------收到石油监控数据--------"
					+ FlashCrossdomainCodec.count3 + "---------"
					+ now2.toString() + "-------------------");
			try {
				// in.hasRemaining()返回布尔型，判断数据是否接受完；in.remaining()为数据长度
				// hasRemaining判断的是(position<limit),remaining返回的是(limit-position)
				if (in.hasRemaining()) {
					byte[] data = new byte[in.remaining()];
					in.get(data); // data已经获取接收数组的数据内容

					int[] data1 = new int[data.length];
					String data_string = "";
					for (int i = 0; i < data.length; i++) {
						String data_hex;
						if (data[i] < 0) {
							data1[i] = data[i] + 256;
							data_hex = Integer.toHexString(data1[i]);
							while (data_hex.length() < 2) {
								data_hex = "0" + data_hex;
							}
							data_string += data_hex;
						} else {
							data1[i] = data[i];
							data_hex = Integer.toHexString(data1[i]);
							while (data_hex.length() < 2) {
								data_hex = "0" + data_hex;
							}
							data_string += data_hex;
						}
					}
					String msg = new String(data_string);
					// String msg = new String(data);
					out.write(msg);
				}
				// while(in.hasRemaining()){
				// byte b = in.get();
				// buf.put(b);
				// if (b == '\n') {
				// buf.flip();
				// byte[] msg = new byte[buf.limit()];
				// buf.get(msg);
				// String message = new String(msg, charset);
				// //解码成功，把buf重置
				// buf = IoBuffer.allocate(100).setAutoExpand(true);
				// out.write(message);
				// }
				// }
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class FlashCrossdomainEncoder extends ProtocolEncoderAdapter {
		public void encode(IoSession session, Object message,
				ProtocolEncoderOutput out) throws Exception {
			try {
				System.out.println(message.toString());
			//zxy 	out.write(IoBuffer.wrap((byte[]) message));
				out.write(IoBuffer.wrap(message.toString().getBytes("UTF-16")));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private ProtocolEncoder encoder = new SynchronizedProtocolEncoder(
			new FlashCrossdomainEncoder());
	private ProtocolDecoder decoder = new SynchronizedProtocolDecoder(
			new FlashCrossdomainDecoder());

	public FlashCrossdomainCodec() {
	}

	public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
		return encoder;
	}

	public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
		return decoder;
	}

	public ProtocolDecoder getDecoder() throws Exception {
		return decoder;
	}

	public ProtocolEncoder getEncoder() throws Exception {
		return encoder;
	}

}
