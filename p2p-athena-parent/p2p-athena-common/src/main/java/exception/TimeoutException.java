package exception;

/**
 * Created by wangyf14377 on 2018/5/7.
 */
public class TimeoutException extends BaseException {

    public TimeoutException(String msg, String errorCode, String partnerId) {
        super(msg, errorCode, partnerId);
    }
}
