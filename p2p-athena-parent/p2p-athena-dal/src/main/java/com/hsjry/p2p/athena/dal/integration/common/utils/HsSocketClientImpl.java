package com.hsjry.p2p.athena.dal.integration.common.utils;

import java.net.InetSocketAddress;
import java.net.Socket;

public abstract class HsSocketClientImpl implements HsSocketClientIfs {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger

	(HsSocketClientImpl.class);
	protected Socket client = null;

	protected String address;

	protected int port;

	protected int connectTimeout;

	protected int soTimeout;

	protected byte synBuf[] = new byte[8];

	protected int synBufLen = 3;

	protected int packLength = 0;

	protected boolean isNoDelay = false;

	protected boolean isSyn = false;

	protected boolean isCheck = false;

	protected String logid = "";

	public HsSocketClientImpl () {
	}

	public void init(String address, int port, int connectTimeout) {
		this.address = address;
		this.port = port;
		this.connectTimeout = connectTimeout;
		synBuf[0] = 0x02;
		synBuf[1] = 0x00;
		synBuf[2] = 0x00;
	}

	public void setNoDelay(boolean no) throws Exception {
		this.isNoDelay = no;
	}

	public void setConnectTimeout(int timeout) {
		this.connectTimeout = timeout;
	}

	public void setSoTimeout(int timeout) {
		this.soTimeout = timeout;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public Socket getSocket() {
		return client;
	}

	public void setSynBuf(byte[] syn) {
		synBuf = syn;
	}

	public void setIsSyn(boolean n) {
		this.isSyn = n;
	}

	public void setSynLength(int length) {
		this.synBufLen = length;
	}

	public void connect() throws Exception {
		client = new Socket ();
		try {
			InetSocketAddress inetAddress = new InetSocketAddress (address,

			port);
			// client.setPerformancePreferences(1,0,0);
			client.connect (inetAddress, connectTimeout * 1000);
			client.setKeepAlive (true);
			if (this.isNoDelay) {
				client.setTcpNoDelay (true);
			}
			client.setSoTimeout (soTimeout * 1000);
			LOGGER.info ("address：{}", address);
		}
		catch (Exception e) {
			throw new Exception (e.getMessage ());
		}
	}

	public void close() throws Exception {
		try {
			if (client != null) {
				client.close ();
				client = null;
			}
		}
		catch (Exception e) {
			throw new Exception (e.getMessage ());
		}
	}

	public abstract void send(byte[] bt) throws Exception;

	public abstract byte[] recv() throws Exception;

	public boolean isClosed() throws Exception {
		return client != null ? client.isClosed () : true;
	}

	public void debug(String message) {
		// Log.getInstance().debug(logid, message);
	}

	public void info(String message) {
		// Log.getInstance().info(logid, message);
	}

	public void error(String message, Throwable e) {
		// Log.getInstance().error(logid, message, e);
	}

	public void fatal(String message, Throwable e) {
		// Log.getInstance().fatal(logid, message, e);
	}

	public void flushLog() {
		// Log.getInstance().flush(logid);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
