(ns voxxed.support.concurrent
  (:import [java.util.concurrent Executors]))

;Copyright (c) Fogus & Houser
;
(def thread-pool (Executors/newFixedThreadPool
                   (+ 2 (.availableProcessors (Runtime/getRuntime)))))

(defn dothreads! [f & {thread-count :threads
                       exec-count :times
                       :or {thread-count 1 exec-count 1}}]
  (dotimes [t thread-count]
    (.submit thread-pool #(dotimes [_ exec-count] (f)))))