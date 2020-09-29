# diagnosisEngine

Technologies:
  1. SpringBoot 2.3.4
  2. Java 11
  3. Maven
  
  
Additional questions answers: 
  1. Decision to use SpringBoot has been made due to it's lightwight, configuration-less environment which allows to develop complex, enterprise WebApplication with      ease. Springboot is well known framework which contains lots of modules, libraries, implements IoC and DI. Moreover it's embedded server reduces boilerplate        configuration to minimum. In case of maven- I've choosen this tool over gradle due to personal preferences and experience.
  2. Implementation of algorithm which is composed from different types elements that has to be connected corretly to get them work together accordingly to              requirements. Overally I find the task very interesting
  3. 
  4. There's quite a bit of iterations over various collections which may be resource-consuming. The algorithm is based on probabilities provided by user so it          suposse to be more strictly determinted to receive genuine results. Perhaps there are more factors to be considered. 
  5. Iterating the diseases to find relevant based on provided sex and then another iteration to filter symptoms possibly may be done as one stage.



Run:
mvn clean spring-boot:run
