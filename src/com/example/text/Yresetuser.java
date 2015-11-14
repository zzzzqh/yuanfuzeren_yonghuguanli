package com.example.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Yresetuser extends Activity {

	private Button ybt17;
	private Button ybt18;
	
	
	private EditText yonghuming,mima;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yresetuser_view);
		ybt17=(Button) findViewById(R.id.ybutton17);
		ybt18=(Button) findViewById(R.id.ybutton18);
		
		yonghuming=(EditText) findViewById(R.id.yresetuser_user_name);
		mima=(EditText) findViewById(R.id.yresetuser_input_password);
		
		ybt17.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Bundle b=new Bundle();
				b.putString("yonghuming", yonghuming.getText().toString());
				b.putString("mima", mima.getText().toString());
				
				Intent intent=new Intent(Yresetuser.this,Yresetuser_1.class);
				intent.putExtra("data", b);
				Yresetuser.this.startActivity(intent);
				//所选用户的信息按照adduser_1的形势展示。
				
			}
		});
		ybt18.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Yresetuser.this,Ymanageruser.class);
				Yresetuser.this.startActivity(intent);
			}
		});
		
	}
	
	
}
