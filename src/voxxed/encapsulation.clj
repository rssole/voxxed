;It is not provided “out of the box”
;   Clojure is pretty global by default

(ns voxxed.encapsulation)
;namespaces are pretty static...

;single resource available...
(def mutable (atom {}))

(defn act-on-mutable [val]
  (swap! mutable (fn [_ x] x) val))

;reloading destroys state!

;much better - ctor function

(defn constructor []
  {:state (atom {})})

(defn act-on-state [state val]
  (let [current (:state state)]
    (swap! current (fn [_ x] x) val)))

; globals are actually still useful for what
; they were since ever :)

(def ^:const the-answer-to-the-ultimate-question-of-life-the-universe-and-everything 42)

