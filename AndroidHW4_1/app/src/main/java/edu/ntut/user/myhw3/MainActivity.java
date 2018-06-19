package edu.ntut.user.myhw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRadGrpSex;
    private RadioButton mRadBtnMale;
    private RadioButton mRadBtnFemale;
    private Spinner mSpnAge;
    private ArrayList<CheckBox> mlistChkHobbies;
    private Button mBtnOK;
    private TextView mTxtHobbyResult;

    private MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadGrpSex = (RadioGroup) findViewById(R.id.radGrpSex);
        mRadBtnMale = (RadioButton) findViewById(R.id.radBtnMale);
        mRadBtnFemale = (RadioButton) findViewById(R.id.radBtnFemale);

        mSpnAge = (Spinner) findViewById(R.id.spnAge);

        mlistChkHobbies = new ArrayList<>();
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk01_Music));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk02_Sing));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk03_Dance));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk04_Travel));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk05_Reading));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk06_Writing));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk07_Climbing));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk08_Swim));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk09_Eating));
        mlistChkHobbies.add((CheckBox) findViewById(R.id.chk10_Drawing));

        mBtnOK = (Button) findViewById(R.id.btnOK);

        mTxtHobbyResult = (TextView) findViewById(R.id.txtHobbyResult);

        mBtnOK.setOnClickListener(btnOKOnClick);
        mRadGrpSex.setOnCheckedChangeListener(radGrpSexOnCheckedChange);

        main = this;
    }

    private RadioGroup.OnCheckedChangeListener radGrpSexOnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            ArrayAdapter<String> adapter;
            String entries[];

            if ((RadioButton) findViewById(i) == mRadBtnMale) {                                     //如果選到男
                entries = getResources().getStringArray(R.array.age_Male);                           //紀錄字串
                adapter = new ArrayAdapter<String>(main, android.R.layout.simple_list_item_1, entries); //將字串設定成選單形式
            }
            else {                                                                                  //選到女
                entries = getResources().getStringArray(R.array.age_Female);
                adapter = new ArrayAdapter<String>(main, android.R.layout.simple_list_item_1, entries);
            }

            mSpnAge.setAdapter(adapter);    //將字串給予選單使用
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {   //當按下確定
            String hobbies = getResources().getString(R.string.hobby_result);
            for (CheckBox chkHobby : mlistChkHobbies) {             //掃描興趣選單
                if (chkHobby.isChecked()) {                         //如果是打勾的
                    hobbies += chkHobby.getText().toString() + " "; //輸入興趣列表
                }
            }

            mTxtHobbyResult.setText(hobbies);   //設定興趣字串
        }
    };
}
