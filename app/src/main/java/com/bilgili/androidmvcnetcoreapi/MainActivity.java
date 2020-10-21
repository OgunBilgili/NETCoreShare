package com.bilgili.androidmvcnetcoreapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bilgili.androidmvcnetcoreapi.Model.Ogrenci;
import com.bilgili.androidmvcnetcoreapi.Model.tblUser;
import com.bilgili.androidmvcnetcoreapi.Remote.IMyAPI;
import com.bilgili.androidmvcnetcoreapi.Remote.RetrofitClient;

import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    IMyAPI iMyAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    EditText edt_user, edt_password;
    TextView txt_account;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init API
        iMyAPI = RetrofitClient.getInstance().create(IMyAPI.class);

        // Views
        edt_user = findViewById(R.id.edt_user_name);
        edt_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        txt_account = findViewById(R.id.txt_account);

        // Event
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog dialog = new SpotsDialog.Builder()
                        .setContext(MainActivity.this)
                        .build();
                dialog.show();

                // Create User to Login
                //tblUser user = new tblUser(edt_user.getText().toString(), edt_password.getText().toString(), "");
                Ogrenci ogrenci = new Ogrenci(Integer.parseInt(edt_user.getText().toString()), edt_password.getText().toString());

                compositeDisposable.add(iMyAPI.loginUser(ogrenci)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        }, new Consumer<Throwable>(){
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }));


            }
        });


    }
}
