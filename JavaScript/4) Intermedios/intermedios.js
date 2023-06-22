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

// 3)
function fibonacci(n) {
  if (n === 1 || n === 2) {
    return 1;
  }
  return fibonacci(n - 1) + fibonacci(n - 2);
}
console.log(fibonacci(7));

// 4)
function secondToLast(arr) {
  if (arr[arr.length - 2] !== undefined) {
    return arr[arr.length - 2];
  }
  return null;
}
console.log(secondToLast([42, true, 4, "Liam", 7]));

// 5)
function returnN(arr, n) {
  if (arr[n] !== undefined) {
    return arr[n];
  }
  return null;
}
console.log(returnN([5, 2, 3, 6, 4, 9, 7], 3));

// 6)
function secondBiggest(arr) {
  var max1 = arr[0];
  var max2 = 0;
  for (var i = 1; i < arr.length; i++) {
    if (arr[i] > max1) {
      max2 = max1;
      max1 = arr[i];
    } else if (arr[i] > max2) {
      max2 = arr[i];
    }
  }
  return max2;
}
console.log(secondBiggest([42, 1, 4, 3.14, 7]));

// 7)
function double(arr) {
  var newArr = [];
  for (var i = 0; i < arr.length; i++) {
    newArr.push(arr[i]);
    newArr.push(arr[i]);
  }
  return newArr;
}
console.log(double([4, "Ulysses", 42, false]));
