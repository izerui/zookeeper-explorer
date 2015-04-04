package com.izerui.zookeeper.support;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * Created by serv on 2015/3/11.
 */
@ConfigurationProperties(prefix = "zookeeper")
public class ZkConfig implements Serializable {

    private String connectionString;
    private int baseSleepTimeMs = 1000;
    private int maxRetries = Integer.MAX_VALUE;
    private boolean blockUntilConnectedOrTimedOut = true;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public int getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(int baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public boolean isBlockUntilConnectedOrTimedOut() {
        return blockUntilConnectedOrTimedOut;
    }

    public void setBlockUntilConnectedOrTimedOut(boolean blockUntilConnectedOrTimedOut) {
        this.blockUntilConnectedOrTimedOut = blockUntilConnectedOrTimedOut;
    }
}
