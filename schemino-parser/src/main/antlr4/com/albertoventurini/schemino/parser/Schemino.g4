grammar Schemino;

program: form* EOF;

form
    : literal
    | list
    ;

list: '(' form* ')' ;

literal
    : number
    | BOOLEAN
    | keyword
    | symbol
    ;

number
    : LONG
    ;

keyword: ':' symbol;

symbol: SYMBOL;


// Lexers
//----------------------------------------------------------------


LONG: '-'? [0-9]+[lL]?;

SYMBOL : ~('#'|'"'|'\''|[()]|[ \t\r\n]) ~('"'|'\''|[()]|[ \t\r\n])* ;

BOOLEAN : 'true' | 'false' ;

// Discard
//--------------------------------------------------------------------

COMMENT : ';' .*? '\n' -> skip ;
WS : [ \t\r\n] -> skip ;