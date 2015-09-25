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

(defn print-event-dispatch [e]
  (keyword (.getSimpleName (class (.getSource e)))))

(defmulti print-event "Simply outputs source event" print-event-dispatch)

(defmethod print-event :default [_]
  (println "I am almighty method, capable of handling anything!"))

;(defmethod print-event :JButton [_]
;  (println "Only buttons here :)"))
;
;(defmethod print-event :JRadioButton [_]
;  (println "Listenin' to the radio!"))
;
;(defmethod print-event :JLabel [_]
;  (println "Labels all around..."))

;(for [lsnr (.getMouseListeners (:label win1))]
;  (.removeMouseListener (:label win1) lsnr))
;
;(.addMouseListener (:label win1) (proxy [MouseAdapter] []
;                                   (mousePressed [e]
;                                     (print-event e))))
;(.addActionListener (:rbtn win1) (reify ActionListener
;                                   (actionPerformed [_ e]
;                                     (print-event e))))
;(.addActionListener (:btn win1) (reify ActionListener
;                                  (actionPerformed [_ e]
;                                    (print-event e))))





