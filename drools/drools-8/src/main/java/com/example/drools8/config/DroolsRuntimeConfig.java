package com.example.drools8.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DroolsRuntimeConfig {

    @Bean
    public KieContainer kieContainer() throws IOException {
//        KieServices kieServices = KieServices.Factory.get();
//        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/discount.drl"));
//
//        ReleaseId releaseId = kieServices.newReleaseId("org.example", "drools-8-project", "1.0-SNAPSHOT");
//        kieFileSystem.generateAndWritePomXML(releaseId);
//        kieServices.newKieBuilder(kieFileSystem).buildAll(ExecutableModelProject.class);
//        return kieServices.newKieContainer(releaseId);

        KieServices kieServices = KieServices.Factory.get();
        return kieServices.newKieClasspathContainer();

//        KieServices kieServices = KieServices.Factory.get();
//        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//
//        Resource kModuleXML = ResourceFactory.newClassPathResource("META-INF/kmodule.xml");
//        kieFileSystem.writeKModuleXML(kModuleXML.getInputStream().readAllBytes());
//        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/discount.drl"));
//        kieServices.newKieBuilder(kieFileSystem).buildAll(ExecutableModelProject.class);
//
//        return kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
    }


    @Bean
    public KieSession kieSession() throws IOException {
        return kieContainer().newKieSession();
    }
}
