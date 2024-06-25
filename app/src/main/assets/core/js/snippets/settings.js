
// // var currentSettings; 
// // if(!localStorage.getItem('ss') == null)
// // {
// //     currentSettings = localStorage.getItem('ss').split(',');
// // }
// // else {
// //     currentSettings =  [ "false", "true", "true", "15" ];
// // }


// var defaultSettings = {
// 	enableWrapMode: false,
// 	enableLineNumber:true,
// 	enableAutocompletion: true,
// 	fontSize: 16
// };

// // var updateDefaultSettings = function(arr) {
// // 	defaultSettings.enableWrapMode = currentSettings[0] == 'true',
// // 	defaultSettings.enableLineNumber = currentSettings[1] == 'true',
// // 	defaultSettings.enableAutocompletion = currentSettings[2] == 'true',
// // 	defaultSettings.fontSize = currentSettings[3]
// // };


// // init editor
// var editor = ace.edit('editor');
// editor.setTheme('ace/theme/xcode');
// editor.getSession().setMode('ace/mode/javascript');
// editor.setHighlightActiveLine(false);
// editor.session.setUseWorker(false);
// setUpSettings(defaultSettings);

// function setUpSettings(settings) {
// 	editor.session.setUseWrapMode(settings.enableWrapMode);
// 	editor.setFontSize(settings.fontSize);
// 	editor.renderer.setShowGutter(settings.enableLineNumber); // hide/show lineNumber
// 	editor.setOptions({
// 		enableBasicAutocompletion: settings.enableAutocompletion,
// 		enableLiveAutocompletion: settings.enableAutocompletion,
// 		autoScrollEditorIntoView: true
// 		//enableSnippets: true
// 	});
// }

// // const settingsUi = () => {
// // 	const sui = document.createElement('div');

// // 	sui.classList.add('popupScreenCss');

// // 	const settingPopup = `
// //     <div class="popupCss">

// //      <div class="popupHeader">
// //       Settings
// //      </div>

// //      <div class="popupBody">

// //        <div class="itemCss">
// //          <div class="itemTextCss">enable WrapMode</div>
// //          <div class="itemOptionCss">
// //            <input type="checkbox" id="wrapMode"/>
// //          </div>
// //        </div>

// //        <div class="itemCss">
// //          <div class="itemTextCss">enable LineNumber</div>
// //          <div class="itemOptionCss">
// //            <input type="checkbox" id="lineNumber"/>
// //          </div>
// //        </div>

// //        <div class="itemCss">
// //          <div class="itemTextCss">enable Autocompletion</div>
// //          <div class="itemOptionCss">
// //            <input type="checkbox" id="autocompletion"/>
// //          </div>
// //        </div>

// //        <div class="itemCss">
// //          <div class="itemTextCss">Font Size</div>
// //          <div class="itemOptionCss">
// //            <span contentEditable="true" id="fontSize">edit</span>
// //          </div>
// //        </div>
// //      </div>

// //      <div class="popupFooter">
// //        <button id="cancel">Cancel</button>
// //        <button id="save">Save</button>
// //      </div>

// //     </div>
// //   `;

// // 	sui.innerHTML = settingPopup;
// //     document.body.appendChild(sui);
// // };
// // function openSettings() {
// //     settingsUi();
// //     document.querySelector('#wrapMode').checked = editor.getSession().$useWrapMode;
// // 	document.querySelector('#lineNumber').checked = editor.renderer.$showGutter;
// // 	document.querySelector('#autocompletion').checked = editor.getOptions().enableBasicAutocompletion;
// // 	document.querySelector('#fontSize').innerText = editor.getFontSize();
// // }

// // // ui variables
// // var popupScreen = document.querySelector('.popupScreenCss');
// // var save = document.querySelector('#save');
// // var cancel = document.querySelector('#cancel');

// // // settings variables
// // var wrapMode = document.querySelector('#wrapMode');
// // var lineNumber = document.querySelector('#lineNumber');
// // var autocompletion = document.querySelector('#autocompletion');
// // var fontSize = document.querySelector('#fontSize');

// // // settings button event
// // cancel.addEventListener('click', () => {
// // 	popupScreen.remove();
// // });

// // save.addEventListener('click', () => {
// // 	setNewSettings();
// // });

// // // settings functions
// // function getSettingsFromUi() {
// // 	return new Object({
// // 		enableWrapMode: wrapMode.checked,
// // 		enableLineNumber: lineNumber.checked,
// // 		enableAutocompletion: autocompletion.checked,
// // 		fontSize: fontSize.value > 18 ? 18 : fontSize.value
// // 	});
// // }

// // function setNewSettings() {
// // 	var arr = [];
// // 	for (var s in getSettingsFromUi()) {
// // 		arr.push(getSettingsFromUi()[s]);
// //     }
// //     alert(arr);
// // 	localStorage.setItem('ss', JSON.stringify(arr));

// // 	console.log('no update ===>', defaultSettings);
// //     updateDefaultSettings(localStorage.getItem('ss').split(','));
// // 	console.log('updated ===>',defaultSettings);

// // 	setUpSettings(defaultSettings);
// // 	popupScreen.remove();
// // }
