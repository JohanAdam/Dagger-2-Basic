package io.nyannyan.basicdagger2.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import io.nyannyan.basicdagger2.models.NetworkManager;
import io.nyannyan.basicdagger2.models.MemberDataManager;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class MemberDataModule {

  private Context context;

  public MemberDataModule(Context context) {
    this.context = context;
  }

  //Context dependency
  //The context will be provided when this module is created for the first run in App
  @Singleton
  @Provides
  public Context provideContext(){
    return context;
  }

  //Shared Pref Dependency
  //The context will provide above
  @Singleton
  @Provides
  public SharedPreferences provideSharedPreferences(Context context){
    return PreferenceManager.getDefaultSharedPreferences(context);
  }

  //Network Manager Dependency
  @Singleton
  @Provides
  public NetworkManager provideNetworkManager() {
    return new NetworkManager();
  }

  //Tell dagger that this method is a dependency provider
  //It's means, it provides a dependency.
  //The Shared Preferences will be provided above.
  @Singleton
  @Named("local")
  @Provides
  MemberDataManager provideMemberDataManagerLocal(SharedPreferences sharedPreferences) {
    //Pass Sp to MemberDataManager
    return new MemberDataManager(sharedPreferences);
  }

  @Singleton
  @Named("online")
  @Provides
  MemberDataManager provideMemberDataManagerOnline(SharedPreferences sharedPreferences, NetworkManager networkManager) {
    //Pass Sp to MemberDataManager
    return new MemberDataManager(sharedPreferences, networkManager);
  }

}
