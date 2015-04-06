package com.izerui.zookeeper.flex.commond
{
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.business.CreatePathDelegate;
import com.izerui.zookeeper.flex.event.CreatePathEvent;

import mx.controls.Alert;
import mx.rpc.IResponder;

public class CreatePathCommond implements IResponder, ICommand
	{
		
		private var delegate:CreatePathDelegate;
		
		private var responseFun:Function;
		
		public function CreatePathCommond()
		{
			delegate = new CreatePathDelegate(this);
		}
		
		public function result(data:Object):void
		{
			if(responseFun){
				responseFun.call(null,data.result);
			}
		}
		
		public function fault(info:Object):void
		{
			Alert.show(info.toString(),"error");
		}
		
		public function execute(event:CairngormEvent):void
		{
			var myEvent:CreatePathEvent = CreatePathEvent(event);
			responseFun = myEvent.responseFun;
			delegate.createPath(myEvent.path,myEvent.value,myEvent.mode);
		}
	}
}