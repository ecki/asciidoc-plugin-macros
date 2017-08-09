/*
 * created at 2017-08-09 by Bernd Eckenfels <b.eckenfels@seeburger.de>
 *
 *  Copyright (c) SEEBURGER AG, Germany. All rights reserved.
 */
package com.seeburger.doc.maven.basemacros;


import java.util.HashMap;
import java.util.Map;

import org.asciidoctor.ast.AbstractBlock;
import org.asciidoctor.ast.Inline;
import org.asciidoctor.extension.InlineMacroProcessor;


/**
 * Recognize the {@code table:<TableName>(.<ColumnName>)[]} Inline Macro.
 * <p>
 * This macro is defined to sematically mark database object names. It will
 * make sure they are uniformly formatted (monospaced with {@code class="dbobject"})
 * and it will insert a indexterm for the table name under "Database Tables" primary term.
 */
public class TableMacro extends InlineMacroProcessor
{
    /** Default macro name used by register. */
    static final String TABLE = "table";


    public TableMacro(String macroName, Map<String, Object> config) {
        super(macroName, config);
        //System.out.println("Found macro " + macroName + " conf=" + config);
    }


    @Override
    protected Object process(AbstractBlock parent, String tableName, Map<String, Object> attributes)
    {
        //System.out.println("Macro parent=" + parent.getContext() + " " + parent.getNodeName() + " arg=" + tableName + " att=" + attributes + " : " + attributes.getClass());

        if (tableName == null || tableName.isEmpty())
        {
            throw new RuntimeException("Table macro is missing table name.");
        }

        // TODO: more checks
        if (!tableName.startsWith("t"))
        {
            System.out.println("WARN: table does not start with t but " + tableName);
        }
        if (!Character.isUpperCase(tableName.charAt(1)))
        {
            System.out.println("WARN: table does not start with camel case " + tableName);
        }

        Map<String, Object> options = new HashMap<String, Object>();
        options.put("type", ":monospaced");

        // TODO: do we need to clone the attributes (needs to be a RubyHash)
        // attributes = new HashMap<String,Object>(attributes);
        attributes.put("role", "dbobject");  // class="dbobject"
        // attributes = RubyHashUtil.convertMapToRubyHashWithSymbols(JRubyRuntimeContext.get(), attributes);

        Inline name = createInline(parent, "quoted", tableName, attributes, options);

        // TODO: we should use `indexterm` creation function instead of `(((` syntax
        int pos = tableName.indexOf('.');
        // is a dot specified (i.e. do we have table.column syntax)
        if (pos > -1)
        {
            return " (((\"Database Table\",\"" + tableName.substring(0,pos) + "\",\"" + tableName +"\")))"+name.convert();
        }
        // no dot/column specified
        else
        {
            return " (((\"Database Table\",\"" + tableName + "\")))"+name.convert();
        }
    }
}
