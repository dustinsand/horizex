package com.horizex.hireme;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModularityTest {

    @Test
    public void applicationModules() {
        ApplicationModules modules = ApplicationModules.of(HiremeApplication.class);
        modules.forEach(System.out::println);
        modules.verify();
    }

    @Test
    void createDocumentation() {
        ApplicationModules modules = ApplicationModules.of(HiremeApplication.class);
        new Documenter(modules).writeDocumentation();
    }

    @Test
    void writeDocumentationSnippets() {

        var modules = ApplicationModules.of(HiremeApplication.class).verify();

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }
}
