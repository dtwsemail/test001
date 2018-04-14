package com.hsjry.p2p.athena.dal.integration.common.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class HsSocketClient extends HsSocketClientImpl {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger (HsSocketClient.class);

	public HsSocketClient () {
		super ();
	}

	public void init() throws Exception {
		if(0==this.connectTimeout){
			this.connectTimeout = 60;
		}
		if(0==this.soTimeout){
			this.soTimeout = 60;
		}
		this.packLength = 256;
		this.isSyn = false;
		this.isCheck = false;

		synBuf[0] = 0x02;
		synBuf[1] = 0x00;
		synBuf[2] = 0x00;
		LOGGER.info ("ip|" + address + "|port|" + port + "|packLength|" + packLength);
	}

	public void send(byte[] bt) throws Exception {
		try {
			if (!client.isConnected ()) {
				throw new Exception ("socket connection is disabled!");
			}
			OutputStream out = client.getOutputStream ();
			DataOutputStream dout = new DataOutputStream (out);
			int i = 0;
			while (true) {
				int leftLen = bt.length - i * packLength;
				int currLen = leftLen > packLength ? packLength : leftLen;
				if (leftLen <= 0) {
					break;
				}
				if (isSyn) {
					dout.write (synBuf, 0, synBufLen);
				}

				byte[] pkgBody = new byte[currLen];
				System.arraycopy (bt, i * packLength, pkgBody, 0, currLen);
				LOGGER.info (new String (pkgBody));
				dout.write (pkgBody);
				i++;
			}
			dout.flush ();
			LOGGER.info ("length:" + bt.length);
		} catch(Exception e){
			LOGGER.error ("SOCKET 通讯超时：{}", e);
			throw e;
//			throw new SanxiaPayBizException (EnumPortalRespMsg.COMM_TIMEOUT.getCode(), EnumPortalRespMsg.COMM_TIMEOUT.getDescription());
		}
	}

	public byte[] recv() throws Exception {
		byte[] bt = null;
		DataInputStream din = null;

		try {
			if (!client.isConnected ()) {
				throw new Exception ("socket connection is disabled!");
			}
			InputStream in = client.getInputStream ();

			din = new DataInputStream (in);
			int entPkgLen = 0;

			byte[] headByte = new byte[57];
			din.readFully (headByte);
			/** 包长*/
			entPkgLen = new Integer (new String (headByte).substring (4, 9));

			bt = new byte[entPkgLen];
			din.readFully (bt);
			din.close ();
		}
		catch(Exception e){
            LOGGER.error ("SOCKET 通讯超时：{}", e);
			throw e;
//            throw new SanxiaPayBizException (EnumPortalRespMsg.COMM_TIMEOUT.getCode(), EnumPortalRespMsg.COMM_TIMEOUT.getDescription());
        }
		return bt;
	}

	@Override
	public byte[] recvHeader() throws Exception {
		byte[] headByte = new byte[57];
		DataInputStream din = null;

		try {
			if (!client.isConnected ()) {
				throw new Exception ("socket connection is disabled!");
			}
			InputStream in = client.getInputStream ();

			din = new DataInputStream (in);

			din.readFully (headByte);
			
		}
		catch(Exception e){
            LOGGER.error ("SOCKET 通讯超时：{}", e);
			throw  e;
//            throw new SanxiaPayBizException (EnumPortalRespMsg.COMM_TIMEOUT.getCode(), EnumPortalRespMsg.COMM_TIMEOUT.getDescription());
        }
		return headByte;
	}
	@Override
	public byte[] recvHeaderofBOS() throws Exception {
		byte[] headByte = new byte[41];
		DataInputStream din = null;

		try {
			if (!client.isConnected ()) {
				throw new Exception ("socket connection is disabled!");
			}
			InputStream in = client.getInputStream ();

			din = new DataInputStream (in);

			din.readFully (headByte);
			
		}
		catch(Exception e){
            LOGGER.error ("SOCKET 通讯超时：{}", e);
			throw e;
//            throw new SanxiaPayBizException (EnumPortalRespMsg.COMM_TIMEOUT.getCode(), EnumPortalRespMsg.COMM_TIMEOUT.getDescription());
        }
		return headByte;
	}
	@Override
	public byte[] recvBody(int bodyLen) throws Exception {
		byte[] bt =  new byte[bodyLen];
		DataInputStream din = null;

		try {
			if (!client.isConnected ()) {
				throw new Exception ("socket connection is disabled!");
			}
			InputStream in = client.getInputStream ();

			din = new DataInputStream (in);
			din.readFully (bt);
			din.close ();
		}
		catch(Exception e){
            LOGGER.error ("SOCKET 通讯超时：{}", e);
			throw e;
//            throw new SanxiaPayBizException (EnumPortalRespMsg.COMM_TIMEOUT.getCode(), EnumPortalRespMsg.COMM_TIMEOUT.getDescription());
        }finally{
			this.close();
		}
		return bt;
	}

}
