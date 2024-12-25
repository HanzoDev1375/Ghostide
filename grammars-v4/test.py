print(print)

import os
packs = os.listdir("/data/user/0/ir.ninjacoder.ghostide/files/files/usr/lib/python3.11/site-packages")
if not "termcolor" in packs or not "colorama" in packs or not "prompt_toolkit" in packs or not "git":
    os.system("libpython3.so -m pip install --trusted-host https://pypi.tuna.tsinghua.edu.cn -i https://pypi.tuna.tsinghua.edu.cn/simple/ prompt_toolkit colorama termcolor gitpython")
import getpass
import json
import sys
import time
import string
from prompt_toolkit import prompt
from prompt_toolkit.completion import Completer, Completion
from typing import Callable
from prompt_toolkit.document import Document
from prompt_toolkit.formatted_text.base import StyleAndTextTuples
import prompt_toolkit.lexers
import re
import subprocess
##import git

def makeBanner():
    try:
        from termcolor import colored
        from colorama import init, Fore, Style
       ## import git

        init(autoreset=True)
    except ImportError or ModuleNotFoundError:
        print("در حال نصب کتابخانه‌ها... ⏳")
        subprocess.run(['libpython3.so', '-m', 'pip', 'install', 'termcolor', 'colorama','git'])

    a = """
⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀
⠀⠀⢀⣠⣶⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣶⣠⡀⠀⠀
⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀
⠀⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠈⠛⣿⣿⣿⣿⣿⣿⣯⡀
⠀⣿⣿⣿⣿⣿⣿⠁⠀⢠⣶⡄⢀⣶⣄⠀ ⣿⣿⣿⣿⣿⣿⡇
 ⣿⣿⣿⣿⣿⡇⡆⠀⠸⣿⠃⠘⢿⠏⠀⠀⢸⣿⣿⣿⣿⣿⡆
 ⣿⣿⣿⣿⣿⡇⡇⠀⠡⣄⡀⢀⣀⠄⠀⠀⢸⣿⣿⣿⣿⣿⡇
 ⣿⣿⣿⣿⣿⡇⠇⠀⠀⠈⠛⠛⠉⠀⠀⠀⢸⣿⣿⣿⣿⣿⡇
⠀⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⡀
⠀⣿⣿⣿⣿⣏⣤⣤⣄⠀⠀⢀⡀⠀⠀⣠⣤⣤⣹⣿⣿⣿⣿⠀
⠀⠘⢿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⠃⠀
⠀⠀⠈⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠁⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀
    """
    b = """
Ghost web 
appversion 1.6.1
dev Ninja coder 
pythonversion 3.11.1
    """

    colored_text = (
        f"{Fore.RED}{Style.BRIGHT}{b[:10]}"
        f"{Fore.GREEN}{Style.BRIGHT}{b[10:29]}"
        f"{Fore.BLUE}{Style.BRIGHT}{b[29:45]}"
        f"{Fore.YELLOW}{Style.BRIGHT}{b[45:]}"
    )

    text = a

    colors = ['cyan','magenta']

    for i, char in enumerate(text):
        color = colors[i % len(colors)]
        colored_char = colored(char, color,attrs=['bold'])
        print(colored_char, end='')
    print(colored_text)


class CustomRegexLexer(prompt_toolkit.lexers.Lexer):
    def __init__(self, regex_mapping):
        super().__init__()
        self.regex_mapping = regex_mapping

    def lex_document(self, document: Document) -> Callable[[int], StyleAndTextTuples]:
        def lex(_: int):
            line = document.text
            tokens = []
            while len(line) != 0:
                for pattern, style_string in self.regex_mapping.items():
                    match: re.Match = pattern.search(line)

                    if not match:
                        continue
                    else:
                        # print(f"found_match: {match}")
                        pass
                    match_string = line[:match.span()[1]]
                    line = line[match.span()[1]:]
                    tokens.append((style_string, match_string))
                    break
            return tokens
        return lex

os.system("")
stringCommands = {}

