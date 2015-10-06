package com.Zxing.Activity;

import com.example.zxingtest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageButton imgbtn_scan  = (ImageButton) findViewById(R.id.imgbtn_scan);
		imgbtn_scan.getBackground().setAlpha(50);
		ImageButton imgbtn_build_url = (ImageButton) findViewById(R.id.imgbtn_build_url);
		imgbtn_build_url.getBackground().setAlpha(50);
		ImageButton imgbtn_build_text = (ImageButton) findViewById(R.id.imgbtn_build_text);
		imgbtn_build_text.getBackground().setAlpha(50);
		ImageButton imgbtn_build_card = (ImageButton) findViewById(R.id.imgbtn_build_card);
		imgbtn_build_card.getBackground().setAlpha(50);
		
		imgbtn_scan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it=new Intent(MainActivity.this, CaptureActivity.class);
				MainActivity.this.startActivity(it);
			}
		});
		
		imgbtn_build_url.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this, BuildUrlActivity.class);
				MainActivity.this.startActivity(it);
			}});
		imgbtn_build_text.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this, BuildTextActivity.class);
				MainActivity.this.startActivity(it); 
			}});
	}

}
