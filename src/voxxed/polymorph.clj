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

;<editor-fold desc="Multimethods">

;Multimethods

(defn handle-event-dispatch [e]
  (keyword (str 'voxxed.polymorph) (.. e (getSource) (getClass) (getSimpleName))))

(defmulti handle-event "Handles any source event" handle-event-dispatch)

(defmethod handle-event :default [_]
  (println "I am almighty method, capable of handling anything!"))

(defmethod handle-event ::JButton [_]
  (println "Only buttons here :)"))

;(defmethod handle-event ::JRadioButton [_]
;  (println "Listenin' to the radio!"))
;
;(defmethod handle-event ::JLabel [_]
;  (println "Labels all around..."))

;(derive ::JRadioButton ::JButton)

;(use '[voxxed.polymorph :as poly] '[voxxed.support.polymorph :as spoly] :reload)

;</editor-fold>



