package com.izerui.zookeeper.flex.event {
import com.adobe.cairngorm.control.CairngormEvent;

import flash.utils.ByteArray;

public class CreatePathEvent extends CairngormEvent {

    public var path:String;
    //PERSISTENT PERSISTENT_SEQUENTIAL EPHEMERAL EPHEMERAL_SEQUENTIAL
    public var mode:String;
    public var value:ByteArray;

    public var responseFun:Function;

    public function CreatePathEvent(path:String,value:ByteArray,mode:String,responseFun:Function) {
        super("createPath");
        this.path = path;
        this.mode = mode;
        this.value = value;
        this.responseFun = responseFun;
    }
}
}