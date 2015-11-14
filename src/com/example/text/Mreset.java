package com.example.text;

import java.util.ArrayList;

import java.util.List;

import com.example.sql.user;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Mreset extends Activity {

	private Button bt1;
	private Button bt2;
	private ListView m_xinxi;
	String password;
	String professical;
	String age;
	String sex;
	String email;
	String phone;
	private List<String> list=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mreset_view);
		
		bt1=(Button) findViewById(R.id.mrbutton1);
		bt2=(Button) findViewById(R.id.mrbutton2);
		m_xinxi=(ListView) findViewById(R.id.m_xinxi);
		

		Intent intent = this.getIntent();
		Bundle c = intent.getBundleExtra("data");
		password=c.getString("miendtity_password");
		professical=c.getString("m_professical_aspect1");
		age=c.getString("midentity_age");
		sex=c.getString("sex");
		email=c.getString("m_email");
		phone=c.getString("mphone_number");
		list.add("�����룺"+password);
		list.add( "רҵ����:"+professical);
		list.add("���䣺"+age);
		list.add("�Ա�"+sex);
		list.add("���䣺"+email);
		list.add("�ֻ����룺"+phone);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, list);
		m_xinxi.setAdapter(adapter);
		
		
		
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user u=new user();
				String xingming=u.getXingming();
				
				String zhanghao=u.getZhanghao();
				
				String suoshuyuan=u.getSuoshuyuan();
				
				String quanxian=u.getQuanxian();
				
				if(password.isEmpty()){
					String mima=u.getMima();
					password=mima;
					
				}
				 
				if(professical.isEmpty())
				{
					String suoshuxi=u.getSuoshuxi();
					professical=suoshuxi;
				}
				
				if(age.isEmpty())
				{
					String nianlin=u.getNianlin();
					age=nianlin;
					int Age=Integer.valueOf(age);
				}
				
				if(sex.isEmpty())
				{
					String xingbie=u.getXingbie();
					sex=xingbie;
				}
				 
				if(email.isEmpty())
				{
					String youxiang=u.getYouxiang();
					email=youxiang;
				}
				
				if(phone.isEmpty())
				{
					String shouji=u.getShouji();
					phone=shouji;
				}
				 
				int Age=Integer.valueOf(age);
			
				SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
				
				db.delete("usertb", "zhanghao=?", new String[]{zhanghao});
				
				db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values("+"'"+zhanghao+"'"+","+"'"+password+"'"+","+"'"+xingming+"'"+","+"'"+suoshuyuan+"'"+","+"'"+professical+"'"+","+"'"+sex+"'"+","+"'"+Age+"'"+","+"'"+email+"'"+","+"'"+phone+"'"+","+"'"+quanxian+"'"+")");
				
				Toast.makeText(Mreset.this, "������Ϣ�޸ĳɹ�", 1).show();
				Intent intent=new Intent(Mreset.this,Midentity.class);
	            Mreset.this.startActivity(intent);
			}
		});
         bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Mreset.this,Midentity.class);
	            Mreset.this.startActivity(intent);
			}
         });
	}
	
	
}
