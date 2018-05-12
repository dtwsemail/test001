package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.element.MessageHeader;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.element.ReturnCode;

/**
 * Created by wangyf14377 on 2018/5/10.
 */
public class MTBaseRes {
    private ReturnCode Rst; //返回状态码

    private MessageHeader MsgHdr; //消息头

    public MessageHeader getMsgHdr() {
        return MsgHdr;
    }

    public void setMsgHdr(MessageHeader msgHdr) {
        MsgHdr = msgHdr;
    }

    public ReturnCode getRst() {
        return Rst;
    }

    public void setRst(ReturnCode rst) {
        Rst = rst;
    }
}
