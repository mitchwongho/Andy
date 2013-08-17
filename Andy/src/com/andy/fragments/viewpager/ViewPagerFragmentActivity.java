/**
 * 
 */
package com.andy.fragments.viewpager;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.andy.R;
import com.andy.fragments.tabs.Tab1Fragment;
import com.andy.fragments.tabs.Tab2Fragment;
import com.andy.fragments.tabs.Tab3Fragment;

/**
 * The <code>ViewPagerFragmentActivity</code> class is the fragment activity hosting the ViewPager  
 */
public class ViewPagerFragmentActivity extends FragmentActivity{
	/** maintains the pager adapter*/
	private PagerAdapter mPagerAdapter;
	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.viewpager_layout);
		//initialsie the pager
		this.initialisePaging();
	}
	
	/**
	 * Initialise the fragments to be paged
	 */
	private void initialisePaging() {
		
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Tab1Fragment.class.getName()));
		fragments.add(Fragment.instantiate(this, Tab2Fragment.class.getName()));
		fragments.add(Fragment.instantiate(this, Tab3Fragment.class.getName()));
		this.mPagerAdapter  = new com.andy.fragments.viewpager.PagerAdapter(super.getSupportFragmentManager(), fragments);
		//
		ViewPager pager = (ViewPager)super.findViewById(R.id.viewpager);
		pager.setAdapter(this.mPagerAdapter);
	}

}
