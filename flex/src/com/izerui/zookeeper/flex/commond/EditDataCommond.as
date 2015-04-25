package com.izerui.zookeeper.flex.commond
{
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.business.EditDataDelegate;
import com.izerui.zookeeper.flex.event.EditDataEvent;

import mx.controls.Alert;
import mx.rpc.IResponder;

public class EditDataCommond implements IResponder, ICommand
	{
		
		private var delegate:EditDataDelegate;
		
		private var responseFun:Function;
		
		public function EditDataCommond()
		{
			delegate = new EditDataDelegate(this);
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
			var myEvent:EditDataEvent = EditDataEvent(event);
			responseFun = myEvent.responseFun;
			delegate.setData(myEvent.node);
		}
	}
}