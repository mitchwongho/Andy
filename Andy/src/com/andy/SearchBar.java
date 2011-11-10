/**
 * 
 */
package com.andy;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * @author mwho
 *
 */
public class SearchBar extends LinearLayout {

	/**
	 * @param context
	 * @param attrs
	 */
	public SearchBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(HORIZONTAL);
		setGravity(Gravity.CENTER);
		setWeightSum(1.0f);
		
		LayoutInflater.from(context).inflate(R.layout.searchbar, this, true);
		
		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SearchBar, 0, 0);
		
		String text = array.getString(R.styleable.SearchBar_android_text);
		if (text == null) text = "SEARCH";
		((Button) findViewById(R.id.searchbar_button_a)).setText(text);
		
		//text = array.getString(R.styleable.OkCancelBar_cancelLabel);
		//if (text == null) text = "Cancel";
		//((Button) findViewById(R.id.okcancelbar_cancel)).setText(text);
		
		array.recycle();
	}
	
}
