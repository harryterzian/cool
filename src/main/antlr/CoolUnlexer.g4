grammar CoolUnlexer;
// [Line]:232 (4739:4739) [Text]:{ [Type]:O_CURLY [Type ID]:26
start: lines+;
lines: line SEPARATOR content SEPARATOR type SEPARATOR typeID;

line: LINE_LABEL linenumber=characters O_BRACKET start_index=characters SEMI_COLON end_index=characters C_BRACKET;
content: CONTENT_LABEL (text=characters);
type: TYPE_LABEL type_text=characters;
typeID: TYPE_ID_LABEL type_id=characters;
characters: (ANYTHING | O_BRACKET | C_BRACKET | SEMI_COLON | SEPARATOR)+?;

LINE_LABEL: '[Line]:';
CONTENT_LABEL: '[Text]:';
TYPE_LABEL: '[Type]:';
TYPE_ID_LABEL: '[Type ID]:';
O_BRACKET: '(';
C_BRACKET: ')';
SEMI_COLON: ':';
SEPARATOR: ' ';
ANYTHING: .;
