const fs = require('fs')
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n')
const input = (() => {
  let line = 0
  return () => stdin[line++]
})()

const N = Number(input())
const cows = Array(11).fill(-1)

let cnt = 0
for (let i = 0; i < N; i++){
    let [a, b] = input().split(' ').map(Number)

    if (cows[a] == -1) {
        cows[a] = b
    }
    else {
        if (cows[a] != b) {
            cnt += 1
            cows[a] = b
        }
    }
}

console.log(cnt)
