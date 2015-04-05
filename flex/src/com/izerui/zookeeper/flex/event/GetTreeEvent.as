package com.izerui.zookeeper.flex.event {
import com.adobe.cairngorm.control.CairngormEvent;

public class GetTreeEvent extends CairngormEvent {

    public var responseFun:Function;

    public function GetTreeEvent(responseFun:Function) {
        super("getTree");

        this.responseFun = responseFun;
    }
}
}