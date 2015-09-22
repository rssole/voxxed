(ns voxxed.data)

(def some-list '("a" "b" "c" "d" "e"))

(def some-vec [1 2 3 4 5 6 7])

(def some-set #{1 2 3 4 5 6 7})

(def some-map {:question "Who is the best?" :answer "Clojure"})

;all of these are "persistent" in contrary with "ephemeral"

(def l1 '(1 2 3 4 5))
(def l2 (conj l1 6))
(def l3 (conj l1 7))

(println "Identical tails of l2, l3? " (identical? (rest l2) (rest l3)))