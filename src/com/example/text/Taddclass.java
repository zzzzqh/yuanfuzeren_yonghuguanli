package com.example.text;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.text.R.id;
import com.example.text.Taddclass;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
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
import android.widget.Toast;

public class Taddclass extends Activity {
    private Button bt4;
    private Button bt5;
    
    private EditText addclass_course_name,addclass_first_week,addclass_last_week,addclass_isbn_number;
    private EditText addclass_book_name,addclass_ps;
    private RadioButton addclass_xuanyong,addclass_zibian;
    
    private Spinner addclass_professical_aspect1;
    private ArrayAdapter<String> adapter;
	private List<String> list=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taddclass_view);
		bt4=(Button) findViewById(R.id.addclass_button4);
		bt5=(Button) findViewById(R.id.addclass_button5);
		
		
		addclass_course_name=(EditText) findViewById(R.id.addclass_course_name);
		addclass_first_week=(EditText) findViewById(R.id.addclass_first_week);
		addclass_last_week=(EditText) findViewById(R.id.addclass_last_week);
		addclass_isbn_number=(EditText) findViewById(R.id.addclass_isbn_number);
		addclass_book_name=(EditText) findViewById(R.id.addclass_book_name);
		addclass_ps=(EditText) findViewById(R.id.addclass_ps);
		addclass_xuanyong=(RadioButton) findViewById(R.id.addclass_xuanyong);
		addclass_zibian=(RadioButton) findViewById(R.id.addclass_zibian);

		addclass_professical_aspect1=(Spinner) findViewById(R.id.addclass_professical_aspect1);
		
		
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
	        addclass_professical_aspect1.setAdapter(adapter);
		
		
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

		    Bundle b= new Bundle();
		    b.putString("addclass_course_name", "�γ�����:"+addclass_course_name.getText().toString());
		    b.putString("addclass_first_week", "��ʼ��:"+addclass_first_week.getText().toString());
		    b.putString("addclass_last_week","�����ܣ�"+addclass_last_week.getText().toString());
		    b.putString("addclass_isbn_number", "ISBN����:"+addclass_isbn_number.getText().toString());
		    b.putString("addclass_book_name", "�̲�����:"+addclass_book_name.getText().toString());
		    
		    if(addclass_xuanyong.isChecked()){
				b.putString("leixing", "�̲����ͣ�ѡ��");
			}else{
				b.putString("leixing", "�̲����ͣ��Ա�");
			}
		    b.putString("addclass_professical_aspect1", "רҵ����:"+addclass_professical_aspect1.getSelectedItem().toString());
		    b.putString("addclass_ps", "��ע:"+addclass_ps.getText().toString());
		   
		     Intent intent = new Intent(Taddclass.this,Taddclass_1.class);
			 intent.putExtra("data", b);
			 Taddclass.this.startActivity(intent);
			}
		});
		
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Taddclass.this,Tmyclass.class);
				Taddclass.this.startActivity(intent);
			}
		});
	}

	
}
