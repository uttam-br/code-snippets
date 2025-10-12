

const balancedParen = (paren) => {
    if (paren.length == 0) {
        return "True";
    }

    const stack = [];

    for (let i=0; i<paren.length; i++) {

        // console.log(i, stack);

        const char = paren[i];

        if (char === '(' || char === '[' || char === '{') {
            stack.push(char);
            continue;
        } 

        if (stack.length == 0) {
            return "False";
        }
        
        if (char == ')' && stack[stack.length - 1] != '(') {
            return "False";
        }
        if (char == ']' && stack[stack.length - 1] != '[') {
            return "False";
        }
        if (char == '}' && stack[stack.length - 1] != '{') {
            return "False";
        }

        stack.pop();
    }

    if (stack.length > 0) {
        return "False";
    }

    return "True";
};



console.log("()[{}]", balancedParen("()[{}]"));
console.log("({)", balancedParen("({)"));
console.log("()()", balancedParen("()()"));
console.log("(())", balancedParen("(())"));
console.log("())(", balancedParen("())("));