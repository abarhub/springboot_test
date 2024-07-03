package org.testspringboot3.springboot_test.webapp.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

public class ArchTest {

    @Test
    public void test1() {
        JavaClasses jc = new ClassFileImporter().importPackages("org.testspringboot3.springboot_test");

        //        ArchRule r1 = classes()
        //                .that().resideInAPackage("..rest..")
        //                .should().onlyDependOnClassesThat()
        //                .resideInAPackage("..service..");
        //        r1.check(jc);

        ArchRule r2 = noClasses()
                .that()
                .resideInAPackage("..rest..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..service..");
        //                .resideInAPackage("..config..");
        r2.check(jc);
    }

    @Test
    public void test2() {
        JavaClasses jc = new ClassFileImporter().importPackages("org.testspringboot3.springboot_test");

        //        ArchRule r1 = classes()
        //                .that().resideInAPackage("..rest..")
        //                .should().onlyDependOnClassesThat()
        //                .resideInAPackage("..service..");
        //        r1.check(jc);

        ArchRule r2 = noClasses()
                .that()
                .resideInAPackage("..service..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..internal..");
        //                .resideInAPackage("..config..");
        r2.check(jc);
    }
}
