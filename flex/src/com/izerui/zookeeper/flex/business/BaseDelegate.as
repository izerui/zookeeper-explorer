/**
 * Created by Administrator on 2015/4/6.
 */
package com.izerui.zookeeper.flex.business {
import com.adobe.cairngorm.business.ServiceLocator;

import mx.core.FlexGlobals;
import mx.rpc.remoting.RemoteObject;

public class BaseDelegate {
    public function BaseDelegate() {
    }

    public function getRemoteObject(destination:String):RemoteObject{
        var remoteService:RemoteObject = ServiceLocator.getInstance().getRemoteObject(destination);
        remoteService.endpoint = FlexGlobals.topLevelApplication.endpoint;
        return remoteService;
    }
}
}
