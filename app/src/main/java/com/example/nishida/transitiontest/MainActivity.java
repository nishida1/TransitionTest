package com.example.nishida.transitiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // the key constant
    public static final String EXTRA_MESSAGE
            = "com.example.nishida.transitiontest.MESSAGE";

    private final int REQUEST_PERMISSION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= 23){
            checkPermission();
        }
        else{
            locationPermission();
            finish();
        }

    }

    // locationPermission に intent
    private void locationPermission() {
        Intent intent = new Intent(getApplication(), LocationPermission.class);
        startActivity(intent);
    }

    // permissionの確認
    public void checkPermission() {
        // 既に許可している
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){
            locationPermission();
            finish();
        }
        // 拒否していた場合
        else{
            requestStoragePermission();
        }
    }

    // 許可を求める
    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION);
        } else {
            Toast toast = Toast.makeText(this, "アクセス許可がないと動作しません。再起動をおこないメディアファイルへのアクセスの許可をおこなってください。", Toast.LENGTH_LONG);
            toast.show();

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    REQUEST_PERMISSION);
        }
    }

    // 結果の受け取り
    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION) {
            // 使用が許可された
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationPermission();
                finish();
            } else {
                // それでも拒否された時の対応
                Toast toast = Toast.makeText(this, "アクセス許可がないと動作しません。再起動をおこないメディアファイルへのアクセスの許可をおこなってください。", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}