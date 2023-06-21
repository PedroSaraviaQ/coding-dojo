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
