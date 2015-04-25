package com.izerui.zookeeper.flex.dto {
import com.adobe.cairngorm.vo.IValueObject;

import flash.utils.ByteArray;

import mx.collections.ArrayCollection;

[Bindable]
[RemoteClass(alias="com.izerui.zookeeper.dto.Node")]
public class Node implements IValueObject {
    /**
     * 节点名称
     */
    public var name:String;
    /**
     * 节点data value
     */
    public var data:ByteArray;
    /**
     * 父节点
     */
    public var parent:Node;
    /**
     * 子节点列表
     */
    public var children:ArrayCollection;

    /**
     * 是否有子节点
     */
    public var hasChildren:Boolean;

    /**
     * 全路径
     */
    public function get fullPath():String{
        if(name == "/"){
            return name;
        }
        var pathArray = new Array();
        appendParentPath(pathArray,this);
        pathArray = pathArray.reverse();
        var fullPath:String = pathArray.join("/");
        return fullPath.substring(1,fullPath.length);

    }

    private function appendParentPath(pathArray:Array,node:Node):void{
        pathArray.push(node.name);
        if(node.parent){
            appendParentPath(pathArray,node.parent);
        }
    }

}
}