package com.izerui.zookeeper.flex.event {
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.dto.Node;

public class DeletePathEvent extends CairngormEvent {

    public var node:Node;
    public var responseFun:Function;

    public function DeletePathEvent(node:Node, responseFun:Function) {
        super("deletePath");
        this.node = node;

        this.responseFun = responseFun;
    }
}
}