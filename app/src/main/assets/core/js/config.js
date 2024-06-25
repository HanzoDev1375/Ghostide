var editor = ace.edit("editor");
editor.setTheme("ace/theme/xcode");
editor.getSession().setMode("ace/mode/javascript");
editor.setHighlightActiveLine(true);
editor.session.setUseWorker(false);
editor.session.setUseWrapMode(false);
document.getElementById('editor').style.fontSize = '16px';
editor.renderer.setShowGutter(true); // Hide/Show lineNumber
editor.setOptions({
    enableBasicAutocompletion: true,
    enableLiveAutocompletion: true,
    autoScrollEditorIntoView: true,
    enableSnippets: true
});

// js interface functions
function $emitCode() {
    AndroidFunction.$emitCode(editor.getValue());
}

function $clearCode() {
    editor.setValue("");
}

function insertVal()
{
   var t = prompt("Paste Text Here");
   appendCode(t);
}

function getCode() {
    AndroidFunction.copyCode(editor.getValue());
}

function appendCode(code) {
    editor.session.insert(editor.getCursorPosition(), code);
}

function undo() {
    editor.undo();
}

function redo() {
    editor.redo();
}

function share() {
    AndroidFunction.shareCode(editor.getValue());
}
