// 1) 1 to 255
function f1() {
  var arr = [];
  for (var i = 1; i <= 255; i++) {
    arr.push(i);
  }
  return arr;
}
console.log(f1());

// 2) even sum to 1000
function f2() {
  var sum = 0;
  for (var i = 0; i <= 1000; i += 2) {
    sum += i;
  }
  return sum;
}
console.log(f2());

// 3) odd sum to 5000
function f3() {
  var sum = 0;
  for (var i = 1; i <= 5000; i += 2) {
    sum += i;
  }
  return sum;
}
console.log(f3());

// 4) sum array
function f4(arr) {
  var sum = 0;
  for (var i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum;
}
console.log(f4([-5, 2, 5, 12]));

// 5) max array value
function f5(arr) {
  var max = arr[0];
  for (var i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
  }
  return max;
}
console.log(f5([-3, 3, 5, 7]));

// 6) average array value
function f6(arr) {
  var sum = 0;
  for (var i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum / arr.length;
}
console.log(f6([1, 3, 5, 7, 20]));

// 7) odd array
function f7() {
  var arr = [];
  for (var i = 1; i <= 50; i++) {
    if (i % 2 === 1) {
      arr.push(i);
    }
  }
  return arr;
}
console.log(f7());

// 8) greater than
function f8(arr, Y) {
  var newArr = [];
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] > Y) {
      newArr.push(arr[i]);
    }
  }
  return newArr;
}
console.log(f8([1, 3, 5, 7], 3));

// 9) square array
function f9(arr) {
  for (var i = 0; i < arr.length; i++) {
    arr[i] *= arr[i];
  }
  return arr;
}
console.log(f9([1, 5, 10, -2]));

// 10) no-negative array
function f10(arr) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] < 0) {
      arr[i] = 0;
    }
  }
  return arr;
}
console.log(f10([1, 5, 10, -2]));

// 11) max, min and avg array
function f11(arr) {
  var min = arr[0];
  var max = arr[0];
  var sum = arr[0];
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
      min = arr[i];
    }
    if (arr[i] > max) {
      max = arr[i];
    }
    sum += arr[i];
  }
  return [max, min, sum / arr.length];
}
console.log(f11([1, 5, 10, -2]));

// 12) first to last and vice-versa
function f12(arr) {
  var t = arr[0];
  arr[0] = arr[arr.length - 1];
  arr[arr.length - 1] = t;
  return arr;
}
console.log(f12([1, 5, 10, -2]));

// 13) negative to dojo array
function f13(arr) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] < 0) {
      arr[i] = "Dojo";
    }
  }
  return arr;
}
console.log(f13([-1, -3, 2]));
