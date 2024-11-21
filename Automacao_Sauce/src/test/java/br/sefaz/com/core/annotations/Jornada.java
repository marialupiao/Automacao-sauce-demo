package br.sefaz.com.core.annotations;

import br.sefaz.com.core.contantes.Jornadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Jornada {
		Jornadas value();
}
