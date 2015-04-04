package com.izerui.zookeeper.service;

import com.izerui.zookeeper.support.ZkConfig;
import com.izerui.zookeeper.command.Command;
import com.izerui.zookeeper.command.connect.CloseCommand;
import com.izerui.zookeeper.command.connect.StateCommand;
import com.izerui.zookeeper.command.listener.NodeCacheListenerCommand;
import com.izerui.zookeeper.command.listener.PathChildrenCacheListenerCommand;
import com.izerui.zookeeper.command.path.*;
import com.izerui.zookeeper.support.ZkClientException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serv on 2015/3/10.
 */
@Service
@RemotingDestination
public class ExplorerService implements InitializingBean,DisposableBean {

    private Logger logger = LoggerFactory.getLogger(ExplorerService.class);
    private transient CuratorFramework client;

    @Autowired
    private ZkConfig config;

    protected  <T extends Command> T execute(T command){
        try{
            if(client==null){
                throw new ZkClientException("未建立连接");
            }
            command.command(client);
            return command;
        }catch (Exception e){
            throw new ZkClientException(e);
        }
    }

    public void connect(){
        try {
            ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(config.getBaseSleepTimeMs(), config.getMaxRetries());
            this.client = CuratorFrameworkFactory.newClient(config.getConnectionString(), retryPolicy);
            client.start();
            if(config.isBlockUntilConnectedOrTimedOut()){
                client.getZookeeperClient().blockUntilConnectedOrTimedOut();
            }
            logger.info("连接{}成功", config.getConnectionString());
        } catch (InterruptedException e) {
            throw new ZkClientException("zookeeper服务器连接失败!",e);
        }
    }


    public void close() {
        execute(new CloseCommand());
    }

    public NodeCache nodeListener(String path, NodeCacheListener listener) {
        return execute(new NodeCacheListenerCommand(path,listener)).getCache();
    }

    public PathChildrenCache pathListener(String path, PathChildrenCacheListener listener) {
        return execute(new PathChildrenCacheListenerCommand(path,listener)).getCache();
    }

    public void createPath(String path, byte[] data, CreateMode mode) {
        execute(new CreatePathCommand(path,data,mode));
    }

    public void createPath(String path, byte[] data) {
        execute(new CreatePathCommand(path,data));
    }

    public void createPath(String path,CreateMode mode){
        execute(new CreatePathCommand(path,null,mode));
    }

    public void createPath(String path) {
        execute(new CreatePathCommand(path));
    }

    public void deletePath(String path) {
        execute(new DeletePathCommand(path));
    }

    public List<String> getChildren(String path) {
        return execute(new GetChildrenCommand(path)).getChildren();
    }

    public byte[] getData(String path){
        return execute(new GetDataCommand(path)).getData();
    }

    public Stat setData(String path, byte[] data) {
        return execute(new SetDataCommand(path,data)).getStat();
    }

    public CuratorFrameworkState getState() {
        return execute(new StateCommand()).getState();
    }

    @Override
    public void destroy() throws Exception {
        close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
    }
}
