package com.Zxing.Activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.Zxing.createCode.Create2DCode;
import com.example.zxingtest.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class BuildUrlActivity extends Activity {
	private Bitmap bitMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_build_url);
		final ImageView img_url =(ImageView) findViewById(R.id.img_url);
		final EditText edit_url = (EditText) findViewById(R.id.edit_url);
		final Button btn_url_save= (Button) findViewById(R.id.btn_url_save);
		Button btn_url = (Button) findViewById(R.id.btn_url);
		btn_url.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Create2DCode create2DCode = new Create2DCode();
				create2DCode.setStr(edit_url.getText().toString());
				bitMap= create2DCode.create2DCode();
				img_url.setImageBitmap(bitMap);
				btn_url_save.setVisibility(1);
			}});
		btn_url_save.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				saveBitmap(bitMap);
				
			}});
	}
	public void saveBitmap(Bitmap bmp){
		Bitmap bitmap =Bitmap.createBitmap(800,600,Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		//加载背景图片
		Bitmap bmps = BitmapFactory.decodeResource(getResources(), R.drawable.ic_background);
		canvas.drawBitmap(bmps, 0, 0,null);
		canvas.drawBitmap(bmp, 10, 100,null);
		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
		//文件存储路径
		File file = Environment.getExternalStorageDirectory();
		//Toast.makeText(this, file.toString(), Toast.LENGTH_LONG).show();
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file.getPath()+"/url_"+new Date().toLocaleString());
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
			Toast.makeText(this, "二维码已经保存到本地", Toast.LENGTH_LONG).show();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
