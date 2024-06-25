	    var allTabs = {
	       codeEditor : 'code',
		   console    : 'console'
	   };
	   var codeCtrl = {
	     'run'       : function() { eruda._devTools._tools.code.run(); gotoTab(allTabs.console); },
		 'copy'      : function() { eruda._devTools._tools.code.copy(); },
		 'clear'     : function() { eruda._devTools._tools.code.clear(); },
		 'beautify'  : function() { eruda._devTools._tools.code.beautify(); },
	   };

	   function backToConsole()
       {
       	      eruda._showListener("code");
       }
	   
	   var showInConsole = function(val)
	   {
	       setEditorValue(val);
	       codeCtrl.run();
	   }
	   
	   function cons(code)
	   {
	       try
		   {
		       eruda._devTools._tools.console.log(eval(`${code}`));
		   }
		   catch(e)
		   {
		      eruda._devTools._tools.console.error(e);
		   }
	   }
	   
        eruda.init({
		   tool: ['console', 'network', 'resources']
		   });
	   
	   eruda.add(erudaCode);
	   let console = eruda.get('console');
       console.config.set('catchGlobalErr', true);
	   eruda._entryBtn.hide();
	   eruda._$el.find(".eruda-dev-tools").css({height: '100%'});
	   eruda._$el.find(".eruda-icon-info").css({display: 'none'});
	   eruda._$el.find(".eruda-nav-bar-item").css({
	   fontWeight: 'bold',
	   height: '20px',
	   lineHeight: '20px'
	   });
	   eruda._$el.find(".eruda-nav-bar").css('display', 'none');
       eruda._$el.find(".eruda-bottom-bar").css('display', 'none');
       eruda._$el.find(".eruda-tool").css('padding-bottom', '8px');
	   eruda._$el.find(".eruda-dev-tools").css('padding-top', '0');
	   eruda._$el.find(".eruda-run").css('color', '#090');
	   eruda._$el.find(".eruda-clear").css('color', '#ff3300');
	   
	   gotoTab(allTabs.codeEditor);
	   eruda._devTools._navBar.remove('settings');
	   eruda.show();
	   
	   // eruda._devTools._tools.code._editor.getValue()
	   function gotoTab(tabName)
	   {
			eruda._showListener(tabName);
	   }
	   
	   function getEditorValue()
	   {
		  return eruda._devTools._tools.code._editor.getValue();
	   }
	   
	   function setEditorValue(code)
	   {
		  return eruda._devTools._tools.code._editor.setValue(code);
	   }
	   // eruda._devTools._tools.console.clear()