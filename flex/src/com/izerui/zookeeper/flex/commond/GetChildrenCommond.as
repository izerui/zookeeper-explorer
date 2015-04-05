package com.izerui.zookeeper.flex.commond
{
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.business.GetChildrenDelegate;
import com.izerui.zookeeper.flex.event.GetChildrenEvent;

import mx.controls.Alert;
import mx.rpc.IResponder;

public class GetChildrenCommond implements IResponder, ICommand
	{
		
		private var delegate:GetChildrenDelegate;
		
		private var responseFun:Function;
		
		public function GetChildrenCommond()
		{
			delegate = new GetChildrenDelegate(this);
		}
		
		public function result(data:Object):void
		{
			if(responseFun){
				responseFun.call(null,data.result);
			}
		}
		
		public function fault(info:Object):void
		{
			Alert.show("连接异常!","提示");
		}
		
		public function execute(event:CairngormEvent):void
		{
			var myEvent:GetChildrenEvent = GetChildrenEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getChildren(myEvent.parent);
		}
	}
}