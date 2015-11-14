package com.example.text;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Yadduser_1 extends Activity{
	
	private Button queren,quxiao;
	private ListView adduser_xinxi;
	
	String zhigonghao;
	String name;
	String password;
	String power;
	String phone;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yadduser_1);
		
		adduser_xinxi =(ListView) findViewById(R.id.adduser_xinxi);
		queren=(Button) findViewById(R.id.adduser_1_button1);
		quxiao=(Button) findViewById(R.id.adduser_1_button2);
		
		Intent intent= this.getIntent();
		Bundle b = intent.getBundleExtra("data");
		
		
		zhigonghao=b.getString("yadduser_zhigonghao");
		name=b.getString("yadduser_name");
		password=b.getString("yadduser_password");
		power=b.getString("yadduser_power");
		phone=b.getString("yadduser_phone");
		
		

		List<String> list=new ArrayList<String>();
		list.add("�û���:"+zhigonghao);
		list.add("����:"+name);
		list.add("��ʼ���룺"+password);
		list.add("�û�Ȩ��:"+power);
		list.add("��ϵ�绰:"+phone);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,list);
		adduser_xinxi.setAdapter(adapter);
		
		
		
		
		
		queren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Yadduser_1.this, "��ӳɹ�", 1).show();
				Intent intent=new Intent(Yadduser_1.this,Yadduser.class);//������֮ǰ�������Ϣ��������д
				Yadduser_1.this.startActivity(intent);
				
			}
		});
		
		
		 quxiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(Yadduser_1.this,Yadduser.class);//����֮ǰ�������Ϣ
					Yadduser_1.this.startActivity(intent);
				}
			});
		
		
	}		
		

	
	

}
