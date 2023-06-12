// reset negatives
function resetNegatives(arr) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] < 0) {
      arr[i] = 0;
    }
  }
  return arr;
}
console.log(resetNegatives([1, 2, -1, -3])); // should be [1, 2, 0, 0]

// move forward
function moveForward(arr) {
  arr.shift();
  arr.push(0);
  return arr;
}
console.log(moveForward([1, 2, 3])); // should be [2, 3, 0]

// return reversed
function returnReversed(arr) {
  var newArr = [];
  for (var i = arr.length - 1; i >= 0; i--) {
    newArr.push(arr[i]);
  }
  return newArr;
}
console.log(returnReversed([1, 2, 3])); // should be [3, 2, 1]

// repeat values
function repeatValues(arr) {
  var newArr = [];
  for (var i = 0; i < arr.length; i++) {
    newArr.push(arr[i]);
    newArr.push(arr[i]);
  }
  return newArr;
}
console.log(repeatValues([4, "Ulysses", 42, false]));
// should be [4, 4, "Ulysses", "Ulysses", 42, 42, false, false]
