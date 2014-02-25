package com.sydney.mylotteries.input;

import android.content.Context;

public final class InputFactory {
	private static final int TYPE_NONE    = 0;
	public static final int TYPE_CUR_PAGE = (TYPE_NONE + 1);
	public static final int TYPE_NEW_PAGE = (TYPE_NONE + 2);
	public static final int TYPE_ACTIVITY = (TYPE_NONE + 3);
	
	public static InputDelegate newDelegate(Context aContext, int nType) {
		return null;
	}
	
	private InputFactory() {
	}
}
