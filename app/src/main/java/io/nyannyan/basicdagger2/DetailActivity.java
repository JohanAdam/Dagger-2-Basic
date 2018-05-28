package io.nyannyan.basicdagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.nyannyan.basicdagger2.models.MessageGenerator;
import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity {

  @Inject
  MessageGenerator messageGenerator;

  @BindView(R.id.tv_Welcome)
  TextView tvWelcome;
  @BindView(R.id.tv_Message)
  TextView tvMessage;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    ButterKnife.bind(this);

    App.getApp().getDetailActivityComponent().inject(this);

    tvWelcome.setText(getIntent().getStringExtra("result"));

    tvMessage.setText(messageGenerator.getWelcomeMessage());

  }
}