numbers = re.compile(r"^\d+(\.\d+)?")
text = re.compile(r"^.")

operators = re.compile("^ninjagit")
op1 = re.compile("^ninjaexe")
op2 = re.compile("^python")
op3 = re.compile("^ruby")
op4 = re.compile("^pip")
op5 = re.compile("^node")
op6 = re.compile("^cpp")
op7 = re.compile('^\"([^"]*)\"')
op8 = re.compile("^(npm|gem)")
op9 = re.compile("^--[a-zA-Z_]*")
regex7 = re.compile('^-[a-zA-Z_]*')
op10 = re.compile("^ls")
op11 = re.compile("^[a-zA-Z]+\.")
op12 = re.compile("^\$")
op13 = re.compile('^(cat|py|exit|echo|mkdir|touch|pwd|more|cd|rm|rmdir|cp|mv)') 
regex_mapping = {
    operators: "#ffff00",
    op1: "#ffff00",
    op2: "#ffff00",
    op3: "#ffff00",
    op4: "#ffff00",
    op5: "#ffff00",
    op6: "#ffff00",
    op7: "#79b6ff",
    op8: "#ffff00",
    op9: "#02CC96",
    regex7: "#02CC96",
    op10: "#ffdc92",
    op11: "#bb9eff",
    op12: "#ffc1aa",
    op13: "#ff6161",
    numbers: "#ffa500",
    text: "#ffffff"
}

MyCalculatorLexer = CustomRegexLexer(regex_mapping)

class CustomCompleter(Completer):
    def get_completions(self, document, complete_event):
        if document.text_before_cursor.endswith('e'):
            yield Completion('xit', -1)
        
        if document.text_before_cursor.endswith('ex'):
            yield Completion('it', -1)

        if document.text_before_cursor.endswith('exi'):
            yield Completion('t', -1)

        if document.text_before_cursor.endswith("c"):
            yield Completion('d', -1)

        if document.text_before_cursor.endswith("n"):
            yield Completion('injaexe', -1)

        if document.text_before_cursor.endswith("ni"):
            yield Completion('njaexe', -1)

        if document.text_before_cursor.endswith("nin"):
            yield Completion('jaexe', -1)

        if document.text_before_cursor.endswith("ninj"):
            yield Completion('aexe', -1)

        if document.text_before_cursor.endswith("ninja"):
            yield Completion('exe', -1)

        if document.text_before_cursor.endswith("ninjae"):
            yield Completion('xe', -1)

        if document.text_before_cursor.endswith("ninjaex"):
            yield Completion('e', -1)

        if document.text_before_cursor.endswith("n"):
            yield Completion('injagit', -1)

        if document.text_before_cursor.endswith("ni"):
            yield Completion('njagit', -1)
            
        if document.text_before_cursor.endswith("nin"):
            yield Completion('jagit', -1)

        if document.text_before_cursor.endswith("ninj"):
            yield Completion('agit', -1)

        if document.text_before_cursor.endswith("ninja"):
            yield Completion('git', -1)

        if document.text_before_cursor.endswith("ninjag"):
            yield Completion('it', -1)

        if document.text_before_cursor.endswith("ninjagi"):
            yield Completion('t', -1)

class BufferList(object):
    def __init__(self,
                 List: list = [],
                 ):
        
        self.list = List
        
    def parse(self):
        bfd = {}

        for i in range(len(self.list)):
            bfd["_"+str(i+1)] = self.list[i]

        return bfd

    def isexists(self, target):
        if target in self.list:
            return True
        else:return False

    def isinfrontof(self, target, indexes):
        isit = False

        if target in self.list:
            try:
                indx = self.list.index(target)
                if indx == indexes:
                    isit = True
                else:isit = False
            except Exception as e:return e
        
        return isit
    
    def indexexists(self, target):
        if target in self.list:
            return self.list.index(target)
        else:return False

