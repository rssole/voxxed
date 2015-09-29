(ns voxxed.lazyn)

(def plain (range 1 1000))

(def iterated (iterate #(do
                         (println "Now I am: " %)
                         (inc %)) 1))

; Oh yes... btw... - NEVER! do what I did above! Side effects in lazy seq - veeery bad idea...

;(use 'voxxed.lazyn :reload)