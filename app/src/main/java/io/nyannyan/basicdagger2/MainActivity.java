package io.nyannyan.basicdagger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.nyannyan.basicdagger2.models.MemberDataManager;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * MemberDataManager < MemberDataModule< MemberDataComponent < MainActivity
 *
 * Activity get MemberDataManager dependency provided by MemberDataModule via MemberDataComponent
 * interface.
 */

public class MainActivity extends AppCompatActivity {

  //@Inject to inject any dependency we want.
  //#1A
  //Used Named annotation to choose dependency provided if there is two same dependency that use same object
  @Inject @Named("local")
  MemberDataManager memberDataManager;

  @Inject @Named ("dd-MMM-yy")
  String dateTimeModule;

  @BindView(R.id.edit_text)
  EditText editText;
  @BindView(R.id.btn_submit)
  Button btnSubmit;
  @BindView(R.id.tv_text)
  TextView tvText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    //get App instance to get the interface
    //#2A
    App.getApp().getMemberAppComponent().inject(this);

    tvText.setText(dateTimeModule);

  }

  @OnClick(R.id.btn_submit)
  public void onClick() {
    if (editText.getText().equals("")) {
      Toast.makeText(MainActivity.this, "Oii Text is empty", Toast.LENGTH_SHORT).show();
    } else {
      String input = editText.getText().toString();
//          String result = new MemberDataManager().checkMemberStatus(input);

      /**
       * Rather than create a new memberDataManager object , we can call
       * memberDataManager reference from where we got the injected dependency (Above)
       */

      //When App runs for the first time, App class take the responsibility to create the module (see #1 in App.class)
      //At the same time they create the dependency.

      //So whenever required, they inject the dependency. So we can use again and again
      //because we use declared it as Singleton.

      //#3A
      String result = memberDataManager.checkMemberStatus(input);
//      Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

      if (result.equals("Access Denied")){
        tvText.setText(result);
      } else {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
      }

    }
  }
}
