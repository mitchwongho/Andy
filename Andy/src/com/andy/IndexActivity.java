/**
 * 
 */
package com.andy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andy.fragments.tabs.TabsFragmentActivity;
import com.andy.fragments.tabs.TabsViewPagerFragmentActivity;
import com.andy.fragments.viewpager.ViewPagerFragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

/**
 * This Activity is responsible for providing an index to the
 * examples in this project
 */
public class IndexActivity extends FragmentActivity {

	private FragmentManager fm;
	private ListFragment list;
	private List<Map<String, String>> listItems;
	private String[] froms;
	private int[] viewIds;
	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.index_list_view);
		fm = super.getSupportFragmentManager();
		this.listItems = new ArrayList<Map<String, String>>();
		this.list = (ListFragment)fm.findFragmentById(R.id.index_list);
		//set OnClick Listener
		this.list.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

			/* (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				switch(position) {
				case 0:
					IndexActivity.this.startActivity(new Intent(IndexActivity.this, TabsFragmentActivity.class));
					break;
				case 1:
					IndexActivity.this.startActivity(new Intent(IndexActivity.this, ViewPagerFragmentActivity.class));
					break;
				case 2:
					IndexActivity.this.startActivity(new Intent(IndexActivity.this, TabsViewPagerFragmentActivity.class));
					break;
				}
				
			}
			
		});
		
		this.froms = new String[] {"name"};
		this.viewIds = new int[] {android.R.id.text1};
	}
	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onResume()
	 */
	@Override
	protected void onResume() {
		// bind data to the view
		if (this.listItems.isEmpty()) {
			this.bind(0, "name", "Tab Fragments Example");
			this.bind(1, "name", "ViewPager Example");
			this.bind(2, "name", "Tabs View Pager");
		}
		// Initialise List Adapter
		this.list.setListAdapter(new SimpleAdapter(this, this.listItems, android.R.layout.simple_list_item_1, this.froms, this.viewIds));
		super.onResume();
	}
	
	/**
	 * Binds the key-value data pair to the list item at the specified list position 
	 * @param pos List item position
	 * @param col the column name
	 * @param val column value
	 * @return the mapping of column values
	 */
	private Map<String, String> bind(int pos, String col, String val) {
		Map<String, String> map = null;
		if (!this.listItems.isEmpty() && pos < this.listItems.size()) 
			map = this.listItems.get(pos);
		else if (map == null) {
			map = new HashMap<String, String>();
			this.listItems.add(Math.min(pos, this.listItems.size()), map);
		}
		map.put(col, val);
		return map;
	}
}
