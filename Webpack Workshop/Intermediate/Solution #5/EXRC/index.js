import '@babel/polyfill';

var array = [1,2,3];

Array.from(array).forEach(($item) => {
 alert($item);
})