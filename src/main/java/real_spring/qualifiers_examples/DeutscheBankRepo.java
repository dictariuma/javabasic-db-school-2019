package real_spring.qualifiers_examples;/**
 * @author Evgeny Borisov
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Qualifier
@Repository
@Autowired
public @interface DeutscheBankRepo {

    DBType value();

}
