# Ecommerce Shopping website

+ To decouple front end and back end developing, used React for front page, Spring Boot for back end and React Native for both Android and iOS app
+ To achieve a better user experience, used React to build single page application, rendered UI by Ant Design, managed data state with Redux; finally, tested react application by Jest and Enzyme
+ To provide both Android and iOS app, chose React Native to build mobile app
+ To handle asynchronous operations, used redux thunk to handle actions; used AsyncStorgae as storage system, and pushed notifications based on Expo API
+ Considering this website may add more function in future, used Spring Boot to build services, provided RESTful APIs for front page and mobile app, tested server with JUnit
+ To improve user experience with payment, integrated order payment system with WeChat pay
+ To have both the advantage of relational and NoSQL database, chose Neo4j to store data; to reduce the response time, use Redis as cache; and enhance repository features by extending global JPA interface
+ To build a Single Sign-On system, integrated Spring Cloud Security with OAuth2 protocol
+ For the purpose of providing high availability and high performance, choice FastFDS to enhance the accessibility of a large-scale distributed system and provided a dynamic scaling file system; used Eureka to discovery service; used Zuul for dynamic routing and Hystrix for fault tolerance and monitoring; docker-compose to manage all services
