grammar Schemino;

program: expressions EOF;

expressions: expression*;

expression
    : atom
    | quote
    | list
    ;

quote: '\'' expression;

list: '(' expressions ')';

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

SYMBOL: [a-zA-Z+*/\-=><]+;

STRING : '"' ( ~'"' | '\\' '"' )* '"';


// Discard
//--------------------------------------------------------------------

COMMENT : ';' .*? '\n' -> skip ;
WS : [ \t\r\n] -> skip ;