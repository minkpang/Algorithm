//
//  main.swift
//  Algo
//
//  Created by minkpang on 2022/02/17.
//

import Foundation

func solution(_ s:String) -> String {
    let arr = s.components(separatedBy: " ")
    var answer = String()
    for a in arr{
        let temp = Array(a)
        for (index,c) in a.enumerated() {
            answer.append(index % 2 == 0 ? c.uppercased() : c.lowercased())
        }
        answer += " "
    }
    answer.removeLast()
    
    return answer
}
