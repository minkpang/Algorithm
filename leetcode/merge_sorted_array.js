var merge = function(nums1, m, nums2, n) {

    nums1.splice(m)
    nums1.push(...nums2)

    return nums1.sort((f,s) => {return f-s;});

};
