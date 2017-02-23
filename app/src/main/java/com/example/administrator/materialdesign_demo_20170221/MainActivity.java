package com.example.administrator.materialdesign_demo_20170221;

import android.graphics.Color;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

    private ImageView header_back, bar_image;

    private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9;

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;

    private View info_include;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        initView();
        initAction();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
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
        bar_image = (ImageView) findViewById(R.id.bar_image);
        Glide.with(this).load("http://img1.gamersky.com/image2016/11/20161121_lr_176_1/gamersky_04small_08_201611211156D7E.jpg").into(bar_image);
        info_include = findViewById(R.id.info_include);
        String[] info = getResources().getStringArray(R.array.海报);
        String[] info1 = info[0].split("//wang");
        String[] info2 = info[1].split("//wang");
        String[] info3 = info[2].split("//wang");
        String[] info4 = info[3].split("//wang");
        String[] info5 = info[4].split("//wang");
        String[] info6 = info[5].split("//wang");
        String[] info7 = info[6].split("//wang");
        String[] info8 = info[7].split("//wang");
        String[] info9 = info[8].split("//wang");
        textView1 = (TextView) info_include.findViewById(R.id.layout_1_text1);
        textView1.setText(info1[1]);
        textView2 = (TextView) info_include.findViewById(R.id.layout_1_text2);
        textView2.setText(info2[1]);
        textView3 = (TextView) info_include.findViewById(R.id.layout_1_text3);
        textView3.setText(info3[1]);
        textView4 = (TextView) info_include.findViewById(R.id.layout_1_text4);
        textView4.setText(info4[1]);
        textView5 = (TextView) info_include.findViewById(R.id.layout_1_text5);
        textView5.setText(info5[1]);
        textView6 = (TextView) info_include.findViewById(R.id.layout_1_text6);
        textView6.setText(info6[1]);
        textView7 = (TextView) info_include.findViewById(R.id.layout_1_text7);
        textView7.setText(info7[1]);
        textView8 = (TextView) info_include.findViewById(R.id.layout_1_text8);
        textView8.setText(info8[1]);
        textView9 = (TextView) info_include.findViewById(R.id.layout_1_text9);
        textView9.setText(info9[1]);
        imageView1 = (ImageView) info_include.findViewById(R.id.imageview1);
        Glide.with(this).load(info1[0]).into(imageView1);
        imageView2 = (ImageView) info_include.findViewById(R.id.imageview2);
        Glide.with(this).load(info2[0]).into(imageView2);
        imageView3 = (ImageView) info_include.findViewById(R.id.imageview3);
        Glide.with(this).load(info3[0]).into(imageView3);
        imageView4 = (ImageView) info_include.findViewById(R.id.imageview4);
        Glide.with(this).load(info4[0]).into(imageView4);
        imageView5 = (ImageView) info_include.findViewById(R.id.imageview5);
        Glide.with(this).load(info5[0]).into(imageView5);
        imageView6 = (ImageView) info_include.findViewById(R.id.imageview6);
        Glide.with(this).load(info6[0]).into(imageView6);
        imageView7 = (ImageView) info_include.findViewById(R.id.imageview7);
        Glide.with(this).load(info7[0]).into(imageView7);
        imageView8 = (ImageView) info_include.findViewById(R.id.imageview8);
        Glide.with(this).load(info8[0]).into(imageView8);
        imageView9 = (ImageView) info_include.findViewById(R.id.imageview9);
        Glide.with(this).load(info9[0]).into(imageView9);
    }

    private void initAction() {
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
        switch (item.getItemId()) {
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
}
