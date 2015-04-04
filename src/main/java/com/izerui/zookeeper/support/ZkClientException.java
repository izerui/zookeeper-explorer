package com.izerui.zookeeper.support;

/**
 * Created by serv on 2015/3/9.
 */
public class ZkClientException extends RuntimeException {
    public ZkClientException() {
        super();
    }

    public ZkClientException(String message) {
        super(message);
    }

    public ZkClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZkClientException(Throwable cause) {
        super(cause);
    }
}
