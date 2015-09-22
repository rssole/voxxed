(ns voxxed.async
  (:require [clojure.core.async :refer [<! >!! <!! chan tap go mult]]))

(def c (chan 5))

(>!! c "hello")

(println (<!! c))

(defn go-print
  "Pull messages from channel c and print them."
  [c]
  (go
    (loop []
      (when-some [val (<! c)]
        (println "Received a message:" val " on channel:" c)
        (recur)))))

(def c2 (chan 2))
(def c3 (chan 2 (map #(.concat % "c3"))))
(def c4 (chan 3 (map #(.toUpperCase %))))

(go-print c2)
(go-print c3)

(let [m (clojure.core.async/mult c4)]
  (tap m c2)
  (tap m c3))

;(require ['clojure.core.async :refer '(tap >!! <!! chan mult)])