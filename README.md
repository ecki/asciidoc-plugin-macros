# asciidoc-plugin-macros

This project produces a maven plugin dependency which is automatically detected by AsciidoctorJ
to introduce some semantic macros.

## Macros

`table:<table>(.<column>)[]` - mark occurence of a well known table (and column) name

## Usage

Add the following dependency to the Asciidoctor plugin.

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <asciidoctor.maven.plugin.version>1.5.3</asciidoctor.maven.plugin.version>
        <asciidoctorj.version>1.5.6</asciidoctorj.version>
        <asciidoctorj.pdf.version>1.5.0-alpha.15</asciidoctorj.pdf.version>
        <jruby.version>9.1.8.0</jruby.version> <!-- 1.7.25 -->
    </properties>

    <build>
        <defaultGoal>process-resources</defaultGoal>
        <plugins>
            <plugin>
                <groupId>org.asciidoctor</groupId>
                <artifactId>asciidoctor-maven-plugin</artifactId>
                <version>${asciidoctor.maven.plugin.version}</version>
                <dependencies>
                    <dependency>
                        <groupId>org.jruby</groupId>
                        <artifactId>jruby-complete</artifactId>
                        <version>${jruby.version}</version>
                    </dependency>
                    <dependency>
                        <groupId>org.asciidoctor</groupId>
                        <artifactId>asciidoctorj</artifactId>
                        <version>${asciidoctorj.version}</version>
                    </dependency>
                    <dependency>
                        <groupId>org.asciidoctor</groupId>
                        <artifactId>asciidoctorj-pdf</artifactId>
                        <version>${asciidoctorj.pdf.version}</version>
                    </dependency>
                    <dependency>
                        <groupId>com.seeburger.doc.maven</groupId>
                        <artifactId>asciidoc-plugin-macros</artifactId>
                        <version>1.0.0-SNAPSHOT</version>
                    </dependency>
                </dependencies>
                <configuration>
                    ...

Tested with `html5` and `asciidoctor-pdf` backends.

## Copyright and License

The source is &copy; Copyright 2017, SEEBURGER AG, Germany.

It is licensed to you AS-IS under the terms of the [Apache License Version 2.0](https://www.apache.org/licenses/LICENSE-2.0).