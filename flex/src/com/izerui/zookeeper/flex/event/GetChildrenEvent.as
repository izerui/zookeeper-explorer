package com.izerui.zookeeper.flex.event {
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.dto.Node;

public class GetChildrenEvent extends CairngormEvent {

    public var parent:Node;
    public var responseFun:Function;

    public function GetChildrenEvent(parent:Node, responseFun:Function) {
        super("getChildren");
        this.parent = parent;

        this.responseFun = responseFun;
    }
}
}