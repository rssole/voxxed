(ns voxxed.data)

;Few data structures

;List,
(def some-list '("a" "b" "c" "d" "e"))

;vector,
(def some-vec [1 2 3 4 5 6 7])

;set,
(def some-set #{1 2 3 4 5 6 7})

;map
(def some-map {:question "Who is the best?" :answer "Clojure"})

;all of these are "persistent" in contrast to "ephemeral" (c) Okasaki, 1998.

;and share structure to support immutability

(def l1 '(1 2 3 4 5))
(def l2 (conj l1 6))
(def l3 (conj l1 7))

(println "Identical tails of l2, l3? " (identical? (rest l2) (rest l3)))

;segregated from code...

;...and whole machinery to manipulate with it e.g.
(reduce +
        (map inc
             (filter even? [1 2 3 4 5 6 7])))
;=>15

(partition 2 [1 2 3 4 5 6 7])
;=> ((1 2) (3 4) (5 6))

