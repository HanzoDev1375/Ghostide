/* global document, editor */
var css, style_text, style, shortcut_bar, shortKey, shortcuts;
css = "::-webkit-scrollbar{-webkit-appearance: none;}::-webkit-scrollbar:horizontal{height: 0px;}.toolbar{-webkit-touch-callout: none; -webkit-user-select: none; -khtml-user-select: none; -moz-user-select: none;-ms-user-select: none;user-select: none;z-index:999999;margin:0;padding:0;display:flex; overflow-x: auto; position: fixed;left:0;right:0;bottom:0;width:100%;background:#fcfcfc;}key{-webkit-appearance:none;display:inline;padding: 8px 14px;font-family: 'monospace', serif;color:#727272;font-size:20px; font-weight: normal;-webkit-font-smoothing: antialiased; font-smoothing: antialiased;}";
// style of this element
style_text = document.createTextNode(css);
style = document.createElement('style');
tool_bar = document.createElement('toolbar');
// css properties
style.setAttribute('id', 'shortcut');
style.appendChild(style_text);
document.head.appendChild(style);
shortcuts = [
    '$',
    '%',
    '`',
    '~',
    '<',
    '>',
    '<=',
    '>=',
    '!=',
    '/',
    '"',
    "'",
    '\\',
    '@',
    ':',
    '+',
    '=',
    '|',
    '&',
    '(',
    ')',
    '{',
    '}',
    '?',
    '!',
    ';',
    ',',
    '[',
    ']',
    '-',
    '_'
];
/* Constractor */
var AddKey = function(btn) {
        'use strict'
        this.btn = btn;
        shortKey = document.createElement('key');
        shortKey.innerHTML = btn;
        shortKey.addEventListener('click', function(e) {
            e.preventDefault();
            if (this.textContent == '{') {
                editor.session.insert(editor.getCursorPosition(), '{}');
            } else if (this.textContent == '(') {
                editor.session.insert(editor.getCursorPosition(), '()');
            } else {
                editor.session.insert(editor.getCursorPosition(), this.textContent);
            }
            editor.focus();
        })
        return shortKey;
    }
    // tool_bar properties
var i
for (i = 0; i <= shortcuts.length - 1; i = i + 1) {
    tool_bar.appendChild(new AddKey(shortcuts[i]));
}
tool_bar.classList.add('toolbar'); // add style to btn key
document.body.appendChild(tool_bar);
document.getElementById('editor').style.bottom = tool_bar.offsetHeight + 'px';

// js interface functions
function showCodeResult() {
    AndroidFunction.showCodeResult(editor.getValue());
}

(function getCodeText()
{
    AndroidFunction.getTextOfCode(editor.getValue());
})();

function undo() {
    editor.undo();
}

function redo() {
    editor.redo();
}

function share() {
    AndroidFunction.shareCode(editor.getValue());
}