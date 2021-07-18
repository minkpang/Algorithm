var isAnagram = (s, t) => {
  let a = s.split("").sort().join("");
  let b = t.split("").sort().join("");

  if (a == b) {
    return true;
  } else {
    return false;
  }
};
