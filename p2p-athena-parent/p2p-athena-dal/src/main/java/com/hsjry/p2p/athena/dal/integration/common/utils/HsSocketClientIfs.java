package com.hsjry.p2p.athena.dal.integration.common.utils;

import java.net.Socket;

public interface HsSocketClientIfs {
	public void init(String address, int port, int timeOut);

	public void setNoDelay(boolean no) throws Exception;

	public void setConnectTimeout(int timeout);

	public void setSoTimeout(int timeout);

	public void connect() throws Exception;

	public void close() throws Exception;

	public void send(byte[] bt) throws Exception;

	public byte[] recv() throws Exception;

	public boolean isClosed() throws Exception;

	public Socket getSocket() throws Exception;
	
	/**
	 * 接收返回通讯报文头
	 * @return
	 * @throws Exception
	 */
	public byte[] recvHeader() throws Exception;
	
	/**
	 * 接收返回XML数据报文
	 * @param bodyLen xml报文长度
	 * @return
	 * @throws Exception
	 */
	public byte[] recvBody(int bodyLen) throws Exception;

	byte[] recvHeaderofBOS() throws Exception;

}
