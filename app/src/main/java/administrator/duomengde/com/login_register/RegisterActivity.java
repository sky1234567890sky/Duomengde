package administrator.duomengde.com.login_register;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import administrator.duomengde.com.R;
import androidx.appcompat.app.AppCompatActivity;

//注册
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mRegisterBack;
    private ImageView mRegisterImg;
    private LinearLayout mLlEdPhoneEmil;
    private View mView;
    private EditText mRegisterEdPhoneEmil;
    private EditText mEtInputPhoneNum;
    private EditText mRegisterEdPass;
    private EditText mRegisterEdInviteCode;

    private TextView mRegisterGetcode;
    private LinearLayout mLlEdCode;
    private LinearLayout mLlEdPass;
    private LinearLayout mLlEdInviteCode;
    private Button mRegissterBtn;
    private String phone_emil;
    private String EtInputPhoneNum;
    private String registerEdPass;
    private String registerEdInviteCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        mRegisterBack = findViewById(R.id.register_back);
//        mRegisterImg = findViewById(R.id.register_img);
//        mRegisterEdPhoneEmil = findViewById(R.id.register_ed_phone_emil);
//        mLlEdPhoneEmil = findViewById(R.id.ll_ed_phone_emil);
//        mView = findViewById(R.id.view);
//        mEtInputPhoneNum = findViewById(R.id.et_input_phone_num);
//        mRegisterGetcode = findViewById(R.id.register_getcode);
//        mLlEdCode = findViewById(R.id.ll_ed_code);
//        mRegisterEdPass = findViewById(R.id.register_ed_pass);
//        mLlEdPass = findViewById(R.id.ll_ed_pass);
//        mRegisterEdInviteCode = findViewById(R.id.register_ed_invite_code);
//        mLlEdInviteCode = findViewById(R.id.ll_ed_invite_code);
//        mRegissterBtn = findViewById(R.id.register_btn);
        initView();
    }
    private void initView() {
//        mRegissterBtn.setOnClickListener(this);//注册
//        mRegisterImg.setOnClickListener(this);//头像
//        mRegisterGetcode.setOnClickListener(this);//验证码
//
//        phone_emil = mRegisterEdPhoneEmil.getText().toString().trim();
//        EtInputPhoneNum = mEtInputPhoneNum.getText().toString().trim();//验证码
//        registerEdPass = mRegisterEdPass.getText().toString().trim();//密码
//        registerEdInviteCode = mRegisterEdInviteCode.getText().toString().trim();//邀请码
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
//                if (!phone_emil.isEmpty() &&!EtInputPhoneNum.isEmpty() &&!registerEdPass.isEmpty() &&!registerEdInviteCode.isEmpty()){

//                }else{
                    Toast.makeText(this, "输入有误", Toast.LENGTH_SHORT).show();
//                }
                break;
        }
    }
}
