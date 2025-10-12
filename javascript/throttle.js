// once executed method. throttle for some time.

const throttle = (func, limit) => {
    let lastCall = 0;

    return (...args) => {
        if (Date.now() - lastCall >= limit) {
            func(...args);
            lastCall = Date.now();
        }
    }
}

const scrollWindow = () => {
    console.log("Scrolling window...");
}

const throttledScrollWindows = throttle(scrollWindow, 3000);

throttledScrollWindows();
setTimeout(() => {
    throttledScrollWindows();
}, 2000);