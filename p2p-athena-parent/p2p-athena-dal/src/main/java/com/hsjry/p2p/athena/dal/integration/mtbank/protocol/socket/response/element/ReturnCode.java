package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.element;

/**
 * Created by wangyf14377 on 2018/5/10.
 */

public class ReturnCode {
        private String Info;
        private String Code;

        public String getInfo() {
            return Info;
        }

        public void setInfo(String info) {
            Info = info;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String code) {
            Code = code;
        }
}
