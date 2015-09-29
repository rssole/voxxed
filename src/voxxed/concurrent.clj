(ns voxxed.concurrent
  (:use [voxxed.support.concurrent :only [dothreads!]]))

;(use '[voxxed.concurrent] '[voxxed.support.concurrent :only [dothreads!]] :reload)

(def thread-ids (agent {::senders #{} ::receivers #{}}))

(def oo7 (agent 0))

(defn- register-tid-in [loc tid]
  (send thread-ids
        #(update %
                 loc
                 (fn [s x]
                   (conj s x)) tid)))

(dothreads! #(do (register-tid-in ::senders (.getId (Thread/currentThread)))
                 (send oo7 (fn [a]
                             (register-tid-in ::receivers (.getId (Thread/currentThread)))
                             (Thread/sleep 25)
                             (inc a)))) :times 30 :threads 4)

(println "So far reached value of oo7:" @oo7)

;(add-watch oo7 :m (fn [k r old new]
;                    (when (= new 100)
;                      (println "Turned 100"))))

(def account-x (ref {:id 123 :balance 400}))
(def account-y (ref {:id 234 :balance 500}))

(defn transfer [amount src tgt]
  (dosync
    (alter src #(do
                 (Thread/sleep 1500)
                 (println "Taking money...")
                 (update % :balance - %2)) amount)
    (alter tgt #(do
                 (Thread/sleep 1500)
                 (println "Paying money...")
                 (update % :balance + %2)) amount)))

;(use '[voxxed.concurrent] '[voxxed.support.concurrent] :reload)

(defn x-change-sim "Simulates concurrent modification of account(s)" []
  (do
    (dothreads!
      (fn [] (send oo7 (fn [_ amount]
                         (Thread/sleep 500)
                         (println "Here is some money for laundering...")
                         (dosync
                           (alter account-x #(update % :balance + %2) amount))) 100))
      :times 2
      :threads 5)
    (transfer 500 account-x account-y)))