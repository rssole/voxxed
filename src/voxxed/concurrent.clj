(ns voxxed.concurrent
  (:use [voxxed.support.concurrent :only [dothreads!]]))

(def thread-ids-senders (atom #{}))
(def thread-ids-receivers (atom #{}))

(def oo7 (agent 0))

(defn- register-tid-in [atom]
  (swap! atom conj (.getId (Thread/currentThread))))

(dothreads! #(do (register-tid-in thread-ids-senders)
                 (send oo7 (fn [a]
                             (register-tid-in thread-ids-receivers)
                             (inc a)))) :times 30 :threads 4)
; issue above: parallel work of agents serialized on atom

(println "So far reached value of oo7:" @oo7)







