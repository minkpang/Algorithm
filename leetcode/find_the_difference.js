var findTheDifference = function(s, t) {
    let a = s.split('').sort().join('')
    let b = t.split('').sort().join('')

    for (i = 0; i < b.length; i++){
        if(a[i]!=b[i]){
            return b[i]
        }
    }
};
