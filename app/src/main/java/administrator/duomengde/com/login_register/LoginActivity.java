package administrator.duomengde.com.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.raphets.roundimageview.RoundImageView;
import administrator.duomengde.com.MainActivity;
import administrator.duomengde.com.R;
import androidx.appcompat.app.AppCompatActivity;

//登录
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mLoginIv;
    private EditText mLoginEdPhoneEmil;
    private LinearLayout mLoginLlEdPhoneEmil;
    private EditText mLoginRegisterCode;
    private TextView mLoginGetcodeBtn;
    private LinearLayout mLoginLlEdCode;
    private TextView mLoginCode;
    private Button mLoginDenglu;
    private TextView mLoginBoundary;
    private TextView mLoginRegisterName;
    private TextView mLoginForgetPass;
    private RelativeLayout mLoginRl;
    private TextView mLoginTvShortcutLogin;
    private ImageView mLoginWechat;
    private String loginEdPhoneEmil;
    private String loginRegisterCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        mLoginIv = findViewById(R.id.login_iv);
//        mLoginEdPhoneEmil = findViewById(R.id.);
//        mLoginLlEdPhoneEmil = findViewById(R.id.login_ll_ed_phone_emil);
//        mLoginRegisterCode = findViewById(R.id.login_register_code);
//        mLoginGetcodeBtn = findViewById(R.id.login_getcode_btn);
//        mLoginLlEdCode = findViewById(R.id.login_ll_ed_code);
//        mLoginCode = findViewById(R.id.login_code);
//        mLoginDenglu = findViewById(R.id.login_denglu);
//        mLoginBoundary = findViewById(R.id.login_boundary);
//        mLoginRegisterName = findViewById(R.id.login_register_name);
//        mLoginForgetPass = findViewById(R.id.login_forget_pass);
//        mLoginRl = findViewById(R.id.login_rl);
//        mLoginTvShortcutLogin = findViewById(R.id.login_tv_shortcut_login);
//        mLoginWechat = findViewById(R.id.login_wechat);
        initView();
    }
    private void initView() {
//        mLoginDenglu.setOnClickListener(this);//登录按钮
//        mLoginWechat.setOnClickListener(this);
//        mLoginCode.setOnClickListener(this);//密码登录
//        mLoginRegisterName.setOnClickListener(this);
//        mLoginForgetPass.setOnClickListener(this);

//        loginEdPhoneEmil = mLoginEdPhoneEmil.getText().toString().trim();
//        loginRegisterCode = mLoginRegisterCode.getText().toString().trim();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_denglu:
//                Intent intent = new Intent(this, MainActivity.class);
//                startActivity(intent);
                if (!loginEdPhoneEmil.isEmpty() && !loginRegisterCode.isEmpty()) {
                    //登录主界面
                }
                break;
            case R.id.login_wechat:
//                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.login_code://密码登录
//                break;
            case R.id.login_register_name://注册账号
//                Intent register_intent = new Intent(this, RegisterActivity.class);
//                startActivity(register_intent);
                break;
            case R.id.login_forget_pass://忘记密码
//                Intent forgetintent = new Intent(this, FindPasswordActivity.class);
//                startActivity(forgetintent);
                break;
        }
    }
}