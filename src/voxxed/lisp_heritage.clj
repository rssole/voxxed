(ns voxxed.lisp-heritage)

(def coded-string [72 101 108 108 111 44 32 67 108 111 106 117 114 101 33])

(def decoded-sequence (map char coded-string))

(println decoded-sequence)

;homoiconic
(println
  (apply str (map char coded-string)))

;prefix notation
(defn sum [a b c d e]
  (+ a b c d e))
; return a + b + c + d + e
(println (sum 1 2 3 4 5))
; a + b * c % 4 - no operator precedence confusion





