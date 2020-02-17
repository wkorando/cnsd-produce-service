# Cloud Native for Spring Developers

This is the code repo to go with the presentation *Cloud Native for Spring Developers*. This code repo and presentation is designed to help introduce Spring developers familiar with "Cloud Native" concepts. 

The slides for the presentation are here: http://ibm.biz/cloud-native-for-spring 

For instructions on how to build and deploy this project go to the workshop repo here: https://github.com/wkorando/spring-boot-cloud-native-workshop

There is also the ongoing blog series *Living on the Cloud* available on IBM Developer here: https://developer.ibm.com/series/living-on-the-cloud/

For questions about this repo you can find me on twitter: [@BillyKorando](https://twitter.com/BillyKorando)

Or email: william [dot] korando [at] ibm [dot] com

## Topics Covered

* Working with Kubernetes
* Building Continuous Delivery Pipelines
* Writing Reliable Automated Integration Tests
* Connecting to Cloud Services
* Extending Spring Boot for Enterprise Needs

## Running the Demo Yourself 

You can build and deploy this demo yourself, to view the steps be sure to checkout the instructions in the workshop. 

## Deploying the Application

Backend Spring Service: [![Deploy to IBM Cloud](https://cloud.ibm.com/devops/setup/deploy/button.png)](https://cloud.ibm.com/devops/setup/deploy?repository=https://github.com/wkorando/cnsd-produce-service&branch=master&env_id=ibm:yp:us-south)

Downstream Spring Service: [![Deploy to IBM Cloud](https://cloud.ibm.com/devops/setup/deploy/button.png)](https://cloud.ibm.com/devops/setup/deploy?repository=https://github.com/wkorando/cnsd-downstream-service&branch=master&env_id=ibm:yp:us-south)
	
Frontend Angular Application: [![Deploy to IBM Cloud](https://cloud.ibm.com/devops/setup/deploy/button.png)](https://cloud.ibm.com/devops/setup/deploy?repository=https://github.com/wkorando/cnsd-produce-client&branch=master&env_id=ibm:yp:us-south)