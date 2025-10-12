
const person = {
    name: "A",
    greet: (greetingSlang) => {
        console.log(greetingSlang + " from " + this.name);
    }
}

const greet = person.greet;

greet("hey");
greet.call(person, "Holla");
greet.apply(person, ["Hollaa"]);
