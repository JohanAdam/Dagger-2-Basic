package io.nyannyan.basicdagger2;

import dagger.Component;
import javax.inject.Singleton;

/**
 * In component, we have to define every modules
 * which we going to use through this interface.
 */
//Add all the modules here
@Singleton
@Component (modules = {MemberDataModule.class,DateTimeModule.class})
public interface MemberAppComponent {

  //Define all activity, fragment that going to inject these dependency.
    void inject(MainActivity mainActivity);

}
