grammar Schemino;

program: statements EOF;

statements: statement*;

statement: assignment | expression;

expressions: expression*;

expression
    : atom
    | list
    | functionCall
    | block
    | arrowFunction
    ;

assignment: symbol ':' expression;

arrowFunction: tailrec? list '=>' expression;

tailrec: TAILREC;

list: '[' expressions ']';

functionCall: '(' expression+ ')';

block: '{' statements '}';

atom
    : number
    | bool
    | string
    | keyword
    | symbol
    | operator
    ;

bool: BOOLEAN;

number: LONG;

string : STRING;

keyword: define | lambda;

define: DEFINE;

lambda: LAMBDA;

symbol: SYMBOL;

operator: EQUALS;

// Lexers
//----------------------------------------------------------------

// The 'define' keyword
DEFINE: 'define';

LAMBDA: 'lambda';

// Boolean atoms
BOOLEAN : 'true' | 'false' ;

LONG: '-'? [0-9]+[lL]?;

SYMBOL: SYMBOL_HEAD SYMBOL_REST*;

SYMBOL_HEAD: [a-zA-Z+*/\-><];

SYMBOL_REST: SYMBOL_HEAD | '0'..'9';

STRING : '"' ( ~'"' | '\\' '"' )* '"';

EQUALS: '==';

TAILREC: '@tailrec';

// Discard
//--------------------------------------------------------------------

COMMENT : ';' .*? '\n' -> skip ;
WS : [ \t\r\n] -> skip ;