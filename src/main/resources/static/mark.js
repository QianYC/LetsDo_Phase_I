/**
 * 作为为图片做标注的逻辑实现
 */

var rubberSize = 12;
var pencilSize = 2;


function changePencilSize(){
	"use strict";
	document.getElementById("penal").getContext("2d").lineWidth =  document.getElementById("pencilSize").value;
}

function changeRubberSize(){
	"use strict";
	rubberSize = document.getElementById("rubberSize").value;
}

function changePencilColor(){
	"use strict";
	//alert(document.getElementById("pencilColor").value);
	document.getElementById("penal").getContext("2d").strokeStyle = document.getElementById("pencilColor").value;
}

var Mark = function (){
	'use strict';
	this.isDraw = false;//开关
	this.type = "pencil";
	this.penal = document.getElementById("penal");
	this.pen = this.penal.getContext("2d");
	this.color = document.getElementById("color");
	this.lineWidth = document.getElementById("lineWidth");
	this.tools = document.getElementById("tools");
	this.img = new Image();//动态绘制矩形、圆形
};
 
Mark.prototype.init = function(){
	'use strict';
	var self = this;
	this.pen.lineWidth = pencilSize;
	
	this.tools.addEventListener('click', function(event){
		$(".t").css("border-style","hidden");
	    $("#pencilSize").hide();
		$("#rubberSize").hide();
		if(event.target.id === "pencil"){
			self.type = "pencil";
			$("#pencil").css("border-style","inset");
			 $("#pencilSize").show();
		}
		else if(event.target.id === "line"){
			self.type = "line";
			$("#line").css("border-style","inset");
			 $("#pencilSize").show();
		}
		else if(event.target.id === "square"){
			self.type = "square";
			$("#square").css("border-style","inset");
			 $("#pencilSize").show();
		}
		else if(event.target.id === "circle"){
			self.type = "circle";
			$("#circle").css("border-style","inset");
			 $("#pencilSize").show();
		}
		else if(event.target.id === "rubber"){
			self.type = "rubber";
			$("#rubber").css("border-style","inset");
			$("#rubberSize").show();
		}
	}, false);
	
	
	this.penal.addEventListener('mouseleave',function(){//鼠标离开
		if(self.isDraw){
			self.pen.closePath();
			self.isDraw = false; 
		}
	}, false);
	
	this.penal.addEventListener("mouseup", function(event){//松开鼠标
		if(self.isDraw){
			//self.pen.closePath();
			var x = event.pageX - self.penal.offsetLeft;
			var y = event.pageY - self.penal.offsetTop ;
			if(self.type === "line"){//直线
				self.pen.moveTo(self.originX,self.originY);
				self.pen.lineTo(x,y);
				self.pen.stroke();
			}
			else if(self.type === "square"){//矩形
				self.pen.strokeRect(self.originX,self.originY,x-self.originX,y-self.originY);
			}
			else if(self.type === "circle"){//圆形
				self.pen.arc(self.originX,self.originY,Math.sqrt((x-self.originX)*(x-self.originX)+(y-self.originY)*(y-self.originY)),0,2*Math.PI);
				self.pen.stroke();
			}
			self.isDraw = false;
		}
	},false);
	
	this.penal.addEventListener("mousemove",function(event){//鼠标移动
		if(self.isDraw){
			var x = event.pageX - self.penal.offsetLeft;
			var y = event.pageY - self.penal.offsetTop ;
			
			if(self.type === "pencil"){//铅笔
				self.pen.lineTo(x,y);
				self.pen.stroke();
			}
			else if(self.type === "line"){//直线
//				self.pen.moveTo(self.originX,self.originY);
//				self.pen.lineTo(x,y);
//				self.pen.stroke();
				//尝试清除上一次的痕迹
//				for(let tempX = self.originX , tempY = self.originY ; tempX < x && tempY )
			}
			else if(self.type === "square"){//方形
				
			}
			else if(self.type === "circle"){//圆形
				
			}
			else if(self.type === "rubber"){//橡皮
				self.pen.clearRect(x-rubberSize/2,y-rubberSize/2,rubberSize,rubberSize);
			}
			
		}
	}, false);
	
	this.penal.addEventListener("mousedown", function(event){//按下鼠标
		self.isDraw = true;
		self.pen.beginPath();
		self.originX = event.pageX - self.penal.offsetLeft;
		self.originY  = event.pageY - self.penal.offsetTop ;
	},false);
};
