package com.Zxing.createCode;

import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import android.graphics.Bitmap;

public class Create2DCode {
	private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Bitmap create2DCode(){
		if(str==null)
			return null;
		else{
			//生成二维矩阵
			BitMatrix matrix=null;
			try {
		        Hashtable<EncodeHintType,String> hints = new Hashtable<EncodeHintType,String>();
                hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
				matrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 300, 300,hints);
				
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int height = matrix.getHeight();
			int width = matrix.getWidth();
			//将二维数组转化为一维数组
			int []pixs = new int[height*width];
			for(int y=0;y<height;y++){
				for(int x=0;x<width;x++){
					if(matrix.get(x, y)){
						pixs[y*width+x]=0xff000000;
					}
				}
			}
			
			Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			bitmap.setPixels(pixs, 0, width, 0, 0, width, height);
			return bitmap;
		}
	}
}
