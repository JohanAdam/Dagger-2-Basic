package io.nyannyan.basicdagger2;

import android.app.Application;
import io.nyannyan.basicdagger2.components.DaggerMemberAppComponent;
import io.nyannyan.basicdagger2.components.MemberAppComponent;
import io.nyannyan.basicdagger2.modules.DateTimeModule;
import io.nyannyan.basicdagger2.modules.MemberDataModule;

public class App extends Application {

  //To use this App class from other classes, we need to create a static
  //reference variable here
  private static App app;
  //References to the interface
  private MemberAppComponent memberAppComponent;
//  private DetailActivityComponent detailActivityComponent;

  public static App getApp() {
    return app;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    //onCreate assign the current instance to app
    app = this;

    /**
     * #1
     * Dagger will generates code for us, we need to defined an interface called MemberAppComponent
     *
     * So, dagger will generates a class named DaggerMemberAppComponent
     * in front of the interface name we defined
     */

    //Basically App will take responsibility to create the module and dependency at
    //the same time to be ready to use in other activity.

    //To use, the activity just need to inject the object (see #1A in MainActivity) he want to use
    //and get app instance to create module and dependency (see #2A in MainActivity),
    //and boom use it (see #3A in MainActivity).

    //If there is not public constructor in the modules, its not compulsory to add the module here.
    memberAppComponent = DaggerMemberAppComponent.builder()
        .memberDataModule(new MemberDataModule(getApplicationContext()))
        .dateTimeModule(new DateTimeModule())
//        .messagesModule(new MessagesModule())
        .build();

    //Intialized other component (With activity scope)
//    detailActivityComponent = DaggerDetailActivityComponent.builder()
//        .memberAppComponent(memberAppComponent) //Define parent component
//        .messagesModule(new MessagesModule())
//        .build();

  }

  //From MainActivity > get instance of the application > get interface by using the instance
  public MemberAppComponent getMemberAppComponent() {
    return memberAppComponent;
  }

//  public DetailActivityComponent getDetailActivityComponent() {
//    return detailActivityComponent;
//  }
}
