[
    {
        "name": "helloworld",
        "snippet": "console.log(\"Hello, World!\");"
    },
    {
        "name": "variabledeclaration",
        "snippet": "let x: number = 5; const y: string = \"Hello\"; var z: boolean = true;"
    },
    {
        "name": "arrowfunction",
        "snippet": "const add = (a: number, b: number): number => a + b;"
    },
    {
        "name": "forloop",
        "snippet": "for(let i = 0; i < 10; i++) { console.log(i); }"
    },
    {
        "name": "whileloop",
        "snippet": "let i = 0; while(i < 5) { console.log(i); i++; }"
    },
    {
        "name": "do-whileloop",
        "snippet": "let i = 0; do { console.log(i); i++; } while(i < 5);"
    },
    {
        "name": "ifelse",
        "snippet": "let x = 10; if(x > 5) { console.log(\"x is greater than 5\"); } else { console.log(\"x is less than or equal to 5\"); }"
    },
    {
        "name": "ternaryoperator",
        "snippet": "let result = (x > 5) ? \"Greater\" : \"Smaller\";"
    },
    {
        "name": "switchcase",
        "snippet": "let day = 2; switch(day) { case 1: console.log(\"Monday\"); break; case 2: console.log(\"Tuesday\"); break; default: console.log(\"Invalid day\"); }"
    },
    {
        "name": "functionexample",
        "snippet": "function greet(name: string): string { return `Hello, ${name}`; }"
    },
    {
        "name": "classdefinition",
        "snippet": "class Person { name: string; age: number; constructor(name: string, age: number) { this.name = name; this.age = age; } }"
    },
    {
        "name": "objectliteral",
        "snippet": "let person = { name: \"John\", age: 30 };"
    },
    {
        "name": "interfaceexample",
        "snippet": "interface Person { name: string; age: number; } const person: Person = { name: \"John\", age: 30 };"
    },
    {
        "name": "genericfunction",
        "snippet": "function identity<T>(arg: T): T { return arg; } let result = identity<number>(42);"
    },
    {
        "name": "asynchronousfunction",
        "snippet": "async function fetchData(): Promise<string> { return \"Data loaded\"; }"
    },
    {
        "name": "awaitexample",
        "snippet": "const result = await fetchData(); console.log(result);"
    },
    {
        "name": "trycatch",
        "snippet": "try { let x = 10 / 0; } catch(error) { console.error(\"Error: \", error); }"
    },
    {
        "name": "mapexample",
        "snippet": "let numbers = [1, 2, 3]; let squares = numbers.map(num => num * num);"
    },
    {
        "name": "filterexample",
        "snippet": "let numbers = [1, 2, 3, 4, 5]; let evens = numbers.filter(num => num % 2 === 0);"
    },
    {
        "name": "reduceexample",
        "snippet": "let numbers = [1, 2, 3, 4]; let sum = numbers.reduce((total, num) => total + num, 0);"
    },
    {
        "name": "spreadoperator",
        "snippet": "let arr1 = [1, 2]; let arr2 = [...arr1, 3, 4];"
    },
    {
        "name": "destructuring",
        "snippet": "let [a, b] = [1, 2]; let { name, age } = { name: \"John\", age: 30 };"
    },
    {
        "name": "restparameter",
        "snippet": "function sum(...numbers: number[]): number { return numbers.reduce((a, b) => a + b, 0); }"
    },
    {
        "name": "objectassign",
        "snippet": "let person = { name: \"John\" }; let updatedPerson = Object.assign({}, person, { age: 30 });"
    },
    {
        "name": "enumexample",
        "snippet": "enum Direction { Up, Down, Left, Right } let direction: Direction = Direction.Up;"
    },
    {
        "name": "setexample",
        "snippet": "let uniqueNumbers = new Set([1, 2, 3, 4, 4]);"
    },
    {
        "name": "mapsetexample",
        "snippet": "let map = new Map(); map.set('name', 'John'); let name = map.get('name');"
    },
    {
        "name": "filternullundefined",
        "snippet": "let arr = [1, null, 2, undefined, 3]; let filtered = arr.filter(item => item != null);"
    },
    {
        "name": "functionoverloading",
        "snippet": "function greet(person: string): string; function greet(person: string, age: number): string; function greet(person: string, age?: number): string { return age ? `Hello ${person}, age ${age}` : `Hello ${person}`; }"
    },
    {
        "name": "tupleexample",
        "snippet": "let person: [string, number] = ['John', 30];"
    },
    {
        "name": "privateproperty",
        "snippet": "class Car { private speed: number = 0; public accelerate() { this.speed += 10; } }"
    },
    {
        "name": "gettersetter",
        "snippet": "class Person { private _age: number = 0; get age() { return this._age; } set age(value: number) { this._age = value; } }"
    },
    {
        "name": "readonlyproperty",
        "snippet": "class Person { readonly name: string = \"John\"; }"
    },
    {
        "name": "typeofoperator",
        "snippet": "let age = 30; if(typeof age === 'number') { console.log(\"Age is a number\"); }"
    },
    {
        "name": "instanceofoperator",
        "snippet": "class Animal { name: string; constructor(name: string) { this.name = name; } } let dog = new Animal('Dog'); if(dog instanceof Animal) { console.log('It is an Animal'); }"
    },
    {
        "name": "nullishcoalescing",
        "snippet": "let name = undefined; let displayName = name ?? 'Anonymous';"
    },
    {
        "name": "optionalchaining",
        "snippet": "let person = { address: { city: 'New York' } }; let city = person?.address?.city;"
    }
]
