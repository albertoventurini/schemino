grammar Schemino;

program: expressions EOF;

expressions: expression*;

expression
    : atom
    | quote
    | list
    ;

quote: '\'' expression;

list: '(' expressions ')' ;

atom
    : number
    | bool
    | keyword
    | symbol
    ;

bool: BOOLEAN;

number: LONG;

//keyword: ':' symbol;

keyword: define;

define: DEFINE;

symbol: SYMBOL;


// Lexers
//----------------------------------------------------------------

// The 'define' keyword
DEFINE: 'define';

// Boolean atoms
BOOLEAN : 'true' | 'false' ;

LONG: '-'? [0-9]+[lL]?;

//SYMBOL : ~('#'|'"'|'\''|[()]|[ \t\r\n]) ~('"'|'\''|[()]|[ \t\r\n])* ;

SYMBOL: [a-zA-Z+*/\-=><]+;


// Discard
//--------------------------------------------------------------------

COMMENT : ';' .*? '\n' -> skip ;
WS : [ \t\r\n] -> skip ;