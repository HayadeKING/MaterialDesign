package com.example.administrator.materialdesign_demo_20170221;

import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Field;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private LinearLayout linear_statusbar, drawer_statusbar;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private CircleImageView circleImage, circleImageView1;

    private View headerLayout;

    private FloatingActionButton floatingActionButton;

    private ImageView header_back, card_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_main);
        initView();
        initAction();
    }

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");*/
        /*linear_statusbar = (LinearLayout) findViewById(R.id.linear_statusbar);
        ViewGroup.LayoutParams layoutParams = linear_statusbar.getLayoutParams();
        layoutParams.height = getStatusBarHeight();
        linear_statusbar.setLayoutParams(layoutParams);
        linear_statusbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));*/
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            /*actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.home_red);*/
            actionBar.setTitle("");
        }
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);
        /*drawer_statusbar = (LinearLayout) findViewById(R.id.drawer_statusbar);
        ViewGroup.LayoutParams layoutParams1 = drawer_statusbar.getLayoutParams();
        layoutParams1.height = getStatusBarHeight();
        drawer_statusbar.setLayoutParams(layoutParams1);
        drawer_statusbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));*/
        headerLayout = navigationView.getHeaderView(0);
        circleImage = (CircleImageView) headerLayout.findViewById(R.id.icon_image);
        Glide.with(this).load("http://img1.gamersky.com/image2016/11/20161121_lr_176_1/gamersky_08small_16_2016112111569D2.jpg").into(circleImage);
        header_back = (ImageView) headerLayout.findViewById(R.id.back_image);
        Glide.with(this).load("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=708750801,3253211594&fm=23&gp=0.jpg").into(header_back);
        circleImageView1 = (CircleImageView) findViewById(R.id.circleimage);
        Glide.with(this).load("http://img1.gamersky.com/image2016/11/20161121_lr_176_1/gamersky_08small_16_2016112111569D2.jpg").into(circleImageView1);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingbutton);
        card_image = (ImageView) findViewById(R.id.card_image);
        Glide.with(this).load("http://img1.gamersky.com/image2016/11/20161121_lr_176_1/gamersky_08small_16_2016112111569D2.jpg").into(card_image);
    }

    private void initAction(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                navigationView.setCheckedItem(item.getItemId());
                return false;
            }
        });
        circleImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "悬浮按钮被点击", Snackbar.LENGTH_SHORT).setAction("Sure", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                Toast.makeText(MainActivity.this, "Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_item:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

    /**获得状态栏的高度*/
    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
