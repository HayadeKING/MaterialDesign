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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
import com.example.administrator.materialdesign_demo_20170221.adapter.RecyclerAdapter;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private CircleImageView circleImage, circleImageView1;

    private View headerLayout;

    private FloatingActionButton floatingActionButton;

    private ImageView header_back;

    private RecyclerView recyclerView1;

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
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("");
        }
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);
        headerLayout = navigationView.getHeaderView(0);
        circleImage = (CircleImageView) headerLayout.findViewById(R.id.icon_image);
        Glide.with(this).load("https://imgsa.baidu.com/baike/w%3D268/sign=a79f7064bb119313c743f8b65d390c10/4ec2d5628535e5dd13cd1b797fc6a7efcf1b62b7.jpg").into(circleImage);
        header_back = (ImageView) headerLayout.findViewById(R.id.back_image);
        Glide.with(this).load("http://img1.gamersky.com/image2016/11/20161121_lr_176_1/gamersky_04small_08_201611211156D7E.jpg").into(header_back);
        circleImageView1 = (CircleImageView) findViewById(R.id.circleimage);
        Glide.with(this).load("https://imgsa.baidu.com/baike/w%3D268/sign=a79f7064bb119313c743f8b65d390c10/4ec2d5628535e5dd13cd1b797fc6a7efcf1b62b7.jpg").into(circleImageView1);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingbutton);
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview_view);
        /*对第一个RecyclerView进行适配*/
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager);
        String[] attr = getResources().getStringArray(R.array.海报);
        List<String> list1 = Arrays.asList(attr);
        RecyclerAdapter adapter1 = new RecyclerAdapter(this, list1);
        recyclerView1.setAdapter(adapter1);
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
