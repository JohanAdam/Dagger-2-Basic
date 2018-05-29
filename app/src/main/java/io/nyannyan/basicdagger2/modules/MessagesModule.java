package io.nyannyan.basicdagger2.modules;

import dagger.Module;
import dagger.Provides;
import io.nyannyan.basicdagger2.models.MessageGenerator;
import io.nyannyan.basicdagger2.scopes.DetailActivityScope;

@Module
public class MessagesModule {

  @DetailActivityScope
  @Provides
  public MessageGenerator provideMessageGenerator(){
    return new MessageGenerator();
  }

}
