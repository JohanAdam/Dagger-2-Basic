package io.nyannyan.basicdagger2.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.nyannyan.basicdagger2.models.MessageGenerator;
import io.nyannyan.basicdagger2.scopes.DetailActivityScope;

@Module
public class MessagesModule {

  private Context context;

  @DetailActivityScope
  @Provides
  MessageGenerator provideMessageGenerator(){
    return new MessageGenerator();
  }

}
