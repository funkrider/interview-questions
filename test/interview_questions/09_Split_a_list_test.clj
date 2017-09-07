(ns interview-questions.09-Split-a-list-test
  (:require [clojure.test :refer :all]
            [interview-questions.09-Split-a-list :refer :all]))


(testing "splitting a list"

  (def a '(1 2 3))
  (def b '(4 5 6))
  (def c [a b])
  (def d '(1 2 3 4 5 6))

  (is (= c (divide-list d)))

  )