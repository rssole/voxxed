;Clojure is not OO language!
;How it supports polymorphism?!

(ns voxxed.polymorph
  (:import (clojure.lang PersistentVector)
           (java.util Map)))

;(use '[voxxed.polymorph :as poly] '[voxxed.support.polymorph :as spoly] :reload)

;Meet and greet (: Protocols

(defprotocol Zippable
  (zip [me it]))

(extend-protocol Zippable
  PersistentVector                                          ; [1 2 3 4 5 6]
  (zip [me it]
    (flatten (map #(do [% %2]) me it))))

(extend-protocol Zippable
  String
  (zip [me it]
    (apply str (zip (vec me) (vec it)))))

(extend-protocol Zippable
  Map
  (zip [me it]
    (apply merge (for [k (keys me)]
                   {k [(get me k) (get it k)]}))))

(zip [1 2 3] [4 5 6])
;=> (1 4 2 5 3 6)

(zip "abc" "def")

;Meet and greet (: Multimethods

(defn handle-event-dispatch [e]
  (.. e (getSource) (getClass) (getSimpleName)))

(defmulti handle-event "Handles any source event" handle-event-dispatch)

(defmethod handle-event :default [_]
  (println "I am almighty method, capable of handling anything!"))

(defmethod handle-event  "JButton" [_]
  (println "Only buttons here :)"))

(defmethod handle-event "JRadioButton" [_]
  (println "Listenin' to the radio!"))

;(defmethod handle-event "JLabel" [_]
;  (println "Labels all around..."))