/**
 * 
 */
package com.andy.sliderbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.andy.R;

/**
 * @author mwho
 *
 */
public class SliderButtonView extends LinearLayout {

	private SeekBar slideButton = null;
	private OnSeekBarChangeListener touchListener = new OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			int progress = seekBar.getProgress();
			if (progress < 100) seekBar.setProgress(0); //if you don't slide all the way, spring back to the beginning
			
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			//Log.d("Slider", "onTouchEvent received {x-pos=" + progress+'}');
		}
	};
	/**
	 * @param context
	 * @param attrs
	 */
	public SliderButtonView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.sliders, this, true);
		
		this.slideButton = ((SeekBar) findViewById(R.id.sliderbutton));
		this.slideButton.setOnSeekBarChangeListener(this.touchListener);
	}

}
