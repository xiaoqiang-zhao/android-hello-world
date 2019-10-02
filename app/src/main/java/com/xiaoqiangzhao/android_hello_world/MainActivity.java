package com.xiaoqiangzhao.android_hello_world;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置主屏 view
        setContentView(R.layout.activity_main);
        // 顶部工具条
         Toolbar toolbar = findViewById(R.id.toolbar);
        // 将 menu 注入到 toolbar
         setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /** Called when the user clicks the Search button */
    public void search(View view) {
        // 获取输入框组件
        EditText editText = (EditText) findViewById(R.id.searchInputEditText);
        // 获取输入的字符串
        String message = editText.getText().toString();

        // 写入到第一个文本组件中
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(message);

        // 实例化一个 Intent 对象，指定要跳转到的页面
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        // 跳转到指定页面
        startActivity(intent);
    }

}
