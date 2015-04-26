package com.izerui.zookeeper.command.lock;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;

/**
 * 读写锁
 * Created by serv on 2015/4/26.
 */
public class InterProcessReadWriteLockCommand implements Command {

    private String path;
    private byte[] data;
    private boolean lockData;

    private InterProcessReadWriteLock lock;

    public InterProcessReadWriteLockCommand(String path) {
        this.path = path;
        this.lockData = false;
    }

    public InterProcessReadWriteLockCommand(String path, byte[] data) {
        this.path = path;
        this.data = data;
        this.lockData = true;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        if(lockData){
            lock = new InterProcessReadWriteLock(client,path,data);
        }else{
            lock = new InterProcessReadWriteLock(client,path);
        }
    }

    public InterProcessReadWriteLock getLock() {
        return lock;
    }
}
