package io.nyannyan.basicdagger2.components;

import dagger.Subcomponent;
import io.nyannyan.basicdagger2.DetailActivity;
import io.nyannyan.basicdagger2.models.MessageGenerator;
import io.nyannyan.basicdagger2.modules.MessagesModule;
import io.nyannyan.basicdagger2.scopes.DetailActivityScope;

//Replace this our custom scope instead of Singleton
//Activity lifecycle > Application lifecycle
@DetailActivityScope
//@Component (dependencies = MemberAppComponent.class, modules = MessagesModule.class)
//Child of MemberAppComponent , will inherit all from MemberAppComponent kinda~ (Component Dependency)

@Subcomponent(modules = MessagesModule.class)
//(Subcomponents) no need to define parent component ,
public interface DetailActivityComponent {

  void inject(DetailActivity detailActivity);

  MessageGenerator messageGenerator();

}
