# Mapping-kata

## Things to know
This section contains things you should know while building a similar app or using JPA in general. Obviously this section is nowhere near being complete, treat it more like a scratchpad that illustrates the mind of developer.


1. Don't use `@Inheritance` ad with ``PersonalizedEntity`` here. The superclass is here only to implement JPA-related fields (id), not to model any sort of OOP design. `@MappedSuperclass` is preferred.
```@MappedSuperclass
// Don't use @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) here.
// @Inheritance is to be used for modelling the OOP aspects of domain
// @MappedSupperclass is for adding base class persistent properties as if they were declared in them directly
public abstract class PersonalizedEntity {
```

2. If you will `implements CommandLineRunner` SpringBoot allows you to implement the `run` method. You can put code that you want to execute without corrupting the main method.

```
public class SimpleMappingKataApplication implements CommandLineRunner {

    @Override
    public void run(final String... strings) throws Exception {
        // put code here...
    }
```

3. 
