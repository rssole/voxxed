(ns voxxed.polymorph
  (:import (clojure.lang PersistentVector)))

;Protocols

(defprotocol Zippable
  (zip [me it]))

(extend-protocol Zippable
  PersistentVector
  (zip [me it]
    (flatten (map #(do [% %2]) me it))))

(extend-protocol Zippable
  String
  (zip [me it]
    (apply str (zip (vec me) (vec it)))))

;Multimethods





