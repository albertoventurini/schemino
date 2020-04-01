grammar Schemino;

//@header {
//package com.albertoventurini.schemino.parser;
//}

file: form* EOF;

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