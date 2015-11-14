package com.example.text;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Yresetuser_1 extends Activity{
	
	private Button queren,quxiao;
	private ListView yresetuser_xinxi;
	
	String zhigonghao;
	String name;
	String password;
	String power;
	String phone;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yresetuser_1);
		
		yresetuser_xinxi =(ListView) findViewById(R.id.yresetuser_xinxi);
		queren=(Button) findViewById(R.id.yresetuser_1_button1);
		quxiao=(Button) findViewById(R.id.yresetuser_1_button2);
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");

		List<String> list=new ArrayList<String>();
		
		zhigonghao=b.getString("yonghuming");
		password=b.getString("mima");
		/*
		password
		power
		phone这三个舒心应该是通过查找数据库中与输入信息匹配的用户，然后显示出来
		*/
		list.add("用户名:"+zhigonghao);
		list.add("姓名:");
	
		list.add("初始密码："+password);
		list.add("用户权限:");
		list.add("联系电话:");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		yresetuser_xinxi.setAdapter(adapter);
		
		
		
		
		
		
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Yresetuser_1.this, "修改成功", 1).show();
				Intent intent=new Intent(Yresetuser_1.this,Ymanageruser.class);
				Yresetuser_1.this.startActivity(intent);
				
			}
		});
		
		
		 quxiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(Yresetuser_1.this,Yresetuser.class);
					Yresetuser_1.this.startActivity(intent);
				}
			});
		
		
	}	
}
		

