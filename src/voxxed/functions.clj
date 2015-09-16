(ns voxxed.functions)

; POF :)
(defn factorial [x]
  (letfn [(go [n f]
              (if (= n 1)
                f
                (recur (dec n) (* f n))))]
    (go x 1)))

; Anonymous + HOF
(defn factorial-r [x]
  (reduce #(* %1 %2) (range 1 (inc x))))
; that is right * could have been used on it's own :)

; Another HOF
(def inc-double (comp (partial * 2) inc))

(print (map inc-double [1 2 3 4 5 6]))