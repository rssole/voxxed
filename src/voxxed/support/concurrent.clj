(ns voxxed.support.concurrent
  (:import [java.util.concurrent Executors]))

;Copyright (c) Fogus & Houser JOC 2nd edition
;
(def thread-pool (Executors/newFixedThreadPool
                   (+ 2 (.availableProcessors (Runtime/getRuntime)))))

(defn dothreads! [f & {thread-count :threads
                       exec-count :times
                       :or {thread-count 1 exec-count 1}}]
  (dotimes [_ thread-count]
    (.submit thread-pool #(dotimes [_ exec-count] (f)))))