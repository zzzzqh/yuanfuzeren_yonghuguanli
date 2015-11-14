package com.example.text;

import java.util.ArrayList;
import java.util.List;

import com.example.sql.user;
import com.example.text.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Midentity extends Activity {
	
	
	private EditText miendtity_password,midentity_age,m_email,mphone_number;
	private RadioButton midentity_boy;
	private Spinner m_professical_aspect1;
	private ArrayAdapter<String> adapter;
	private List<String> list=new ArrayList<String>();
	private TextView tv1;
	private TextView tv2;
	private Button mbt1;
	private Button mbt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.midentity);
		mbt1=(Button) findViewById(R.id.mmabutton1);
		mbt2=(Button) findViewById(R.id.mmabutton2);
		tv1=(TextView) findViewById(R.id.midentity_zhanghao);
		tv2=(TextView) findViewById(R.id.midentity_mima);
		miendtity_password=(EditText) findViewById(R.id.miendtity_password);
		midentity_age=(EditText) findViewById(R.id.midentity_age);
		m_email=(EditText) findViewById(R.id.m_email);
		mphone_number=(EditText) findViewById(R.id.mphone_number);
		midentity_boy=(RadioButton) findViewById(R.id.midentity_boy);
		m_professical_aspect1=(Spinner) findViewById(R.id.m_professical_aspect1);
		
		user u=new user();
		String xingming=u.getXingming();
		String mima=u.getMima();
		tv1.setText("����:"+ xingming);
		tv2.setText("ԭʼ����:"+ mima);
	    list.add("�����(ʵ���)");
        list.add("�����(׿Խ��)");
        list.add("�����רҵ");
        list.add("�������רҵ");
        list.add("��ѧ��(ʵ���)");
        list.add("��ѧ��");
        list.add("���繤��רҵ");
        list.add("��Ϣ��ȫרҵ");
     
        /*Ϊ�б���һ����������������ǰ���List*/		
        adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        /*Ϊ���������������б���ʽ*/
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        //δspinner���d�m����
        m_professical_aspect1.setAdapter(adapter);
	
		
		
		mbt1.setOnClickListener(new OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				
				Bundle c=new Bundle();
            	c.putString("miendtity_password",miendtity_password.getText().toString());	
            	c.putString("midentity_age",midentity_age.getText().toString());
            	c.putString("m_email",m_email.getText().toString());
            	c.putString("mphone_number",mphone_number.getText().toString());
            	c.putString("m_professical_aspect1", m_professical_aspect1.getSelectedItem().toString());
            	if(midentity_boy.isChecked()){
    				c.putString("sex", "��");
    			}else{
    				c.putString("sex", "Ů");
    			}
            	
				// TODO Auto-generated method stub
				Intent intent=new Intent(Midentity.this,Mreset.class);
				intent.putExtra("data", c);
				Midentity.this.startActivity(intent);
			}
		});
		mbt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Midentity.this,Mmain.class);
				Midentity.this.startActivity(intent);
			}
		});
	}

	
}
