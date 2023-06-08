// Print 1 to x
function printUpTo(x) {
  // your code here
  if (x < 1) {
    return false;
  }
  for (var i = 1; i <= x; i++) {
    console.log(i);
  }
}
printUpTo(1000); // debería imprimir todos los enteros de 1 to 1000
y = printUpTo(-10); // debería imprimir false
console.log(y); // debería imprimir false

// PrintSum
function printSum(x) {
  var sum = 0;
  //your code here
  for (var i = 0; i <= x; i++) {
    sum += i;
    console.log("Hasta", i, "suma", sum);
  }
  return sum;
}
y = printSum(255); // debería imprimir todos los enteros de 0 a 255 y que cada entero imprima la suma parcial.
console.log(y); // debería imprimir 32640

// PrintSumArray
function printSumArray(x) {
  var sum = 0;
  for (var i = 0; i < x.length; i++) {
    //your code here
    sum += x[i];
  }
  return sum;
}
console.log(printSumArray([1, 2, 3])); // debería imprimir 6

// LargestElement
function largestElement(x) {
  for (var i = 0; i < x.length; i++) {
    for (var j = 0; j < x.length; j++) {
      if (x[i] < x[j]) {
        var temp = x[i];
        x[i] = x[j];
        x[j] = temp;
      }
    }
  }
  return x[x.length - 1];
}
var res = largestElement([1, 30, 5, 7]);
console.log(res);
