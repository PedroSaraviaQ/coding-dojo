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
