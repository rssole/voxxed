(ns voxxed.data)

(def some-list '("a" "b" "c" "d" "e"))

(def some-vec [1 2 3 4 5 6 7])

(def some-set #{1 2 3 4 5 6 7})

(def some-map {:question "Who is the best?" :answer "Clojure"})

(defn check-structural-sharing [coll x y]
  (let [first (cons x coll)
        second (cons y coll)]
    (identical? (next first) (next second))))