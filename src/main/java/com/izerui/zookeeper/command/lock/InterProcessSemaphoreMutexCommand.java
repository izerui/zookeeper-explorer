package com.izerui.zookeeper.command.lock;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;

/**
 * 不可重入锁
 * Created by serv on 2015/4/26.
 */
public class InterProcessSemaphoreMutexCommand implements Command {

    private String path;
    private InterProcessSemaphoreMutex mutex;

    public InterProcessSemaphoreMutexCommand(String path) {
        this.path = path;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        mutex = new InterProcessSemaphoreMutex(client,path);
    }

    public InterProcessSemaphoreMutex getMutex() {
        return mutex;
    }
}
