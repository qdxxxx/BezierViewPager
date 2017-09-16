# BezierViewPager
[![](https://www.jitpack.io/v/qdxxxx/BezierViewPager.svg)](https://www.jitpack.io/#qdxxxx/BezierViewPager)
[![](https://badge.juejin.im/entry/58e5b4a7ac502e4957aa46b6/likes.svg?style=flat)

----
 ![image](https://github.com/qdxxxx/BezierViewPager/blob/master/appGif/效果图.gif)
 
 喜欢~~这几位小姐姐~~的话，欢迎随手点个star。多谢各位老铁了。
### 集成方式

 - 注入依赖
Step 1. Add the JitPack repository to your build file
 Step 2. Add the dependency
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
```
dependencies {
    compile 'com.github.qdxxxx:BezierViewPager:v1.0.5'
}
```
#### Version
---
 - v1.0.3  ： 相对比1.0.2降低minSdkVersion至15，```cardAdapter.addImgUrlList(List<Object> imgUrlList); ``` 方法里图片集合List字段改为Obj，可接受drawable文件资源图片/Uri/...Glide可接受即可。
 - v1.0.5  ： 删除无用的资源文件.


<br/>

### xml布局代码
```
    <qdx.bezierviewpager_compile.vPage.BezierViewPager
        android:id="@+id/view_page"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <qdx.bezierviewpager_compile.BezierRoundView
        android:id="@+id/bezRound"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
     />
```
<br/>

### Activity里面集成代码
```
 CardPagerAdapter cardAdapter = new CardPagerAdapter(getApplicationContext());
 cardAdapter.addImgUrlList(imgList);  //放置图片url的list，v1.0.3版本imgList集合类型为List<Obj>，只要Glide支持的都可以加载
 
BezierViewPager viewPager = (BezierViewPager) findViewById(R.id.view_page);
viewPager.setAdapter(cardAdapter);

BezierRoundView bezRound = (BezierRoundView) findViewById(R.id.bezRound);
bezRound.attach2ViewPage(viewPager);
```
<br/>
<br/>

### 方法及属性介绍

 - BezierRoundView

name           | format     |中文解释
----           |------      |----
color_bez      | color    	|贝塞尔圆球颜色
color_touch    | color   	|触摸反馈
color_stroke   | color	  	|圆框的颜色
time_animator  | integer 	|动画时间
round_count    | integer  	|圆框数量，即Adapter.getCount
radius         | dimension	|贝塞尔圆球半径，圆框半径为(radius-2)
attach2ViewPage|BezierViewPager|绑定指定的ViewPager(处理滑动时触摸事件)<br/>并自动设置round_count


---
 - BezierViewPager[extends ViewPager]
 
name           | format     |中文解释
----           |------      |----
showTransformer| float   	|ViewPager滑动到当前显示页的放大比例


---
 - CardPagerAdapter[extends PagerAdapter]
 
name                      | format                  |中文解释
----                      |------                   |----
addImgUrlList             | List                    |包含图片地址的list
setOnCardItemClickListener| OnCardItemClickListener |当前ViewPager点击事件<br/>返回CurPosition
setMaxElevationFactor     | integer                 |Adapter里CardView最大的Elevation


---


### Article
---
博客详解文章
[http://blog.csdn.net/qian520ao/article/details/68952079](http://blog.csdn.net/qian520ao/article/details/68952079)
