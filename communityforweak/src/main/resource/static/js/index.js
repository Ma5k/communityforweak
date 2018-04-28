//tab选项卡
 function tab(){
//获取鼠标滑过或点击的标签和要切换内容的元素
	var titles = $('.clay').children();
//	遍历titles下的所有li
	console.log(titles);
	for(var i = 0; i<titles.length;i++){
		titles[i].id = i;
		console.log(titles[i]);
		
		titles[i].onmouseover = function(){
			for(var j = 0; j < titles.length; j++){
			titles[j].className ='';
			}
			this.className = 'select';
			
		}
	}
}
tab();



function requestdata(){
  		$.ajax({
            type:"POST",
            url:"js/data.json",
            dataType:"json",
            data:{query:'data'},
            success:function(data){
             var dates = data.items;
             console.log(dates.length);
		      for(var start = 0;start< dates.length;start++){
			      var item = dates[start];
			    $("#sort-text").append(
			    "<div class='text'>"+"<span>" + item.title + "</span>" + 
			    
			    "<div class='text1'>" + "<span>" + item.text + "</span>"  + "</div>" + 
			    
			    "<div class='apply'>"+ "<input type='button' value='申请' />"+"<input type='button' value='收藏' />"+"</div>" +
			    "</div>");
		       }
           }

  		});
  	}
  	requestdata();

//分页
var totalpage,pagesize,cpage,count,curcount,outstr; 
//初始化 
cpage = 1; //当前页（设置为全局变量）
totalpage = 56; //总页数
pagesize = 10;  //每页显示的数据数量
outstr = "";  //显示分页效果

function gotopage(target) 
{   
    cpage = target;        //把页面计数定位到第几页 
    
    //这里写页面跳转时要调用的方法
    var state = $("#state").find("option:selected").val();
    getData(state,cpage ); 
    
    //setpage(); 
    //reloadpage(target); //调用显示页面函数显示第几页,这个功能是用在页面内容用ajax载入的情况
}
 
function setpage() 
{ 
    if(totalpage<=10){        //总页数小于十页 
        for (count=1;count<=totalpage;count++) 
        {    if(count!=cpage) 
            { 
                outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
            }else{ 
                outstr = outstr + "<span class='current' >"+count+"</span>"; 
            } 
        } 
    } 
    if(totalpage>10){        //总页数大于十页 
        if(parseInt((cpage-1)/10) == 0) 
        {             
            for (count=1;count<=10;count++) 
            {    if(count!=cpage) 
                { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
                }else{ 
                    outstr = outstr + "<span class='current'>"+count+"</span>"; 
                } 
            } 
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'> 下一组 </a>"; 
        } 
        else if(parseInt((cpage-1)/10) == parseInt(totalpage/10)) 
        {     
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+(parseInt((cpage-1)/10)*10)+")'>上一组</a>"; 
            for (count=parseInt(totalpage/10)*10+1;count<=totalpage;count++) 
            {    if(count!=cpage) 
                { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
                }else{ 
                    outstr = outstr + "<span class='current'>"+count+"</span>"; 
                } 
            } 
        } 
        else 
        {     
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+(parseInt((cpage-1)/10)*10)+")'>上一组</a>"; 
            for (count=parseInt((cpage-1)/10)*10+1;count<=parseInt((cpage-1)/10)*10+10;count++) 
            {         
                if(count!=cpage) 
                { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
                }else{ 
                    outstr = outstr + "<span class='current'>"+count+"</span>"; 
                } 
            } 
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'> 下一组 </a>"; 
        } 
    }     
    document.getElementById("setpage").innerHTML = "<div id='setpage'><span id='info'>共&nbsp;"+totalpage+"&nbsp;页&nbsp;|&nbsp;第&nbsp;"+cpage+"&nbsp;页</span>" + outstr + "</div>"; 
    outstr = ""; 
}