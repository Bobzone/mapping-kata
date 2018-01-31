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

3. Ran into some dependency issues during development:
```
Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: 
Error creating bean with name 'simpleMappingKataApplication': Unsatisfied dependency expressed through constructor parameter 0; 
nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'contactService' 
defined in file [C:\Users\epiobob\Documents\Dev\simple-mapping-kata\target\classes\com\bobzone\training\service\ContactService.class]:
Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: 
No qualifying bean of type 'com.bobzone.training.repo.ContactRepository' available: expected at least 1 bean which qualifies as autowire candidate. 
Dependency annotations: {}
```
3a. Resolved with adding @Repository to ContactRepositoryImpl (could have used `@Component` as well):
```
@Repository
public class ContactRepositoryImpl extends AbstractRepositoryImpl<Contact> implements ContactRepository {
```

4. Another exception that happened during development:
```
Not allowed to create transaction on shared EntityManager - use Spring transactions or EJB CMT instead; 
```

4a. Given the code in `AbstractRepositoryImpl`:
```
public T merge(final T obj) {
        try {
            em.getTransaction().begin();
            T merged = em.merge(obj);
            em.getTransaction().commit();
            return merged;
        } finally {
            em.close();
        }
    }
```
SpringBoot complains that you want to manually manage the `TransactionManager` without having additional Config classes. Dead simple fix is to use the `@Transactional` adnotation instead:
```
    @Transactional
    public T merge(final T obj) {
        return em.merge(obj);
    }
```

5. Im looking in my h2 db and it seems there is no relation between entities! WTF IS GOING ON?

```
        // Those will be persisted, but the foreign key will appear as null
        Contact contact1 = new Contact("Obi-Wan", "Kenobi", "O'Connell Street Lower, Dublin");
        contact1.getPhoneList().add(new Phone("555-055-055"));

        Contact contact2 = new Contact("Qui-gon", "Jin", "Pembroke Cottages, London");
        contact2.getPhoneList().add(new Phone("333-333-333"));

        Contact contact3 = new Contact("Darth", "Maul", "56 Goldbrook sq, Wellington");
        contact3.getPhoneList().add(new Phone("666-666-666"));

        // This solves the problem of null in database
        final Phone phone1 = new Phone("066-66-66");
        contact3.getPhoneList().add(phone1);
        phone1.setContact(contact3);
```
You have to manually take care of the mapping if you have a bi-directional relation.

## Things to look into in future
1. Usage of `@Repository` adnotation in classes in the project. It is possible that there are no redundant adnotations right now, but it is a detail to look into.