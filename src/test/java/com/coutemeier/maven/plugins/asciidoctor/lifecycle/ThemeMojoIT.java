package com.coutemeier.maven.plugins.asciidoctor.lifecycle;

import io.takari.maven.testing.executor.MavenRuntime.MavenRuntimeBuilder;

import org.junit.Assert;
import org.junit.Test;

public class ThemeMojoIT
extends AbstractMojoIT {
    public ThemeMojoIT( final MavenRuntimeBuilder builder )
    throws Exception {
        super( builder );
    }


    @Test
    public void themeExistsTest()
    throws Exception {
        multimoduleForProject()
            .execute( "theme" )
            .assertErrorFreeLog();
        Assert.assertTrue(
            this.subValidator.themeFilesExists()
            && this.subValidator.generatedFilesNotExists()
            && this.subValidator.dependencyNotExists()
        );
    }

    @Test
    public void noThemesConfigured()
    throws Exception {
        forProject( "theme/theme-no-themes-configured" )
            .execute( "theme" )
            .assertErrorFreeLog();
        Assert.assertTrue(
            this.validator.themeFilesNotExists()
            && this.validator.generatedFilesNotExists()
            && this.validator.dependencyNotExists()
        );
    }
}