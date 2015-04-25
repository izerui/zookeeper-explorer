package com.izerui.zookeeper.flex.business {
import flash.utils.ByteArray;

import mx.rpc.AsyncToken;
import mx.rpc.IResponder;
import mx.rpc.remoting.RemoteObject;

public class CreatePathDelegate extends BaseDelegate implements IResponder {
    private var responder:IResponder;
    private var service:RemoteObject;

    public function CreatePathDelegate(responder:IResponder) {
        this.responder = responder;
        this.service = getRemoteObject("explorerService");
    }

    public function createPath(path:String,value:ByteArray,mode:String):void {
        var call:AsyncToken = service.createPath(path,value,mode);
        call.addResponder(responder);
    }

    public function result(data:Object):void {
        responder.result(data);
    }

    public function fault(info:Object):void {
        responder.fault(info);
    }
}
}