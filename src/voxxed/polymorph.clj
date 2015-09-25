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

(defn- print-event-dispatch [type]
  (keyword (.getSimpleName type)))

(defmulti print-event "Simply outputs source event" print-event-dispatch)

(defmethod print-event :default
  (println "I am almighty method, capable of handling anything!"))





