package com.hsjry.p2p.athena.facade.callback;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyf14377 on 2018/4/8.
 */
@Controller
@RequestMapping("/callback/mtBank")
public class MTCallbackController {

    @RequestMapping("/doRequest")
    public String doRequest(HttpRequest request){

        return null;
    }
}
