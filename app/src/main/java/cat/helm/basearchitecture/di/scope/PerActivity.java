/*
Created by Helm  25/1/16.
*/


package cat.helm.basearchitecture.di.scope;

import javax.inject.Scope;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}