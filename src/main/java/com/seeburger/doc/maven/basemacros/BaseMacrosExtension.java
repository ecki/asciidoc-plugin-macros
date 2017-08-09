/*
 * created at 2017-08-09 by Bernd Eckenfels <b.eckenfels@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All rights reserved.
 */
package com.seeburger.doc.maven.basemacros;


import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.spi.ExtensionRegistry;


/**
 * Register the extensions contained in this package.
 * <p>
 * <ul>
 * <li> Inline Macro: {@code table}
 * </ul>
 */
public class BaseMacrosExtension implements ExtensionRegistry
{
    public void register(Asciidoctor asciidoctor)
    {
        JavaExtensionRegistry javaExtensionRegistry = asciidoctor.javaExtensionRegistry();
        javaExtensionRegistry.inlineMacro(TableMacro.TABLE, TableMacro.class);
    }
}
