package com.parchment.widget.adapterview.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Adapter;

import com.parchment.widget.adapterview.AdapterView;
import com.parchment.widget.adapterview.AdapterViewHandler;
import com.parchment.widget.adapterview.AdapterViewInitializer;
import com.parchment.widget.adapterview.AdapterViewManager;
import com.parchment.widget.adapterview.Attributes;
import com.parchment.widget.adapterview.LayoutManagerAttributes;
import com.parchment.widget.adapterview.OnSelectedListener;
import com.parchment.widget.adapterview.SnapPosition;

/**
 * Created by Emir Hasanbegovic
 */
public class ListView<ADAPTER extends Adapter> extends AdapterView<ADAPTER, View> implements OnLongClickListener, OnClickListener, OnSelectedListener, AdapterViewHandler {

    public ListView(final Context context) {
        super(context);
    }

    public ListView(final Context context, final AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListView(final Context context, final AttributeSet attributeSet, final int defStyle) {
        super(context, attributeSet, defStyle);
    }

    @Override
    protected AdapterViewInitializer<View> getAdapterViewInitializer(final Context context, final AttributeSet attributeSet) {
        final Attributes attributes = new Attributes(context, attributeSet);

        final boolean isViewPager = attributes.isViewPager();
        final boolean isVerticalScroll = attributes.isVertical();
        final int cellSpacing = (int) attributes.getCellSpacing();
        final boolean isCircularScroll = attributes.isIsCircularScroll();
        final boolean snapToPosition = attributes.isSnapToPosition();
        final int viewPagerInterval = attributes.getViewPagerInterval();
        final SnapPosition snapPosition = attributes.getSnapPosition();
        final boolean selectOnSnap = attributes.selectOnSnap();
        final boolean selectWhileScrolling = attributes.selectWhileScrolling();
        final LayoutManagerAttributes layoutManagerAttributes = new LayoutManagerAttributes(isCircularScroll, snapToPosition, isViewPager, viewPagerInterval, snapPosition, cellSpacing, selectOnSnap, selectWhileScrolling, isVerticalScroll);

        final AdapterViewManager adapterViewManager = new AdapterViewManager();
        final ListLayoutManager listLayoutManager = new ListLayoutManager(this, this, adapterViewManager, layoutManagerAttributes);

        final AdapterViewInitializer<View> adapterViewAdapterViewInitializer = createAdapterViewInitializer(context, isViewPager, adapterViewManager, listLayoutManager, isVerticalScroll);
        return adapterViewAdapterViewInitializer;
    }
}