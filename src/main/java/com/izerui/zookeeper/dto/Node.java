package com.izerui.zookeeper.dto;

import com.izerui.zookeeper.support.ZkClientException;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by serv on 2015/4/4.
 */
public class Node implements Serializable {

    /**
     * 节点名称
     */
    private String name;
    /**
     * 节点data value
     */
    private byte[] data;
    /**
     * 父节点
     */
    private Node parent;
    /**
     * 子节点列表
     */
    private List<Node> children;

    /**
     * 是否有子节点
     */
    private boolean hasChildren;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
        if(hasChildren&&children==null){
            children = new ArrayList<Node>();
        }
    }

    public String getFullPath(){
        if(name==null||name.equals("")){
            throw new ZkClientException("节点path不能为空");
        }
        if(name.equals("/")){
            return name;
        }
        List<String> pathArray = new ArrayList<String>();
        appendParentPath(pathArray,this);
        Collections.reverse(pathArray);
        return StringUtils.join(pathArray,"/").replaceFirst("/","");
    }

    private void appendParentPath(List<String> pathArray,Node node){
        pathArray.add(node.getName());
        if(node.getParent()!=null){
            appendParentPath(pathArray,node.getParent());
        }
    }

    @Override
    public String toString() {
        return getFullPath();
    }
}
