		var flag = true;
		window.onload = function(){
			var b1 = document.getElementById("button");
			var curTime = new Date();
			var currentTime = document.getElementById("currentTime");
			cTime();
			b1.onclick = function(){
				flag = false;
				var form = document.getElementById("form");
				var setMission = document.getElementById("setMission").value;
				var setHour = parseInt(document.getElementById("setHour").value);
				var setMin = parseInt(document.getElementById("setMin").value);
				var setSec = parseInt(document.getElementById("setSec").value);
				var hour_txt = document.getElementById("hour_txt");
				var min_txt = document.getElementById("min_txt");
				var sec_txt = document.getElementById("sec_txt");
				setHour = setHour > 0 ? setHour : 0;
				setMin = setMin > 0 ? setMin : 0;
				setSec = setSec > 0 ? setSec : 0;
				form.remove()
				hour_txt.innerHTML = "小时";
				min_txt.innerHTML = "分钟";
				sec_txt.innerHTML = "秒";
				mission_ele.innerHTML = setMission;
				// 设置变量（不同的时间传入方式）
				target_time= new Date();
				// 获取目标时间与当前时间差对象
				target_time.setHours(target_time.getHours() + setHour);
				target_time.setMinutes(target_time.getMinutes() + setMin);
				target_time.setSeconds(target_time.getSeconds() + setSec);
				// 实现倒计时效果
				renderCountDown()
				
			}
		}
		var target_time;
		// 计算目标时间对象到当前时间的毫秒数
		var hour_ele = document.getElementById("hour");
		var min_ele = document.getElementById("min");
		var sec_ele = document.getElementById("sec");
		var mission_ele = document.getElementById("mission");
		// 返回需要的数据
		function countDown(){
			var reduce_ms = target_time.getTime() - Date.now(); 

			return {
				reduce_ms,
				hour : parseInt(reduce_ms / 1000 / 3600 % 24),
				min  : parseInt(reduce_ms / 1000 / 60 % 60 ),
				sec  : Math.round(reduce_ms / 1000 % 60)
			}
		}
		// 将数据渲染到页面指定节点中
		function renderCountDown(){
		    var res = countDown();
		    hour_ele.innerHTML = addZero(res.hour);
		    min_ele.innerHTML  = addZero(res.min);
		    sec_ele.innerHTML  = addZero(res.sec);
			if(res.reduce_ms > 0){
				setTimeout(renderCountDown,1000);
			}else{
				hour_ele.innerHTML = addZero(0);
				min_ele.innerHTML  = addZero(0);
				sec_ele.innerHTML  = addZero(0);
				alert("What everyone you can do,just do it.");
			}
			
		}
		
		// 封装函数，当数值小于10时在前面加“0”
		function addZero( num ){
		    if(num < 10){
		        return "0" + num;
		    }
		    return num;
		}
		
		function cTime(){
			curTime = new Date();
			if(flag){
				currentTime.innerHTML = curTime.toDateString()+"&nbsp"+addZero(curTime.getHours())+":"+ addZero(curTime.getMinutes())+":"+ addZero(curTime.getSeconds());;
				setTimeout(cTime,1000);
			}
		}
		