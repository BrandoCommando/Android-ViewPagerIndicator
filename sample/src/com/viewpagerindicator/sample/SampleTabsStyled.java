package com.viewpagerindicator.sample;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import com.viewpagerindicator.sample.R;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitleProvider;

public class SampleTabsStyled extends BaseSampleActivity {
	private static final String[] CONTENT = new String[] { "Recent", "Artists", "Albums", "Songs", "Playlists", "Genres" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_tabs);
		
		mAdapter = new GoogleMusicAdapter(getSupportFragmentManager());
		
		mPager = (ViewPager)findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
		
		mIndicator = (TabPageIndicator)findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}
	
	class GoogleMusicAdapter extends TestFragmentAdapter implements TitleProvider {
		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return TestFragment.newInstance(SampleTabsStyled.CONTENT[position % SampleTabsStyled.CONTENT.length]);
		}

		@Override
		public int getCount() {
			return SampleTabsStyled.CONTENT.length;
		}

		@Override
		public String getTitle(int position) {
			return SampleTabsStyled.CONTENT[position % SampleTabsStyled.CONTENT.length].toUpperCase();
		}

		@Override
		public Drawable[] getIcons(int position) {
			// TODO Auto-generated method stub
			return new Drawable[]{getResources().getDrawable(android.R.drawable.ic_dialog_info)};
		}
	}
}
