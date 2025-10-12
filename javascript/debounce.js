// executes func after the delay
// wait for delay time before executing the search method
const debounce = (func, delay) => {
    let timer;
    return (...args) => {
        clearTimeout(timer);
        timer = setTimeout(() => func(...args), delay);
    };
}

const search = (text) => console.log("Searching " + text + "...");

const debouncedSearch = debounce(search, 3000);

debouncedSearch("a");
debouncedSearch("ab");