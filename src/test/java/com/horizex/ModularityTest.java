package com.horizex;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModularityTest {

    @Test
    public void verifyModules() {
        ApplicationModules modules = ApplicationModules.of(HorizexApplication.class);
        modules.forEach(System.out::println);
        modules.verify();
    }

    @Test
    void createDocumentation() {
        ApplicationModules modules = ApplicationModules.of(HorizexApplication.class);
        new Documenter(modules).writeDocumentation();
    }

    @Test
    void writeDocumentationSnippets() {

        var modules = ApplicationModules.of(HorizexApplication.class);

        new Documenter(modules)
                .writeAggregatingDocument()
                .writeModuleCanvases()
                .writeModulesAsPlantUml()
                .writeDocumentation();
    }
}
