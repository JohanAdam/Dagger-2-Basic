package io.nyannyan.basicdagger2.components;

import dagger.Component;
import io.nyannyan.basicdagger2.DetailActivity;
import io.nyannyan.basicdagger2.modules.MessagesModule;
import io.nyannyan.basicdagger2.scopes.DetailActivityScope;

//Replace this our custom scope instead of Singleton
//Activity lifecycle > Application lifecycle
@DetailActivityScope
@Component (dependencies = MemberAppComponent.class, modules = MessagesModule.class)
//Child of MemberAppComponent , will inherit all from MemberAppComponent kinda~
public interface DetailActivityComponent {

  void inject(DetailActivity detailActivity);

}
