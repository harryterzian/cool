parser grammar CoolParser;
options { tokenVocab=CoolLexer; }

start: program;
program: (cool_class SEMICOLON)*;
cool_class: CLASS TYPE_IDENTIFIER (INHERITS TYPE_IDENTIFIER)?
            O_CURLY
               (feature SEMICOLON)*
            C_CURLY;

feature: (OBJECT_IDENTIFIER
          O_BRACKET (formal (COMMA formal)*)? C_BRACKET TYPE_OF TYPE_IDENTIFIER
          O_CURLY
          expr
          C_CURLY)
         |(OBJECT_IDENTIFIER TYPE_OF TYPE_IDENTIFIER (ASSIGN expr)?);

formal: OBJECT_IDENTIFIER TYPE_OF TYPE_IDENTIFIER;
expr: WS;

