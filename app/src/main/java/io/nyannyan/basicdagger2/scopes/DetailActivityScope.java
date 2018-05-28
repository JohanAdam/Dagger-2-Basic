package io.nyannyan.basicdagger2.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Replace @Singleton with this @DetailActivityScope will change the module dependency
 * from Application cycle to Activity cycle
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface DetailActivityScope {

}
