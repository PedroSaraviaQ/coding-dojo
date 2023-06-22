// 1) positive to big
function f1(arr) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] > 0) {
      arr[i] = "big";
    }
  }
  return arr;
}
console.log(f1([-1, 3, 5, -5]));

// 9) add 7
function f9(arr) {
  var newArr = [];
  for (var i = 0; i < arr.length; i++) {
    newArr[i] = arr[i] + 7;
  }
  return newArr;
}
console.log(f9([1, 2, 3]));

// 10) reversed array
function f10(arr) {
  for (var i = 0; i < Math.floor(arr.length / 2); i++) {
    var t = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = t;
  }
  return arr;
}
console.log(f10([3, 1, 6, 4, 2]));

// 11) negative array
function f11(arr) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] > 0) {
      arr[i] *= -1;
    }
  }
  return arr;
}
console.log(f11([1, -3, 5]));
