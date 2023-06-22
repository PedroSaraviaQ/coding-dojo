function sumMaxMin(arr) {
  var max = arr[0];
  var min = arr[0];
  for (var i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
    if (arr[i] < min) {
      min = arr[i];
    }
  }
  return min + max;
}

describe("sumMaxMin", () => {
  it("should return 10 for [2,5,3,8,4,6]", () => {
    expect(sumMaxMin([2, 5, 3, 8, 4, 6])).toEqual(10);
  });

  it("should return -1 for [2,7,-4,1,-8]", () => {
    expect(sumMaxMin([2, 7, -4, 1, -8])).toEqual(-1);
  });
});
