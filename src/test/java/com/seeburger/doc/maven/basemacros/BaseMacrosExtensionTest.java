/*
 * created at 2017-08-09 by Bernd Eckenfels <b.eckenfels@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package com.seeburger.doc.maven.basemacros;


import static org.junit.Assert.assertEquals;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.internal.JRubyAsciidoctor;
import org.junit.Test;


public class BaseMacrosExtensionTest
{
    final static String EOL = System.lineSeparator();
    // TODO: additional blank seems to be caused by ((())) indexentry.
    final static String expectedTable1 = "<div class=\"paragraph\">\n" +
                    "<p>test  <code class=\"dbobject\">tTable.cCol</code> test</p>\n" +
                    "</div>";
    final static String expectedTable2 = "<div class=\"paragraph\">\n" +
                    "<p>| <code class=\"dbobject\">tTable</code>|</p>\n" +
                    "</div>";

    Asciidoctor doctor = JRubyAsciidoctor.create();
    Options opts = OptionsBuilder.options().backend("html5").compact(false).get();

    @Test
    public void checkTableWithColumnMacro()
    {
        String content = doctor.render("test table:tTable.cCol[] test", opts);
        assertEquals(expectedTable1, content);
        // TODO: verify index entry?
    }

    @Test
    public void checkTableWithNoColumnMacro()
    {
        String content = doctor.render("|table:tTable[]|", opts);
        assertEquals(expectedTable2, content);
        // TODO: verify index entry?
    }
}



