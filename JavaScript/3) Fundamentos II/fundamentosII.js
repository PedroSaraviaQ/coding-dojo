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

// 4) double
function f4(arr) {
  var newArr = [];
  for (var i = 0; i < arr.length; i++) {
    newArr[i] = arr[i] * 2;
  }
  return newArr;
}
console.log(f4([1, 2, 3]));

// 5) count positives
function f5(arr) {
  var count = 0;
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] > 0) {
      count++;
    }
  }
  arr[arr.length - 1] = count;
  return arr;
}
console.log(f5([-1, 1, 1, 1]));

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

// 12) yum yum
function f12(arr) {
  var count = 0;
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] === "food") {
      console.log("yummy");
      count++;
    }
  }
  if (count === 0) {
    console.log("I'm hungry");
  }
}
f12([1, 5, "food", 2, "food"]);
f12([4, true]);

// 14) multiply
function f14(arr, Y) {
  for (let i = 0; i < arr.length; i++) {
    arr[i] *= Y;
  }
  return arr;
}
console.log(f14([1, 2, 3], 3));
