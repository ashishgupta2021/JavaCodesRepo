Scope Annotation with singleton and prototype

Run the application as Java Application while selecting BeanScopeApp.java file.

Output

@Scope: (When run with @Scope)

Pointing to the same object: true

 Memory location of theCoach: com.web.tut09.beanscopeannotation.TennisCoach@5e7cd6cc

 Memory location of otherCoach: com.web.tut09.beanscopeannotation.TennisCoach@5e7cd6cc
 

@Scope("prototype"): When run with @Scope("prototype")

Pointing to the same object: false

 Memory location of theCoach: com.web.tut09.beanscopeannotation.TennisCoach@5e7cd6cc

 Memory location of otherCoach: com.web.tut09.beanscopeannotation.TennisCoach@68c9d179


