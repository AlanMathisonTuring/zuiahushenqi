package com.example.zhuishushenqi;

import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ViewPager viewPager;
	
	List<View> list;
	
	Context context;
	
	ImageView imageView;
	
	LinearLayout.LayoutParams lp;
	
	int currenitem;
	
	int width;
	
	TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getApplicationContext();
        
        getwidth();
        ini();
    }

  //初始化
    void ini(){
    	list=new ArrayList<View>();
    	viewPager=(ViewPager)findViewById(R.id.viewpager);
    	imageView=(ImageView)findViewById(R.id.image11);
    	textView1=(TextView)findViewById(R.id.txt1);
    	textView2=(TextView)findViewById(R.id.txt2);
    	textView3=(TextView)findViewById(R.id.txt3);
    	
    	View view1 = LayoutInflater.from(context).inflate(R.layout.view1, null);
    	list.add(view1);
    	View view2 = LayoutInflater.from(context).inflate(R.layout.view2, null);
    	list.add(view2);
    	View view3 = LayoutInflater.from(context).inflate(R.layout.view3, null);
    	list.add(view3);
    	//viewpager绑定适配器
    	viewPager.setAdapter(new myadapt());
    	viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				currenitem=arg0;
							
				clear();
				switch(arg0){
				case 0:
					textView1.setTextColor(getResources().getColor(R.color.baise));
					break;
				case 1:
					textView2.setTextColor(getResources().getColor(R.color.baise));
					break;
				case 2:
					textView3.setTextColor(getResources().getColor(R.color.baise));
					break;			
				}
				
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
						 			 
					if(currenitem==0&&arg0==0){
						
						lp.leftMargin=(int)(arg1*(width/3)+(width/6)+(currenitem*(width/3)));
						imageView.setLayoutParams(lp);
					}else if(currenitem==1&&arg0==0){
						lp.leftMargin=(int)((-(1-arg1))*(width/3)+(width/6)+(currenitem*(width/3)));
						imageView.setLayoutParams(lp);
					}	
					else  if(currenitem==1&&arg0==1){
						lp.leftMargin=(int)(arg1*(width/3)+(width/6)+(currenitem*(width/3)));
						imageView.setLayoutParams(lp);
					}else if(currenitem==2&&arg0==1){
						lp.leftMargin=(int)((-(1-arg1))*(width/3)+(width/6)+(currenitem*(width/3)));
						imageView.setLayoutParams(lp);
					}
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    	
    }
    
    private void clear(){
    	textView1.setTextColor(getResources().getColor(R.color.huise));
    	textView2.setTextColor(getResources().getColor(R.color.huise));
    	textView3.setTextColor(getResources().getColor(R.color.huise));

    }
    
    
    
    //适配器
    class myadapt extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(list.get(position));		
			return list.get(position);
		}
    	
  
    }
    	
    //得到屏幕的宽度	
  
    private void  getwidth(){
    	
    	DisplayMetrics dm=new DisplayMetrics();
    	getWindowManager().getDefaultDisplay().getMetrics(dm);
    	width=dm.widthPixels;
    	
    	 lp=new LinearLayout.LayoutParams(   			
    			LinearLayout.LayoutParams.WRAP_CONTENT, 
    			LinearLayout.LayoutParams.WRAP_CONTENT);
//    	lp.leftMargin=width/6;
//    	imageView.setLayoutParams(lp);
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
