(ns voxxed.encapsulation
  (:require [clojure.test :refer :all]))

(deftest test-act-on-mutable
  (testing "Acting on mutable state"
    (reset! mutable 0)
    (act-on-mutable 5)
    (is (= 5 @mutable))))
