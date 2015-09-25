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

;(println (map inc-double [1 2 3 4 5 6]))

; Variadic arguments
(defn var-arg-sum [& others]
  (apply + others))

(println (var-arg-sum 1 2 3 4 5))
;(println (var-arg-sum 1 2 3 4 5 6))

(defn power
  ([x] (identity x))
  ([x y] (apply * (repeat y x))))
; do you spot an issue here?

;guess what? data structures are functions themselves

({:a 1 :b 2 :c 3} :c)

([1 2 3 4 5 6] 3)

; keywords are also both data but and function
(:c {:a 1 :b 2 :c 3})