class BufferString(object):
    def __init__(self,
                 listed_data = [],
                 __help: str = "",
                 __discription: str = ""
                 ):

        self.listed_data = listed_data
        self.forHelp = __help
        self.dis = __discription
        self.status_help = True
        self.status_dis = True
        self.pyVersion = "3"
        self.data = []
    
    def __setcommands__(self, __key, __value):
        stringCommands[__key] = __value
        return stringCommands
    
    def getDictArgv(self):
        return BufferList(self.listed_data).parse()
    
    def addFlag(self, *flags, mode: str = "in_front_of"):
        flg = list(flags)
        for i in range(len(flg)):
            self.__setcommands__(str(i+1), flg[i])

        if mode == "in_front_of":
            for key, val in BufferString(self.listed_data).getDictArgv().items():

                if str(val) in flg:
                    keyx = int(str(key).replace("_", ""))
                    keyx += 1
                    if not f"_{keyx}" in BufferString(self.listed_data).getDictArgv().keys():
                        self.data.append("Null")
                        pass
                    else:
                        self.data.append(BufferString(self.listed_data).getDictArgv()[f"_{keyx}"])
                        pass
                
                else:
                    pass
            return self.data


class PipManager(object):
    def add(lib: str,
            use_mirror: bool = False):
        
        if not use_mirror:
            os.system(f"libpython3.so -m pip install {lib}")
        else:
            os.system(f"libpython3.so -m pip install --trusted-host https://pypi.tuna.tsinghua.edu.cn -i https://pypi.tuna.tsinghua.edu.cn/simple/ {lib}")

    def update(lib: str,
               use_mirror: bool = False):
        
        if not use_mirror:
            os.system(f"libpython3.so -m pip install {lib} --upgrade")
        else:
            os.system(f"libpython3.so -m pip install --trusted-host https://pypi.tuna.tsinghua.edu.cn -i https://pypi.tuna.tsinghua.edu.cn/simple/ {lib} --upgrade")

    def delete(lib: str):
        os.system(f"libpython3.so -m pip uninstall {lib}")

    def regular(data = ""):
        os.system(f"libpython3.so -m pip {data}")

class GitManager(object):
    def __init__(self, urlPath: str = None):
        self.up = str(urlPath)

    def getName(self) -> str:
        if "/" in self.up:
            return self.up.split("/")[-1]
        else:
            return str(time.time())
        
    def createClone(self):
        try:
            name = self.getName()
            os.mkdir(name)
            git.Repo.clone_from(f"https://github.com/{self.up}", name)
            return True
        except:
            return False
        
    @property
    def git_url_options(self):
        # Simple url: username/reponame
        dbs = {}

        if not self.up.count("/") == 1:
            raise ValueError("Bad Git Link")
        
        username = self.up.split("/")[0]
        reponame = self.up.split("/")[-1]
        dbs['username'] = username
        dbs['reponame'] = reponame

        return dbs

