package console.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Component - will not initialize BEAN
public class Config {
    @Bean
    public Foo createFoo() {
        Foo foo = new Foo();
        System.out.println(foo.value); // Prints null - foo not initialized yet
        return foo;
    }

    @Bean
    public Bar createBar() {
        Foo foo = createFoo();
        Foo foo2 = createFoo(); //WILL NOT CALL JAVBA METHOD - because it is bean
        System.out.println(foo.value); // Prints Hello, world! - foo have been initialized by the interceptor
        return new Bar(foo);
    }
}
