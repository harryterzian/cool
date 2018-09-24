// We need a lexer grammar to use channels (WHITESPACE) and lexer modes.
lexer grammar CoolLexer;

channels { WHITESPACE, COMMENT_CHANNEL}

// Lexer
// Tasks left:
// 1. Case insensitive keywords
// 2. Special cases such as escape characters

COMMENT: '--' ~('\n' | '\r')* -> channel(COMMENT_CHANNEL);
WS: [\t\r\n\f\u000B ]+ -> channel(WHITESPACE);
INTEGER: [0-9]+;

BLOCK_COMMENT: '(*'
               (~[()*]+ | BLOCK_COMMENT | '*' | ')' | '(')*? '*)';

// Keywords
// All keywords are case-insensitive apart from
// true and false which are object identifiers
CLASS: 'class';
ELSE: 'else';
FI: 'fi';
IF: 'if';
IN: 'in';
INHERITS: 'inherits';
ISVOID: 'isvoid';
LET: 'let';
LOOP: 'loop';
POOL: 'pool';
THEN: 'then';
WHILE: 'while';
CASE: 'case';
ESAC: 'esac';
NEW: 'new';
OF: 'of';
NOT: 'not';
TYPE_OF: ':';
COMMA: ',';
SEMICOLON: ';';
ASSIGN: '<-';
CASE_ARROW: '=>';
O_CURLY: '{';
C_CURLY: '}';

// Arithmetic
PLUS: '+';
STAR: '*';
MINUS: '-';
DIVIDE: '/';
COMPLEMENT: '~';
O_BRACKET: '(';
C_BRACKET: ')';
EQUALS: '=';
LESS_THAN: '<';
LESS_THAN_EQUALS: '<=';
GREATER_THAN_EUALS: '>=';

// True and false should start with a lower case
// but can follow with anything they want.
TRUE: 'true';
FALSE: 'false';

// Type identifiers begin with a capital letter;
TYPE_IDENTIFIER: [A-Z] IDENTIFIER_FRAGMENT;
// Object identifiers begin with a lower case letter.
OBJECT_IDENTIFIER: [a-z] IDENTIFIER_FRAGMENT;
// There are two other identifiers, self and SELF_TYPE that are treated
// specially by coolc.Coolc but are not treated as keywords
fragment IDENTIFIER_FRAGMENT: [0-9a-zA-Z_]+ ;

// Valid escape sequences are:
// \b backspace
// \t tab
// \n newline
// \f formfeed
// Everything else turns into a character with the exception of \0 which is dissallowed.
STRING: '"' (~["\n\r]|('\\'.))* '"';
UNMATCHED: .;
