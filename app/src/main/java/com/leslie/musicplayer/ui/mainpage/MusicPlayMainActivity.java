package com.leslie.musicplayer.ui.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseMusicActivity;
import com.leslie.musicplayer.ui.mainpage.adapter.MainPagerAdapter;

public class MusicPlayMainActivity extends BaseMusicActivity implements
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,
        ViewPager.OnPageChangeListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FrameLayout mFlTitleMenu;
    private ImageView mIvTitleOne;
    private ImageView mIvTitleTwo;
    private ImageView mIvTitleThree;
    private ViewPager mVpContent;

    private long exitTime;
    private MainPagerAdapter mMainPagerAdapter;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setEnterTransition(new Fade());
        setContentView(R.layout.music_play_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMainPagerAdapter != null) {
            mMainPagerAdapter.destoryAadapter();
            mMainPagerAdapter = null;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mFlTitleMenu = (FrameLayout) findViewById(R.id.ll_title_menu);
        mIvTitleOne = (ImageView) findViewById(R.id.iv_title_one);
        mIvTitleTwo = (ImageView) findViewById(R.id.iv_title_two);
        mIvTitleThree = (ImageView) findViewById(R.id.iv_title_three);
        mVpContent = (ViewPager) findViewById(R.id.vp_content);
        mIvTitleOne.setSelected(true);

        initListener();
    }

    @Override
    protected void initData() {
        super.initData();
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mVpContent.setAdapter(mMainPagerAdapter);
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        mVpContent.setOffscreenPageLimit(2);
        mVpContent.addOnPageChangeListener(this);
    }

    @Override
    protected void initActionBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_title_menu:
                // 开启菜单
                toggleDrawer();
                break;
            case R.id.iv_title_one:
                if (mVpContent.getCurrentItem() != 0) {
                    setCurrentItem(0);
                }
                break;
            case R.id.iv_title_two:
                // 不然cpu会有损耗
                if (mVpContent.getCurrentItem() != 1) {
                    setCurrentItem(1);
                }
                break;
            case R.id.iv_title_three:
                if (mVpContent.getCurrentItem() != 2) {
                    setCurrentItem(2);
                }
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                setCurrentItem(0);
                break;
            case 1:
                setCurrentItem(1);
                break;
            case 2:
                setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initListener() {
        mFlTitleMenu.setOnClickListener(this);
        mIvTitleOne.setOnClickListener(this);
        mIvTitleTwo.setOnClickListener(this);
        mIvTitleThree.setOnClickListener(this);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * 切换页面
     *
     * @param position 分类角标
     */
    private void setCurrentItem(int position) {
        boolean isOne = false;
        boolean isTwo = false;
        boolean isThree = false;
        switch (position) {
            case 0:
                isOne = true;
                break;
            case 1:
                isTwo = true;
                break;
            case 2:
                isThree = true;
                break;
            default:
                isTwo = true;
                break;
        }
        mVpContent.setCurrentItem(position);
        mIvTitleOne.setSelected(isOne);
        mIvTitleTwo.setSelected(isTwo);
        mIvTitleThree.setSelected(isThree);
    }

    private void toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }
}
