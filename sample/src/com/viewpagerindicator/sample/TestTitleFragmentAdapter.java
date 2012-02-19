package com.viewpagerindicator.sample;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import com.viewpagerindicator.TitleProvider;

class TestTitleFragmentAdapter extends TestFragmentAdapter implements TitleProvider {
	public TestTitleFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public String getTitle(int position) {
		return TestFragmentAdapter.CONTENT[position % CONTENT.length];
	}

	@Override
	public Drawable[] getIcons(int position) {
		// TODO Auto-generated method stub
		return new Drawable[0];
	}
}