package com.Zxing.Activity;

import com.Zxing.createCode.Create2DCode;
import com.example.zxingtest.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class BuildTextActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_build_text);
		EditText edit_text_title=(EditText) findViewById(R.id.edit_text_title);
		EditText edit_text_content=(EditText) findViewById(R.id.edit_text_content);
		Button btn_text=(Button) findViewById(R.id.btn_text);
		btn_text.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}});
	}

}
