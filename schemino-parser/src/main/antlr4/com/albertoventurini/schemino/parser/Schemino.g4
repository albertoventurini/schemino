grammar Schemino;

program: expressions EOF;

expressions: expression*;

expression
    : atom
    | quote
    | list
    | block
    ;

quote: '\'' expression;

list: '(' expressions ')';

block: '{' expressions '}';

atom
    : number
    | bool
    | string
    | keyword
    | symbol
    ;

bool: BOOLEAN;

number: LONG;

//keyword: ':' symbol;

string : STRING;

keyword: define | lambda;

define: DEFINE;

lambda: LAMBDA;

symbol: SYMBOL;


// Lexers
//----------------------------------------------------------------

// The 'define' keyword
DEFINE: 'define';

LAMBDA: 'lambda';

// Boolean atoms
BOOLEAN : 'true' | 'false' ;

LONG: '-'? [0-9]+[lL]?;

//SYMBOL : ~('#'|'"'|'\''|[()]|[ \t\r\n]) ~('"'|'\''|[()]|[ \t\r\n])* ;

SYMBOL: SYMBOL_HEAD SYMBOL_REST*;

SYMBOL_HEAD: [a-zA-Z+*/\-=><];

SYMBOL_REST: SYMBOL_HEAD | '0'..'9';

STRING : '"' ( ~'"' | '\\' '"' )* '"';


// Discard
//--------------------------------------------------------------------

COMMENT : ';' .*? '\n' -> skip ;
WS : [ \t\r\n] -> skip ;