class console(object):
    def logger(message: any = None):
        if type(message) in (list, tuple, dict, set):
            print(json.dumps(message, indent=4))

    def isHumanReadable(file_path):
        try:
            with open(file_path, 'r') as file:
                content = file.read()
                if all(char in string.printable for char in content):
                    return True
                else:
                    return False
        except Exception as e:
            return False

    def changeDir(path: str = None):
        if not os.path.exists(path):
            print("\001\033[0;38;5;196m\002Path Does not Exists")
        
        if not os.path.isdir(path):
            print("\001\033[0;38;5;196m\002Does not DIR")
        
        else:
            os.chdir(path)
            return True
    
    def enableCmd(Command: str):
        if Command.startswith("cd"):
            pather = Command.replace("cd ", "")
            if pather == "cd" or pather == "":
                print("\001\033[0;38;5;196m\002Cannot get Path")
            else:
                console.changeDir(pather)
        
        
        elif Command.startswith("ninjaexe"):
            if len(Command.replace("ninjaexe ", "").split()) == 1:
                if not Command.replace("ninjaexe ", "") == "ninjaexe" or not Command.replace("ninjaexe ", "") == "":
                    path = Command.replace("ninjaexe ", "").split()[0]

                    if not console.isHumanReadable(path):
                        os.system(path)
                    else:
                        dataReading = open(path, 'r').read().split("\n")[0]
                        os.system(f"{dataReading.replace('#', '')} {path}")
                else:pass
            
            elif len(Command.replace("ninjaexe ", "").split()) >= 1:
                    if not Command.replace("ninjaexe ", "") == "ninjaexe" or not Command.replace("ninjaexe ", "") == "":
                        path = Command.replace("ninjaexe ", "").split()[0]
                        stringArgv = " "
                        for item in Command.replace("ninjaexe ", "").split()[1:]:
                            stringArgv += f"{item} "

                        if not console.isHumanReadable(path):
                            os.system(path + stringArgv)
                        else:
                            dataReading = open(path, 'r').read().split("\n")[0]
                            os.system(f"{dataReading.replace('#', '')} {path} {stringArgv}")
                    else:pass

        elif Command.startswith("pip"):
            datas = Command.replace("pip ", "")
            PipManager.regular(datas) if datas != "pip" else PipManager.regular()
			
        elif Command.startswith("python"):
            datas = Command.replace("python ", '')
            os.system(f"libpython3.so {datas}") if datas != "python" else os.system("libpython3.so")
		
        elif Command.startswith("ninjagit"):
            url = Command.replace("ninjagit ", "")

            if url == "ninjagit" or url == "":
                print("\001\033[0;38;5;196m\002Cannot get URL")

            else:
                try:
                    app = GitManager(url)
                    print("\001\033[0;38;5;231m\002Going to verify URL ...")
                    infos = app.git_url_options
                    print(f"\001\033[0;38;5;231m\002Username: \001\033[0;38;5;201m\002{infos['username']}")
                    print(f"\001\033[0;38;5;231m\002Reponame: \001\033[0;38;5;201m\002{infos['reponame']}")
                    app.createClone()
                    print(f"\001\033[0;38;5;231m\002Putted Files on Dir called \001\033[0;38;5;201m\002'{app.getName()}'\001\033[0;38;5;231m\002")
                except Exception as ER:
                    print(f"\001\033[0;38;5;196m\002Error Detected: {ER}")


        elif Command == "exit" or Command == "sh":
            sys.exit()

        else:
            os.system(command=Command)

    def getCwd() -> str:
        return os.getcwd()

    def getPrompt(while_loop_starter: bool = False):
        
        cwd = console.getCwd()
        if cwd.startswith("/data/data/ir.ninjacoder.ghostide/files"):
            cwd = cwd.replace("/data/data/ir.ninjacoder.ghostide/files", "~")
        elif cwd.startswith(f"C:\\Users\\{getpass.getuser()}"):
            cwd = cwd.replace(f"C:\\Users\\{getpass.getuser()}", "~")
        else:
            pass

        if while_loop_starter == False:
            print(f"\001\033[0;38;5;87m\002[\001\033[0;38;5;82m\002{cwd}\001\033[0;38;5;87m\002]-[\001\033[0;38;5;82m\002Ninja-Shell\001\033[0;38;5;87m\002]\001\033[0;38;5;231m\002")
            user_input = prompt(f'$ ', completer=CustomCompleter(), lexer=MyCalculatorLexer)

            return {"text":user_input,"splitted":user_input.split()}
        
        else:
            while 1:
                print(f"\001\033[0;38;5;87m\002[\001\033[0;38;5;82m\002{cwd}\001\033[0;38;5;87m\002]-[\001\033[0;38;5;82m\002Ninja-Shell\001\033[0;38;5;87m\002]\001\033[0;38;5;231m\002")
                user_input = prompt(f'$ ', completer=CustomCompleter(), lexer=MyCalculatorLexer)
                return {"text":user_input,"splitted":user_input.split()}

try:
    makeBanner()
    while 1:
        data = console.getPrompt(True)
        console.enableCmd(data['text'])
except KeyboardInterrupt:
    sys.exit()

except Exception as E:
    print(f"\001\033[0;38;5;196m\002Local Error: {E}")
	
	
	
	
print(print)