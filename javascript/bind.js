
const person = {
    name : "Person A",
    greet() {
        console.log("Hello from " + this.name)
    }
}

const greet = person.greet.bind(person);
greet();