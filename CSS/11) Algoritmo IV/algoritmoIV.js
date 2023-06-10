// greater than
function greaterThan(arr, y) {
  var total = 0;
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] > y) {
      total++;
    }
  }
  return total;
}
console.log(greaterThan([2, 8, 1, 4, 6], 4)); // should output 2

// max, min and average
function maxMinAverage(arr) {
  var min = arr[0];
  var max = arr[0];
  var sum = arr[0];
  for (var i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
      min = arr[i];
    }
    if (arr[i] > max) {
      max = arr[i];
    }
    sum += arr[i];
  }
  return {
    min,
    max,
    average: sum / arr.length,
  };
}
var result = maxMinAverage([2, 8, 1, 6, 3]);
console.log(result.min); // should be 1
console.log(result.max); // should be 8
console.log(result.average); //should be 4

// replace negative
function replaceNegative(arr) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] < 0) {
      arr[i] = "Dojo";
    }
  }
  return arr;
}
console.log(replaceNegative([1, 2, -3, -5, 5])); // should output [1, 2, "Dojo", "Dojo", 5]

// remove between
function replaceBetween(arr, a, b) {
  var newArr = [];
  for (var i = 0; i < a; i++) {
    newArr.push(arr[i]);
  }
  for (var i = b + 1; i < arr.length; i++) {
    newArr.push(arr[i]);
  }
  return newArr;
}
console.log(replaceBetween([20, 30, 40, 50, 60, 70], 2, 4)); // should output [20, 30, 70]
