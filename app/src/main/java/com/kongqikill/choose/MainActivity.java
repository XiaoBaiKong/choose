package com.kongqikill.choose;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.app.*;
import android.os.*;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.content.Intent.*;
import android.companion.*;
import android.content.res.*;
import android.util.*;
import java.lang.reflect.*;
import android.net.*;
import android.database.*;
import android.provider.*;
import java.security.PublicKey;
//import com.user.app.MainActivity;
import com.kongqikill.choose.MainActivity;
import com.kongqikill.choose.About;
import java.lang.CharSequence;

public class MainActivity extends Activity 
{
    //声明组件
    private LinearLayout qy_1;
    private LinearLayout qy_2;
    private Button an_gx;
    private Button an_bgx;
    private Button an_dqs;
    private Button an_gqs;
    private Button an_cz;
    private TextView wb_jg;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //全屏
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //获取组件
        qy_1 = (LinearLayout) findViewById(R.id.qy_1);
        qy_2 = (LinearLayout) findViewById(R.id.qy_2);
        an_gx = (Button) findViewById(R.id.an_gx);
        an_bgx = (Button) findViewById(R.id.an_bgx);
        an_dqs = (Button) findViewById(R.id.an_dqs);
        an_gqs = (Button) findViewById(R.id.an_gqs);
        an_cz = (Button) findViewById(R.id.an_cz);
        wb_jg = (TextView) findViewById(R.id.wb_jg);
        //隐藏后面两个布局
        qy_1.setVisibility(View.GONE);
        qy_2.setVisibility(View.GONE);
        //按钮_甘心被单击
       an_gx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                //隐藏区域1
                qy_1.setVisibility(View.GONE);
                //显示区域2
                qy_2.setVisibility(View.VISIBLE);
                //设置结果的内容为空
                wb_jg.setText("");
                //设置操作按钮内容为退出
                an_cz.setText(R.string.cz_2);
                //按钮_操作被单击
                an_cz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View View) {
                        //关闭程序
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                });
            }
        });
        //按钮_不甘心被单击
        an_bgx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                //显示区域1
                qy_1.setVisibility(View.VISIBLE);
                //按钮_低情商被单击
                an_dqs.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View View) {
                        //显示区域2
                        qy_2.setVisibility(View.VISIBLE);
                        //设置结果的内容为第1个
                        wb_jg.setText(R.string.jg_1);
                        //设置操作按钮的内容为复制
                        an_cz.setText(R.string.cz_1);
                        //按钮_操作被单击
                        an_cz.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View View) {
                               //调用复制文本的方法，将结果的内容复制到剪切板
                               copy_text(MainActivity.this,wb_jg.getText().toString());
                               //提示内容已复制
                               Toast.makeText(MainActivity.this,"已将内容复制到剪切板！",0).show();
                            }
                        });
                    }
                });
                //按钮_高情商被单击
                an_gqs.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View View) {
                        //让区域2显示
                        qy_2.setVisibility(View.VISIBLE);
                        //设置结果的内容为第2种
                        wb_jg.setText(R.string.jg_2);
                        //设置操作按钮的内容
                        an_cz.setText(R.string.cz_1);
                        //按钮_操作被单击
                        an_cz.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View View) {
                                //调用复制文本的方法，将结果的内容复制到剪切板
                                copy_text(MainActivity.this,wb_jg.getText().toString());
                                //提示内容已复制
                                Toast.makeText(MainActivity.this,"已将内容复制到剪切板！",0).show();
                            }
                        });
                    }
                });
            }
        });
        
    }
    
    //启动窗口创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //设置菜单
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //菜单项被单击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //判断被单击的选项
        if (id == R.id.about) {
            //切换窗口
            Intent intent = new Intent(this, About.class);
		    this.startActivity(intent);
            return true;
        }
        if (id == R.id.signout) {
            //关闭程序
            android.os.Process.killProcess(android.os.Process.myPid());
            return true;
            
        }

        return super.onOptionsItemSelected(item);
    }
    
    //复制文本的方法
    public void copy_text(Context Cont,String text) {
        ClipboardManager clipboard = (ClipboardManager) this.getSystemService("clipboard");
		clipboard.setText(text);
    }
    
}