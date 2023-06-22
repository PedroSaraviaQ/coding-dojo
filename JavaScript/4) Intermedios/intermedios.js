// 1)
function sigma(num) {
  return (num * (num + 1)) / 2;
}
console.log(sigma(5));

// 2)
function factorial(num) {
  if (num === 1) return 1;
  return num * factorial(num - 1);
}
console.log(factorial(5));

// 4)
function secondToLast(arr) {
  if (arr[arr.length - 2] !== undefined) {
    return arr[arr.length - 2];
  }
  return null;
}
console.log(secondToLast([42, true, 4, "Liam", 7]));
