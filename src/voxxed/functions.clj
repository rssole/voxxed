(ns voxxed.functions)

;Functions are first-class citizens

; POF :)
(defn factorial [x]
  (letfn [(go [n f]
              (if (= n 1)
                f
                (recur (dec n) (* f n))))]
    (go x 1)))

; Anonymous f-literal + HOF
(defn factorial-r [x]
  (reduce #(* %1 %2) (range 1 (inc x))))
; that is right * could have been used on it's own :)

; F returning f
(def inc-double (comp (partial * 2) inc))

;(println (map inc-double [1 2 3 4 5 6]))

; Variadic arguments
(defn var-arg-sum [& others]
  (apply + others))

(var-arg-sum 1 2 3 4 5)
;=>15

(defn power
  ([x] (identity x))
  ([x y] (apply * (repeat y x))))

;guess what? data structures are functions themselves

({:a 1 :b 2 :c 3} :c)
;=>3

([1 2 3 4 5 6] 3)
;=>4

;keywords have special treatment in Clojure but are also a function
(:c {:a 1 :b 2 :c 3})

;guess what again? quickly! functions allows for argument destructuring

;... by means of vector
(defn destruction [[x y :as original]]
  (println x "," y "and original: " original))

;... by means of map...
(defn map-destruction [{fn :first-name ln :last-name :as person}]
  (println fn "," ln "and everything: " person))

;... or as a shortcut:
(defn map-destruction-k [{:keys [first-name last-name] :as person}]
  (println first-name "," last-name "and everything: " person))