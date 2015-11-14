package com.example.text;

import com.example.sql.user;
import com.example.text.MainActivity;
import com.example.text.Tmyclass;
import com.example.text.R.id;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button bt0;
	EditText username;
	EditText password;
	String user;
	String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final SQLiteDatabase db=openOrCreateDatabase("user.db", MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
        db.execSQL("create table if not exists usertb(_id integer primary key autoincrement,zhanghao text not null,mima text not null,xingming text not null,suoshuyuan text not null,suoshuxi text null,xingbie text null,nianlin integer null,youxiang text null,shouji text null,quanxian text not null)");
        db.execSQL("create table clatb(_id integer primary key autoincrement,xuenian text not null,xueqi text not null, nianji integer not null,zhuanye text not null,zhuanyerenshu integer not null,kechengmingcheng text not null,xuanxiuleixing text not null,xuefen intger null,xueshi integer  null,shiyanxueshi integer  null,shangjixueshi integer  null)");
        db.execSQL("create table choosetb(_id integer primary key autoincrement,nianji integer not null,zhuanye text not null,kechengmingcheng text not null,xuanxiuleixing text not null,qiqizhouxu text null,renkejiaoshi text null,jiaocaimingcheng text null,ISBN text null,xuanyong text null,beizhu text null)");

        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302307','123456','�����','��ѧ��������ѧѧԺ','xx','xx',24,'xx','xx','��ʦ')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('031302117','123456','���ݺ�','��ѧ��������ѧѧԺ','xx','��',24,'510122600@qq.com','15659434690','��ʦ')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('xifuzeren1','123456','��־�','��ѧ��������ѧѧԺ','�����ϵ','��',24,'xx','xx','ϵ������')");
        db.execSQL("insert into usertb(zhanghao,mima,xingming,suoshuyuan,suoshuxi,xingbie,nianlin,youxiang,shouji,quanxian)values('yuanfuzeren1','123456','��־��','��ѧ��������ѧѧԺ','xx','��',24,'xx','xx','��ѧ��')");
        
        bt0=(Button) findViewById(R.id.main_button0);
        username=(EditText) findViewById(R.id.main_user_name);
        password=(EditText) findViewById(R.id.main_input_password);
        bt0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String n1=username.getText().toString().trim();
	            String p1=password.getText().toString().trim();
	            String pw=null;
	            String qx=null;
	            String zh=null;
	            String xm=null;
	            int nl=0;
	            String sj=null;
	            String yx=null;
	            String sy=null;
	            String sx=null;
	            String sb=null;
	            if(n1.equals("")|| p1.equals("")){
					Toast.makeText(MainActivity.this, "����д������Ϣ", 1).show();
					Intent intent=new Intent(MainActivity.this,MainActivity.class);
					MainActivity.this.startActivity(intent);
				}
	            else
	            {
	            	Cursor c=db.rawQuery("select * from usertb where zhanghao=?", new String[]{n1});     	
	            	if(c!=null){
	                	 while (c.moveToNext()) {
	                		 
	                		  xm = c.getString(c.getColumnIndex("xingming")).trim();
	                		  pw = c.getString(c.getColumnIndex("mima")).trim();
	        				  qx = c.getString(c.getColumnIndex("quanxian")).trim();
	        				  zh=c.getString(c.getColumnIndex("zhanghao")).trim();
	        				 
	        				  nl=c.getInt(c.getColumnIndex("nianlin"));
	        				  
	        				  sy=c.getString(c.getColumnIndex("suoshuyuan")).trim();
	        				  
	        				  sx=c.getString(c.getColumnIndex("suoshuxi")).trim();
	        				 
	        				  sb=c.getString(c.getColumnIndex("xingbie")).trim();
	        				  
	        				  yx=c.getString(c.getColumnIndex("youxiang")).trim();
	        				  
	        				  sj=c.getString(c.getColumnIndex("shouji")).trim();
	        				  
	                	 }
	                	 user u=new user();
	                	 u.setMima(pw);
	                	 u.setXingming(xm);
	                	 u.setZhanghao(n1);
	                	 u.setNianlin(String.valueOf(nl));
	                	 u.setQuanxian(qx);
	                	 u.setShouji(sj);
	                	 u.setSuoshuxi(sx);
	                	 u.setSuoshuyuan(sy);
	                	 u.setYouxiang(yx);
	                	 u.setZhanghao(zh);
	                	 if(zh == null || pw == null){
	                		 Toast.makeText(MainActivity.this, "�û���������,���������", 1).show();
	                		 Intent intent=new Intent(MainActivity.this,MainActivity.class);
	     					 MainActivity.this.startActivity(intent);
	                	 }
	                	 else{
	                		 
		                	 if(!pw.equals(p1)){
		                	 Toast.makeText(MainActivity.this, "�ʺ��������", 1).show();		                	 
		                	 }
		                	 else{
		                		 if("��ʦ".equals(qx)){
		                		 Intent intent=new Intent(MainActivity.this,Tmain.class);
		                		 MainActivity.this.startActivity(intent);
		                		 }
		                		 else if("ϵ������".equals(qx)){
		                		 
		                			 Intent intent=new Intent(MainActivity.this,Mmain.class);
		                			 MainActivity.this.startActivity(intent);
		                		 }
		                		 else if("��ѧ��".equals(qx)){
		                			 Intent intent=new Intent(MainActivity.this,Ymain.class);
		                			 MainActivity.this.startActivity(intent);
		                		 }
		                	 }
	                	 }
	                	 c.close();
	                 }
	            }
				
				
			}
		});
        
    }

    
}


